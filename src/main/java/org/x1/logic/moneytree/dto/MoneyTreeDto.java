package org.x1.logic.moneytree.dto;

import org.x1.logic.moneytree.model.MoneyTree;
import org.x1.utils.net.model.ISerializer;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/14******
 * 描述：
 */
public class MoneyTreeDto implements ISerializer{
    private boolean get;
    private long time;
    private int money;

    public MoneyTreeDto() {
    }

    public MoneyTreeDto(boolean get, long time, int money) {
        this.get = get;
        this.time = time;
        this.money = money;
    }

    public boolean isGet() {
        return get;
    }

    public void setGet(boolean get) {
        this.get = get;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
