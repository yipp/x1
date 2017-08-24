package org.x1.listener;

import org.apache.poi.ss.formula.functions.T;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 作者：泡泡大湿
 * 时间： 2017/8/23.
 * 描述：
 */
public abstract class LogicManager<T extends Logic> {
    private final Map<String,T> map = new HashMap<>();
    protected void init(){
        if(this.getSet() != null){
            Iterator arg1 = this.getSet().iterator();
            while (arg1.hasNext()){
                Logic logic = (Logic)arg1.next();
                String name = logic.getClass().getSimpleName();
                String type = name.substring(name.indexOf("_")+1);
                this.map.put(type, (T) logic);
            }
        }
    }
    public T getLogic(int type){
        return (T) this.map.get(String.valueOf(type));
    }
    public T getLogic(String type){
        return (T) this.map.get(type);
    }
    public abstract Set<T> getSet();
}
