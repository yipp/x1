package org.x1.logic.shop.data;

import org.x1.utils.serializer.excel.DataTableMessage;
import org.x1.utils.serializer.excel.StaticConfigMessage;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/16******
 * 描述：
 */
public class ShopTable implements DataTableMessage {
    private int id;
    private int shopId;
    private float changePrice;
    private String icon;
    private String name;
    private int price;
    private int changeType;
    private int disPrice;
    @Override
    public int id() {
        return id;
    }
    public static ShopTable get(int id) {
        return StaticConfigMessage.getInstance().get(ShopTable.class,id);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public float getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(float changePrice) {
        this.changePrice = changePrice;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getChangeType() {
        return changeType;
    }

    public void setChangeType(int changeType) {
        this.changeType = changeType;
    }

    public int getDisPrice() {
        return disPrice;
    }

    public void setDisPrice(int disPrice) {
        this.disPrice = disPrice;
    }
}
