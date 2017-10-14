package org.x1.utils.net.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.x1.utils.net.logic.ProtocolLogicAdapter;
import org.x1.pattern.adapter.AdapterManager;
import org.x1.utils.SpringUtils;

import javax.annotation.PostConstruct;
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
    @PostConstruct
    @Override
    protected void init() {
        super.init();
    }
}
