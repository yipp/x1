package org.x1.logic.shop.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.x1.logic.shop.logic.ShopLogic;
import org.x1.pattern.adapter.AdapterManager;
import org.x1.utils.SpringUtils;
import org.x1.utils.net.logic.ProtocolLogicAdapter;
import org.x1.utils.net.manager.ProtocolManager;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/16******
 * 描述：
 */
@Service
public class ShopManager extends AdapterManager<ShopLogic> {
    public static ShopManager getInstance(){
        return SpringUtils.getBean(ShopManager.class);
    }
    @Autowired
    private Set<ShopLogic> set;
    @Override
    public Set<ShopLogic> getSet() {
        return set;
    }
    @PostConstruct
    @Override
    protected void init() {
        super.init();
    }
}
