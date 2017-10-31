package org.x1.error.dto;

import org.x1.utils.net.model.ISerializer;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/15******
 * 描述：
 */
public class ErrorDto implements ISerializer {
    private int id;
    /**以后删除*/
    private String discibe;

    public ErrorDto() {
    }

    public ErrorDto(int id, String discibe) {

        this.id = id;
        this.discibe = discibe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscibe() {
        return discibe;
    }

    public void setDiscibe(String discibe) {
        this.discibe = discibe;
    }
}
