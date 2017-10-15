package org.x1.logic.vip.data;

import org.x1.player.data.PlayerTable;
import org.x1.utils.serializer.excel.DataTableMessage;
import org.x1.utils.serializer.excel.StaticConfigMessage;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/15******
 * 描述：
 */
public class VipTable implements DataTableMessage {
    private int id;
    private float shopDis;
    private float moneyTreeAdd;
    private float activityAdd;
    private int shopCapacity;
    @Override
    public int id() {
        return id;
    }
    public static VipTable get(int id) {
        return StaticConfigMessage.getInstance().get(VipTable.class,id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getShopDis() {
        return shopDis;
    }

    public void setShopDis(float shopDis) {
        this.shopDis = shopDis;
    }

    public float getMoneyTreeAdd() {
        return moneyTreeAdd;
    }

    public void setMoneyTreeAdd(float moneyTreeAdd) {
        this.moneyTreeAdd = moneyTreeAdd;
    }

    public float getActivityAdd() {
        return activityAdd;
    }

    public void setActivityAdd(float activityAdd) {
        this.activityAdd = activityAdd;
    }

    public int getShopCapacity() {
        return shopCapacity;
    }

    public void setShopCapacity(int shopCapacity) {
        this.shopCapacity = shopCapacity;
    }
}
