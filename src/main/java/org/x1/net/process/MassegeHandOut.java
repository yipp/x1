package org.x1.net.process;

import io.netty.channel.Channel;
import org.springframework.stereotype.Component;
import org.x1.Test;
import org.x1.executor.ExecutorUtils;
import org.x1.logic.LogicAbstract;
import org.x1.net.model.ISerializer;
import org.x1.net.model.Request;
import org.x1.player.CorePlayer;
import org.x1.player.PlayerCache;
import org.x1.serializer.protostuffer.ProtostuffUtils;
import org.x1.springUtils.SpringUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ppdashi on 2017/7/15.
 * 消息分发器
 */
@Component
public class MassegeHandOut {
    private Map<Short,ISerializer> serializerModel = new HashMap<>();
    @PostConstruct
    public void init(){
        serializerModel.put((short) 1, new Test());
    }
    public void process(Channel channel, Request request) {
        //将客户端发过来的协议id拼接到"Action_"字符串中
        String className = "action_" + request.getId();
        LogicAbstract logic = null;
        ISerializer serializer = null;
        CorePlayer corePlayer = null;
        try {
            //根据拼接的字符串用spring ioc容器的依赖注入实例化协议实现具体对象
            logic = (LogicAbstract) SpringUtils.getBean(className, LogicAbstract.class);
            if (serializerModel.containsKey(request.getId()) && request.getDataLength() > 0)
                serializer = ProtostuffUtils.deserializer(request.getDATA(), serializerModel.get(request.getId()).getClass());
            if(PlayerCache.playerMap.containsKey(channel))
               corePlayer = PlayerCache.playerMap.get(channel);
            else if(request.getId()>1)
                corePlayer = new CorePlayer(channel);
            else
                corePlayer = new CorePlayer(channel,null);
            logic.setId(request.getId());
            logic.setMsg(serializer);
            logic.setCorePlayer(corePlayer);
            //提交线程池释放io线程
            ExecutorUtils.threadTask.execute(logic);

        }catch(Exception e){
            throw new RuntimeException("找不到Action_" + request.getId() + "这个脚本类");
        }
    }
}
