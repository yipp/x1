package org.x1.logic.shop.logic;

import org.x1.logic.shop.data.ShopTable;
import org.x1.logic.shop.dto.ShopBuyDto;
import org.x1.pattern.Logic;
import org.x1.player.data.CorePlayer;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/16******
 * 描述：
 */
public interface ShopLogic extends Logic{
    ShopBuyDto procces(ShopTable table, CorePlayer corePlayer);
}
