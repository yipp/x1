package org.x1.logic.shop.logic;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.x1.error.data.ErrorCode;
import org.x1.error.manager.AppErrorGeneral;
import org.x1.logic.shop.data.ShopTable;
import org.x1.logic.shop.dto.ShopBuyDto;
import org.x1.player.data.CorePlayer;
import org.x1.player.model.Wealth;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/16******
 * 描述：商店1，钻石换金币
 */
@Service
public class ShopLogic_1 extends ShopLogicAdapter {
    @Override
    public ShopBuyDto procces(ShopTable table,CorePlayer corePlayer) {
        PlayerEntity entity = corePlayer.getPlayerEntity();
        float disPrice = price(corePlayer);
        int price = table.getPrice();
        //最终消耗钻石
        int buyPrice = (int) (Math.ceil(price*disPrice));
        //钻石不足
        if(entity.getDiamond()<buyPrice)
            new AppErrorGeneral(corePlayer.getChannel(),ErrorCode.DIAMOND_DEFICIENCY);
        int diamond = entity.getDiamond();
        int gold = entity.getGold();
        entity.setDiamond(diamond - buyPrice);
        entity.setGold(gold + table.getPrice()*10000);
        Wealth wealth = new Wealth();
        BeanUtils.copyProperties(entity,wealth);
        wealth.update();
        return new ShopBuyDto(table.getShopId(),table.getId());
    }
}
