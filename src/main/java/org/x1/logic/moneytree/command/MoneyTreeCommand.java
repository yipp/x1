package org.x1.logic.moneytree.command;

import org.x1.utils.net.logic.ProtocolLogicAdapter;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/29******
 * 描述：
 */
public class MoneyTreeCommand extends ProtocolLogicAdapter {
    private final boolean get;
    private final long time;
    private final int money;
    private final int vipAdd;
    private final boolean buy;

    public MoneyTreeCommand(boolean get, long time, int money, int vipAdd, boolean buy) {
        this.get = get;
        this.time = time;
        this.money = money;
        this.vipAdd = vipAdd;
        this.buy = buy;
    }

    @Override
    public void executor() {

    }
}
