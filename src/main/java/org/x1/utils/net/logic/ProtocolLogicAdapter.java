package org.x1.utils.net.logic;

import io.netty.channel.Channel;
import org.x1.utils.net.model.ISerializer;
import org.x1.player.data.CorePlayer;
import org.x1.utils.net.model.Response;
import org.x1.utils.serializer.protostuffer.SerializerUtils;

/**
 * 作者：泡泡大湿
 * 时间： 2017/8/22.
 * 描述：
 */
public abstract class ProtocolLogicAdapter<T extends ISerializer> implements ProtocolLogic {
    private short id;
    private T msg;
    private CorePlayer corePlayer;
    private Channel ctx;
    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public CorePlayer getCorePlayer() {
        return corePlayer;
    }

    public void setCorePlayer(CorePlayer corePlayer) {
        this.corePlayer = corePlayer;
    }

    public Channel getCtx() {
        return ctx;
    }

    public void setCtx(Channel ctx) {
        this.ctx = ctx;
    }

    @Override
    public void run() {
        executor();
    }
    protected void response(ISerializer serializer){
        Response response = new Response();
        response.setId(this.id);
        byte[] bytes = SerializerUtils.serializer(serializer);
        response.setData(bytes);
        ctx.writeAndFlush(response);
    }
}
