package org.x1.net.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.x1.net.logic.ProtocolLogic;
import org.x1.net.logic.ProtocolLogicAdapter;
import org.x1.net.model.ISerializer;
import org.x1.pattern.adapter.AdapterManager;
import org.x1.springUtils.SpringUtils;

import java.util.Set;

/**
 * 作者：泡泡大湿
 * 时间： 2017/8/26.
 * 描述：
 */
@Service
public class ProtocolManager extends AdapterManager<ProtocolLogicAdapter>{
    public static ProtocolManager getInstance(){
        return SpringUtils.getBean(ProtocolManager.class);
    }
    @Autowired
    private Set<ProtocolLogicAdapter> set;
    @Override
    public Set<ProtocolLogicAdapter> getSet() {
        return set;
    }

    @Override
    protected void init() {
        super.init();
    }
}
