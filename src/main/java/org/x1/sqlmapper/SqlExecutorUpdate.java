package org.x1.sqlmapper;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/15******
 * 描述：
 */
public class SqlExecutorUpdate implements Runnable {
    public SqlExecutorUpdate() {
    }

    private static ConcurrentMap<Class<? extends PersistJson>,ConcurrentMap<Integer,PersistJson>> persistJsons = new ConcurrentHashMap<>();
    @Override
    public void run() {
        if(persistJsons.size()>0) {
            System.err.println(persistJsons.size());
            for (PersistJson p : getBean()) {
                System.err.println("++++数据库更新++++"+p.getClass());
                p.executorUpdate();
            }
            persistJsons.clear();
        }
    }
    public static void putJson(Class<? extends PersistJson> k,int id, PersistJson p){
        ConcurrentMap<Integer,PersistJson> v = new ConcurrentHashMap<>();
        v.put(id,p);
        persistJsons.put(k,v);
    }
    private List<PersistJson> getBean(){
        LinkedList<PersistJson> jsons = new LinkedList<>();
        List<ConcurrentMap<Integer,PersistJson>> maps = new ArrayList<>(persistJsons.size());
        for (Map.Entry<Class<? extends PersistJson>,ConcurrentMap<Integer,PersistJson>> e:persistJsons.entrySet()) {
            maps.add(e.getValue());
        }
        for (int i = 0;i<maps.size();i++){
            for (Map.Entry<Integer,PersistJson> e:maps.get(i).entrySet()) {
                jsons.push(e.getValue());
            }
        }
        return  jsons;
    }
}
