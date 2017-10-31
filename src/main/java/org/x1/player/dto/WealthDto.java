package org.x1.player.dto;

import org.x1.utils.net.model.ISerializer;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/16******
 * 描述：
 */
public class WealthDto implements ISerializer {
    private int vip;
    private int gold;
    private int diamond;

    public WealthDto() {
    }

    public WealthDto(int vip, int gold, int diamond) {

        this.vip = vip;
        this.gold = gold;
        this.diamond = diamond;
    }

    public int getVip() {

        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }
}
