package org.x1.logic.activity.model;

import com.alibaba.fastjson.JSON;
import org.x1.player.model.PlayerModel;
import org.x1.sqlmapper.ActivityMapper;
import org.x1.sqlmapper.PersistJson;
import org.x1.utils.SpringUtils;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/14******
 * 描述：
 */
public class PersistActivity extends PersistJson<ActivityMapper> {
    /**是否已经领取*/
    private boolean draw;
    /**领取时间*/
    private int getTime;
    public PersistActivity() {
    }

    public PersistActivity(boolean draw, int getTime) {
        this.draw = draw;
        this.getTime = getTime;
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public int getGetTime() {
        return getTime;
    }

    public void setGetTime(int getTime) {
        this.getTime = getTime;
    }

    @Override
    public boolean executorUpdate() {
        /**更新角色信息*/
        String activty = JSON.toJSONString(this);
        PlayerModel model = new PlayerModel();
        model.setActivity(activty);
        model.setId(this.getId());
        this.serializer = SpringUtils.getBean(ActivityMapper.class);
        this.serializer.update(model);
        return false;
    }
}
