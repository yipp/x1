package org.x1.player.data;

/**
 * 作者：泡泡大湿
 * 时间： 2017/8/22.
 * 描述：
 */
public class CorePlayer {
    public enum LoginType{
        Photon
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
    private PlayerEntity playerEntity;

    public CorePlayer() {
    }

    public CorePlayer(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }
    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

    public void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public int getScenesId() {
        return scenesId;
    }

    public void setScenesId(int scenesId) {
        this.scenesId = scenesId;
    }

}
