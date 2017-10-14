package org.x1.logic.activity.command;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.x1.calendar.DateUtils;
import org.x1.logic.activity.dto.ActivityDto;
import org.x1.logic.activity.model.PersistActivity;
import org.x1.player.data.PlayerEntity;
import org.x1.player.model.Wealth;
import org.x1.utils.net.logic.ProtocolLogicAdapter;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/14******
 * 描述：
 */
@Service
public class Action_3 extends ProtocolLogicAdapter<ActivityDto> {
    @Override
    public void executor() {
        PlayerEntity entity = this.getCorePlayer().getPlayerEntity();
        PersistActivity activity = entity.getActivity();
        if(activity.isDraw()){
            System.out.println("当天已经领取");
        }
        activity.setId(entity.getId());
        activity.setDraw(true);
        int money = entity.getGold();
        entity.setGold(money+1000);
        Wealth wealth = new Wealth();
        BeanUtils.copyProperties(entity,wealth);
        wealth.update();
        //TODO 财富添加更新
        if(this.getMsg().getWeekDay() == DateUtils.getTodayOnWeek())
            activity.update();
        this.response(new ActivityDto(DateUtils.getTodayOnWeek(),true));
    }
}
