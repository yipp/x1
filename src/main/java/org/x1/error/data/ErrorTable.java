package org.x1.error.data;

import org.x1.utils.serializer.excel.DataTableMessage;
import org.x1.utils.serializer.excel.StaticConfigMessage;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/15******
 * 描述：
 */
public class ErrorTable implements DataTableMessage {
    private int id;
    private String discibe;
    @Override
    public int id() {
        return id;
    }
    public static ErrorTable get(int id) {
        return StaticConfigMessage.getInstance().get(ErrorTable.class,id);
    }

    public int getId() {
        return id;
    }

    public String getDiscibe() {
        return discibe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDiscibe(String discibe) {
        this.discibe = discibe;
    }
}
