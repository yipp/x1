package org.x1.utils.net.manager;

import io.netty.channel.Channel;
import org.springframework.stereotype.Component;
import org.x1.executor.ExecutorUtils;
import org.x1.logic.activity.dto.ActivityDto;
import org.x1.logic.login.dto.AccountDto;
import org.x1.logic.moneytree.dto.MoneyTreeDto;
import org.x1.logic.playerinfo.dto.PlayerInfoDto;
import org.x1.player.manager.SerializerPlayerModel;
import org.x1.utils.SpringUtils;
import org.x1.utils.net.logic.ProtocolLogicAdapter;
import org.x1.utils.net.model.ISerializer;
import org.x1.utils.net.model.Request;
import org.x1.player.data.CorePlayer;
import org.x1.player.data.PersistPlayer;
import org.x1.player.data.PlayerEntity;
import org.x1.utils.serializer.protostuffer.SerializerUtils;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ppdashi on 2017/7/15.
 * 消息分发器
 */
@Component
public class MessageOutManager {
    /**
     *
     */
    private Map<Short, ISerializer> serializerModel;

    public MessageOutManager() {
        serializerModel = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void init() {
        serializerModel.put((short) 1, new AccountDto());
        serializerModel.put((short) 2, new PlayerInfoDto());
        serializerModel.put((short) 3, new ActivityDto());
        serializerModel.put((short) 4, new MoneyTreeDto());
    }

    private ProtocolManager protocolManager;
    public void process(Channel channel, Request request) {
        if (protocolManager == null)
            protocolManager = ProtocolManager.getInstance();
        ProtocolLogicAdapter protocolLogic;
        ISerializer serializer = null;
        CorePlayer corePlayer;
        try {
            protocolLogic = protocolManager.getLogic(request.getId());
            if (serializerModel.containsKey(request.getId()) && request.getDataLength() > 0)
                serializer = SerializerUtils.deserializer(request.getData(), serializerModel.get(request.getId()).getClass());
            if (PersistPlayer.playerMap.containsKey(channel)) {
                corePlayer = PersistPlayer.playerMap.get(channel);
            } else {
                SerializerPlayerModel model = SpringUtils.getBean(SerializerPlayerModel.class);
                PlayerEntity entity = model.getPlayer(((AccountDto) serializer));
                corePlayer = new CorePlayer(entity);
                PersistPlayer.playerMap.put(channel, corePlayer);
            }
            protocolLogic.setId(request.getId());
            protocolLogic.setMsg(serializer);
            protocolLogic.setCorePlayer(corePlayer);
            protocolLogic.setCtx(channel);
            //提交线程池释放io线程
            ExecutorUtils.threadTask.execute(protocolLogic);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("找不到Action_" + request.getId() + "这个脚本类" + e);
        }
    }
}
