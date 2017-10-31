package org.x1.player.data;

import io.netty.channel.Channel;
import org.x1.player.model.PlayerEntity;

/**
 * 作者：泡泡大湿
 * 时间： 2017/8/22.
 * 描述：
 */
public class CorePlayer {
    public enum LoginType{
        Photon(1),
        Account(2);
        private int id;
        private LoginType(int id){
            this.id = id;
        }
        public int id(){
            return id;
        }
    }
    public enum ScenesId{
        Login(1),
        Main(2),
        FryFlower(3);
        private int id;
        private ScenesId(int id){
            this.id = id;
        }
        public int id(){
            return id;
        }
    }
    private int scenesId;
    private Channel channel;
    private PlayerEntity playerEntity;

    public CorePlayer() {
    }
    public CorePlayer(Channel channel, PlayerEntity playerEntity) {

        this.channel = channel;
        this.playerEntity = playerEntity;
    }
    public CorePlayer(int scenesId, Channel channel, PlayerEntity playerEntity) {

        this.scenesId = scenesId;
        this.channel = channel;
        this.playerEntity = playerEntity;
    }

    public int getScenesId() {

        return scenesId;
    }

    public void setScenesId(int scenesId) {
        this.scenesId = scenesId;
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
}
