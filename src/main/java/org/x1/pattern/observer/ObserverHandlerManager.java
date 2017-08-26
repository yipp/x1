package org.x1.pattern.observer;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.x1.pattern.Logic;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.Observer;
import java.util.Set;

/**
 * 作者：泡泡大湿
 * 时间： 2017/8/25.
 * 描述：
 */
@Service
public class ObserverHandlerManager extends  ObserverManager<IObserver> {
    @Autowired
    private Set<IObserver> set;
    @Override
    public Set<IObserver> getSet() {
        return set;
    }
    @PostConstruct
    @Override
    public void notifyx() {
        if(this.getSet() != null) {
            Iterator arg1 = this.getSet().iterator();
            while (arg1.hasNext()) {
                IObserver observer = (IObserver) arg1.next();
                observer.notifyx();
            }
        }
    }
}
