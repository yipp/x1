package org.x1.logic.activity.command;

import org.x1.utils.net.logic.ProtocolLogicAdapter;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/29******
 * 描述：
 */
public class ActivityCommand extends ProtocolLogicAdapter {
    private final int weekDay;
    private final boolean draw;
    public ActivityCommand(int weekDay, boolean draw) {
        this.weekDay = weekDay;
        this.draw = draw;
    }

    @Override
    public void executor() {

    }
}
