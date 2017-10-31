package org.x1.player.model;

import org.x1.logic.activity.model.PersistActivity;
import org.x1.logic.moneytree.model.MoneyTree;
import org.x1.logic.shop.model.Shop;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/29******
 * 描述：
 */
public class PlayerEntity {
    private int id;
    /**玩家基本信息*/
    private PlayerInfo playerInfo;
    /**玩家财富*/
    private Wealth wealth;
    /**商城*/
    private Shop shop;
    /**好友*/
    private String friend;
    /**签到*/
    private PersistActivity activity;
    /**摇钱树*/
    private MoneyTree moneyTree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }

    public Wealth getWealth() {
        return wealth;
    }

    public void setWealth(Wealth wealth) {
        this.wealth = wealth;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public PersistActivity getActivity() {
        return activity;
    }

    public void setActivity(PersistActivity activity) {
        this.activity = activity;
    }

    public MoneyTree getMoneyTree() {
        return moneyTree;
    }

    public void setMoneyTree(MoneyTree moneyTree) {
        this.moneyTree = moneyTree;
    }
}
