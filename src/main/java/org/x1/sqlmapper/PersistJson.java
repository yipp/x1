package org.x1.sqlmapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.x1.utils.net.model.ISerializer;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/14******
 * 描述：
 */
public abstract class PersistJson<T extends ISqlJsonSerializer>{
    private transient int id;
    protected transient T serializer;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void update(){
        SqlExecutorUpdate.putJson(this.getClass(),getId(),this);
    }
    public abstract boolean executorUpdate();
}
