package org.x1.logic.moneytree.data;

import org.x1.utils.serializer.excel.DataTableMessage;
import org.x1.utils.serializer.excel.StaticConfigMessage;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/15******
 * 描述：
 */
public class MoneyTreeTable implements DataTableMessage {
    private int id;
    private int make;
    @Override
    public int id() {
        return id;
    }
    public static MoneyTreeTable get(int id) {
        return StaticConfigMessage.getInstance().get(MoneyTreeTable.class,id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMake() {
        return make;
    }

    public void setMake(int make) {
        this.make = make;
    }
}
