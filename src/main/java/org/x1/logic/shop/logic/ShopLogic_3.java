package org.x1.logic.shop.logic;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.x1.calendar.DateUtils;
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
public class ShopLogic_3 extends ShopLogicAdapter {
    @Override
    public ShopBuyDto procces(ShopTable table,CorePlayer corePlayer) {
        PlayerEntity entity = corePlayer.getPlayerEntity();
        int buyPrice = table.getPrice();
        //最终消耗的钱
        /**剩余天数+30天等于几月几*/
        long residueTime = DateUtils.getTimeMillisToxx(entity.getVipUpdateTime()+"")- DateUtils.dayEndMillis();
        int day = (int) (residueTime/(1000*60*60*24));
        if(entity.getVip() == table.getChangePrice())
            day = day > 0 ? day : 0;
        else
            day = 0;
        //下次刷新时间
        entity.setVipUpdateTime(DateUtils.vipUpdateTime(day));
        entity.setVip((int) table.getChangePrice());
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
