package org.x1.player.data;

import org.x1.utils.serializer.excel.DataTableMessage;
import org.x1.utils.serializer.excel.StaticConfigMessage;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/15******
 * 描述：
 */
public class CoreBasic implements DataTableMessage {
    private int id;
    private int age;
    private int head;
    private int vip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }
    @Override
    public int id() {
        return id;
    }
    public static CoreBasic get(int id) {
        return StaticConfigMessage.getInstance().get(CoreBasic.class,id);
    }
}
