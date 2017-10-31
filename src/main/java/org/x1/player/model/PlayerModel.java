package org.x1.player.model;

import org.x1.sqlmapper.PersistJson;
import org.x1.sqlmapper.PlayerMapper;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/12******
 * 描述：
 */
public class PlayerModel extends PersistJson<PlayerMapper>{
    private int id;
    /**账号*/
    private String account;
    /**玩家基本信息*/
    private String playerInfo;
    /**玩家财富*/
    private String wealth;
    /**商城*/
    private String shop;
    /**好友*/
    private String friend;
    /**签到*/
    private String activity;
    /**摇钱树*/
    private String moneyTree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(String playerInfo) {
        this.playerInfo = playerInfo;
    }

    public String getWealth() {
        return wealth;
    }

    public void setWealth(String wealth) {
        this.wealth = wealth;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getMoneyTree() {
        return moneyTree;
    }

    public void setMoneyTree(String moneyTree) {
        this.moneyTree = moneyTree;
    }

    @Override
    public boolean executorUpdate() {
        return false;
    }
}
