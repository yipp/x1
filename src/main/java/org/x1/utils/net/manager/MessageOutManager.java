package org.x1.utils.net.manager;

import io.netty.channel.Channel;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.x1.error.manager.AppErrorGeneral;
import org.x1.executor.ExecutorUtils;
import org.x1.utils.SpringUtils;
import org.x1.utils.net.logic.ProtocolLogicAdapter;
import org.x1.utils.net.model.ISerializer;
import org.x1.utils.net.model.Request;
import org.x1.player.data.PersistPlayer;
import org.x1.utils.net.model.Response;
import org.x1.utils.serializer.protostuffer.SerializerUtils;

import java.util.List;

/**
 * Created by ppdashi on 2017/7/15.
 * 消息分发器
 */
@Component
public class MessageOutManager {
    private static Logger logger;
    static {
        logger = Logger.getLogger(AppErrorGeneral.class);
    }
    public static MessageOutManager getInstance(){
        return SpringUtils.getBean(MessageOutManager.class);
    }
    /**
     *
     */
    public void process(Channel channel, Request request) {
        String param = SerializerUtils.deserializer(request.getData(),String.class);
        String[] params = param.split(",");
        MessageOutEnumType type = MessageOutEnumType.value(request.getId());
        if(type == null || params == null || params.length == 0){
            //抛异常
        }
        ProtocolLogicAdapter cmd = type.process(params);
        cmd.setCtx(channel);
        cmd.setId(request.getId());
        if(PersistPlayer.playerMap.containsKey(channel))
            cmd.setCorePlayer(PersistPlayer.playerMap.get(channel));
        ExecutorUtils.threadTask.execute(cmd);
    }
    public void send(short id, Channel ctx, ISerializer serializer){
        Response response = new Response();
        response.setId(id);
        byte[] bytes = SerializerUtils.serializer(serializer);
        response.setData(bytes);
        ctx.writeAndFlush(response);
    }

    /**
     * 通知场景所有玩家
     * @param ctxs
     * @param msg
     */
    public void sendAll(List<Channel> ctxs,ISerializer msg){}
    /**
     * 消息主动下发给所有在线玩家
     * @param
     * @param msg
     */
    public void notifyx(ISerializer msg){}
    public void close(){}
}
