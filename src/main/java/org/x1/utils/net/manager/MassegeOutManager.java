package org.x1.utils.net.manager;

import io.netty.channel.Channel;
import org.springframework.stereotype.Component;
import org.x1.executor.ExecutorUtils;
import org.x1.utils.net.logic.ProtocolLogicAdapter;
import org.x1.utils.net.model.ISerializer;
import org.x1.utils.net.model.Request;
import org.x1.player.CorePlayer;
import org.x1.player.PersistPlayer;
import org.x1.player.PlayerEntity;
import org.x1.utils.serializer.protostuffer.SerializerUtils;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ppdashi on 2017/7/15.
 * 消息分发器
 */
@Component
public class MassegeOutManager {
    /**
     *
     */
    private Map<Short, ISerializer> serializerModel;

    public MassegeOutManager() {
        serializerModel = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void init() {
        // serializerModel.put((short) 1, new Test());
    }
    private ProtocolManager protocolManager = ProtocolManager.getInstance();
    public void process(Channel channel, Request request) {
        ProtocolLogicAdapter protocolLogic;
        ISerializer serializer = null;
        CorePlayer corePlayer;
        try {
            protocolLogic = protocolManager.getLogic(request.getId());
            if (serializerModel.containsKey(request.getId()) && request.getDataLength() > 0)
                serializer = SerializerUtils.deserializer(request.getDATA(), serializerModel.get(request.getId()).getClass());
            if (PersistPlayer.playerMap.containsKey(channel)) {
                corePlayer = PersistPlayer.playerMap.get(channel);
            } else if (request.getId() > 1) {
                corePlayer = new CorePlayer(channel);
                PersistPlayer.playerMap.put(channel, corePlayer);
            } else
                corePlayer = new CorePlayer(channel, new PlayerEntity());
            protocolLogic.setId(request.getId());
            protocolLogic.setMsg(serializer);
            protocolLogic.setCorePlayer(corePlayer);
            //提交线程池释放io线程
            ExecutorUtils.threadTask.execute(protocolLogic);

        } catch (Exception e) {
            throw new RuntimeException("找不到Action_" + request.getId() + "这个脚本类");
        }
    }
}
