package org.x1.logic.shop.model;

import com.alibaba.fastjson.JSON;
import org.x1.player.model.PlayerModel;
import org.x1.sqlmapper.PersistJson;
import org.x1.sqlmapper.ShopMapper;
import org.x1.utils.SpringUtils;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/16******
 * 描述：
 */
public class Shop extends PersistJson<ShopMapper> {
    /**充值次数*/
    private int topUpNum;
    /**充值总金额*/
    private int grossAmount;

    public int getTopUpNum() {
        return topUpNum;
    }

    public void setTopUpNum(int topUpNum) {
        this.topUpNum = topUpNum;
    }

    public int getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(int grossAmount) {
        this.grossAmount = grossAmount;
    }

    @Override
    public boolean executorUpdate() {
        /**更新角色信息*/
        String shop = JSON.toJSONString(this);
        PlayerModel model = new PlayerModel();
        model.setShop(shop);
        model.setId(this.getId());
        this.serializer = SpringUtils.getBean(ShopMapper.class);
        this.serializer.update(model);
        return false;
    }
}
