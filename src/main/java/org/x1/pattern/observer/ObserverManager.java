package org.x1.pattern.observer;

import org.x1.pattern.Logic;

import java.util.Iterator;
import java.util.Set;

/**
 * 作者：泡泡大湿
 * 时间： 2017/8/25.
 * 描述：
 */
public abstract class ObserverManager<T extends Logic> {
    public abstract Set<T> getSet();
    public abstract void notifyx();
}
