package org.x1.logic.playerinfo.dto;

import org.x1.utils.net.model.ISerializer;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/14******
 * 描述：
 */
public class PlayerInfoDto implements ISerializer {
    private int head;
    private String describle;
    private String name;
    private String password;

    public PlayerInfoDto() {
    }

    public PlayerInfoDto(int head, String describle, String name, String password) {

        this.head = head;
        this.describle = describle;
        this.name = name;
        this.password = password;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
