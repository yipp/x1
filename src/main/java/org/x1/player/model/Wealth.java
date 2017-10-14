package org.x1.player.model;

import com.alibaba.fastjson.JSON;
import org.x1.sqlmapper.PersistJson;
import org.x1.sqlmapper.PlayerInfoMapper;
import org.x1.sqlmapper.WealthMapper;
import org.x1.utils.SpringUtils;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/12******
 * 描述：玩家财富
 */
public class Wealth extends PersistJson<WealthMapper>{
    /**vip*/
    private int vip; // vip
    /**金幣*/
    private int gold; // 金币
    /**鑽石*/
    private int diamond; // 钻石

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

    @Override
    public boolean update() {
        //    /**更新角色信息*/
        String wealth = JSON.toJSONString(this);
        PlayerModel model = new PlayerModel();
        model.setWealth(wealth);
        model.setId(this.getId());
        this.serializer = SpringUtils.getBean(WealthMapper.class);
        this.serializer.update(model);
        return false;
    }
}
