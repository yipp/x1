package org.x1.logic.shop.dto;

import org.x1.utils.net.model.ISerializer;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/16******
 * 描述：
 */
public class ShopBuyDto implements ISerializer {
    private int shopId;
    private int goodsId;

    public ShopBuyDto() {
        this.shopId = shopId;
    }

    public ShopBuyDto(int shopId, int goodsId) {

        this.shopId = shopId;
        this.goodsId = goodsId;
    }

    public int getShopId() {

        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
}
