package org.x1.logic.shop.command;

import org.x1.utils.net.logic.ProtocolLogicAdapter;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/29******
 * 描述：
 */
public class ShopCommand extends ProtocolLogicAdapter{
    private final int shopId;

    private final int goodsId;
    public ShopCommand(int shopId, int goodsId) {
        this.shopId = shopId;
        this.goodsId = goodsId;
    }

    @Override
    public void executor() {

    }
}
