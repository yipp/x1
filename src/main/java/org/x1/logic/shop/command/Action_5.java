package org.x1.logic.shop.command;
import org.springframework.stereotype.Service;
import org.x1.calendar.DateUtils;
import org.x1.error.data.ErrorCode;
import org.x1.error.manager.AppErrorGeneral;
import org.x1.logic.shop.data.ShopTable;
import org.x1.logic.shop.dto.ShopBuyDto;
import org.x1.logic.shop.logic.ShopLogic;
import org.x1.logic.shop.manager.ShopManager;
import org.x1.utils.net.logic.ProtocolLogicAdapter;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/16******
 * 描述：
 */
@Service
public class Action_5 extends ProtocolLogicAdapter<ShopBuyDto> {
    private static final int[] VIP_GOODS = {13,14,15,16,17,18};
    @Override
    public void executor() {
        PlayerEntity entity = this.getCorePlayer().getPlayerEntity();
        //vip到期
        if(entity.getVipUpdateTime()< DateUtils.currentDay())
            entity.setVip(0);
        int goodlsId = this.getMsg().getGoodsId();
        if(this.getMsg().getShopId() == 3)
            goodlsId = VIP_GOODS[goodlsId-1];
        ShopTable table = ShopTable.get(goodlsId);
        if(table == null)
            new AppErrorGeneral(this.getCtx(), ErrorCode.DATA_ERROR);
        ShopManager manager = ShopManager.getInstance();
        ShopLogic logic = manager.getLogic(this.getMsg().getShopId());
        if(logic == null)
            new AppErrorGeneral(this.getCtx(), ErrorCode.DATA_ERROR);
        ShopBuyDto dto = logic.procces(table,this.getCorePlayer());
        this.response(dto);
    }
}
