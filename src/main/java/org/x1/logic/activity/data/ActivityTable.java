package org.x1.logic.activity.data;

import org.x1.player.data.CoreBasic;
import org.x1.utils.serializer.excel.DataTableMessage;
import org.x1.utils.serializer.excel.StaticConfigMessage;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/15******
 * 描述：
 */
public class ActivityTable implements DataTableMessage{
    private int id;
    private String name;
    private int icon;
    private int count;
    @Override
    public int id() {
        return id;
    }
    public static ActivityTable get(int id) {
        return StaticConfigMessage.getInstance().get(ActivityTable.class,id);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
