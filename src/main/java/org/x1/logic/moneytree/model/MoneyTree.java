package org.x1.logic.moneytree.model;

import com.alibaba.fastjson.JSON;
import org.x1.player.model.PlayerModel;
import org.x1.sqlmapper.ActivityMapper;
import org.x1.sqlmapper.MoneyTreeMapper;
import org.x1.sqlmapper.PersistJson;
import org.x1.utils.SpringUtils;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/14******
 * 描述：
 */
public class MoneyTree extends PersistJson<MoneyTreeMapper> {
    /**是否已经购买*/
    private boolean buyTree;
    /**上次领取时间*/
    private long time;

    public MoneyTree() {
    }

    public MoneyTree(boolean buyTree, long time) {
        this.buyTree = buyTree;
        this.time = time;
    }

    public boolean isBuyTree() {
        return buyTree;
    }

    public void setBuyTree(boolean buyTree) {
        this.buyTree = buyTree;
    }


    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean executorUpdate() {
        /**更新角色信息*/
        String moneyTree = JSON.toJSONString(this);
        PlayerModel model = new PlayerModel();
        model.setMoneyTree(moneyTree);
        model.setId(this.getId());
        this.serializer = SpringUtils.getBean(MoneyTreeMapper.class);
        this.serializer.update(model);
        return false;
    }
}
