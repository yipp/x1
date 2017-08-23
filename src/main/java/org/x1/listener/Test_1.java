package org.x1.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * 作者：泡泡大湿
 * 时间： 2017/8/23.
 * 描述：
 */
@Service
public class Test_1 extends LogicManager<AbstractTest> {
    @Autowired
    private Set<AbstractTest> set;
    @Override
    public Set<AbstractTest> getSet() {
        return set;
    }
    @PostConstruct
    @Override
    protected void init() {
        super.init();
    }
}
