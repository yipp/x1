package org.x1.logic.shop.logic;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.x1.logic.shop.data.ShopTable;
import org.x1.logic.shop.dto.ShopBuyDto;
import org.x1.logic.shop.model.Shop;
import org.x1.player.data.CorePlayer;
import org.x1.player.model.Wealth;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/16******
 * 描述：
 */
@Service
public class ShopLogic_2 extends ShopLogicAdapter{
    @Override
    public ShopBuyDto procces(ShopTable table,CorePlayer corePlayer) {
        PlayerEntity entity = corePlayer.getPlayerEntity();
        float disPrice = price(corePlayer);
        int price = table.getPrice();
        //最终消耗的钱
        int buyPrice = (int) (Math.ceil(price*disPrice));
        int holdDiamond = entity.getDiamond();
        entity.setDiamond(holdDiamond + table.getPrice());
        Shop shop = new Shop();
        shop.setId(entity.getId());
        shop.setTopUpNum(buyPrice);
        shop.setGrossAmount(shop.getGrossAmount()+buyPrice);
        Wealth wealth = new Wealth();
        BeanUtils.copyProperties(entity,wealth);
        shop.update();
        wealth.update();
        return new ShopBuyDto(table.getShopId(),table.getId());
    }
}
