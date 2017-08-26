package org.x1.net.logic;

import org.x1.net.model.ISerializer;
import org.x1.player.CorePlayer;

/**
 * 作者：泡泡大湿
 * 时间： 2017/8/22.
 * 描述：
 */
public abstract class ProtocolLogicAdapter<T extends ISerializer> implements ProtocolLogic {
    private short id;
    private T msg;
    private CorePlayer corePlayer;

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

    @Override
    public void run() {
        executor();
    }
}
