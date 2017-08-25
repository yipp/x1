package org.x1.pattern.adapter;

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
public class AdapterHadlerManager extends AdapterManager<IAdapter> {
    @Autowired
    private Set<IAdapter> set;
    @Override
    public Set<IAdapter> getSet() {
        return set;
    }
    @PostConstruct
    @Override
    protected void init(){
        super.init();
    }
}
