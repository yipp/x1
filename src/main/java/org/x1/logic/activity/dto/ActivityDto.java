package org.x1.logic.activity.dto;

import org.x1.utils.net.model.ISerializer;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/14******
 * 描述：
 */
public class ActivityDto implements ISerializer {
    private int weekDay;
    private boolean draw;

    public ActivityDto() {
    }

    public ActivityDto(int weekDay, boolean draw) {
        this.weekDay = weekDay;
        this.draw = draw;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }
}
