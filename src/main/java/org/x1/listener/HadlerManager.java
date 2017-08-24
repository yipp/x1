package org.x1.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * 作者：泡泡大湿
 * 时间： 2017/8/24.
 * 描述：
 */
@Service
public class HadlerManager extends LogicManager<IHandler> {
    @Autowired
    private Set<IHandler> set;
    @Override
    public Set<IHandler> getSet() {
        return set;
    }
    @PostConstruct
    @Override
    protected void init(){
        super.init();
    }
}
