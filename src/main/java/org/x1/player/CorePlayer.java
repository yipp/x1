package org.x1.player;

import io.netty.channel.Channel;

/**
 * 作者：泡泡大湿
 * 时间： 2017/8/22.
 * 描述：
 */
public class CorePlayer {
    private Channel channel;
    private PlayerEntity playerEntity;

    public CorePlayer() {
    }

    public CorePlayer(Channel channel) {
        this.channel = channel;
        get();
    }

    public CorePlayer(Channel channel, PlayerEntity playerEntity) {
        this.channel = channel;
        this.playerEntity = playerEntity;
    }

    public Channel getChannel() {

        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

    public void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }
    private void get(){
        //从数据库中找
    }
}
