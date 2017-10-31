package org.x1.logic.shop.logic;

import org.x1.error.data.ErrorCode;
import org.x1.error.manager.AppErrorGeneral;
import org.x1.logic.vip.data.VipTable;
import org.x1.player.data.CorePlayer;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/16******
 * 描述：
 */
public abstract class ShopLogicAdapter implements ShopLogic {
    protected float price(CorePlayer corePlayer){
        PlayerEntity entity = corePlayer.getPlayerEntity();
        float disPrice = 1;
        VipTable vipTable = null;
        if(entity.getVip()>0) {
            VipTable.get(entity.getVip());
            if(vipTable == null)
                new AppErrorGeneral(corePlayer.getChannel(), ErrorCode.DIAMOND_DEFICIENCY);
            disPrice = vipTable.getShopDis();
        }
        return disPrice;
    }
}
