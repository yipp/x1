package org.x1.player.data;

import org.x1.utils.serializer.excel.DataTableMessage;
import org.x1.utils.serializer.excel.StaticConfigMessage;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/15******
 * 描述：
 */
public class PlayerTable implements DataTableMessage {

    private int id;
    private String name;
    private int head;
    private String discibe;
    private String password;
    private int type;
    private int gender;
    @Override
    public int id() {
        return id;
    }
    public static PlayerTable get(int id) {
        return StaticConfigMessage.getInstance().get(PlayerTable.class,id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHead() {
        return head;
    }

    public String getDiscibe() {
        return discibe;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }

    public int getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void setDiscibe(String discibe) {
        this.discibe = discibe;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
