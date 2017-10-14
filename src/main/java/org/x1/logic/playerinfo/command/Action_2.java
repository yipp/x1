package org.x1.logic.playerinfo.command;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.x1.calendar.DateUtils;
import org.x1.logic.login.dto.AccountDto;
import org.x1.logic.playerinfo.dto.PlayerInfoDto;
import org.x1.player.data.PlayerEntity;
import org.x1.player.model.PlayerInfo;
import org.x1.utils.net.logic.ProtocolLogicAdapter;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/14******
 * 描述：
 */
@Service
public class Action_2 extends ProtocolLogicAdapter<PlayerInfoDto> {
    @Override
    public void executor() {
        PlayerEntity entity = this.getCorePlayer().getPlayerEntity();
        entity.setDiscibe(this.getMsg().getDescrible());
        entity.setHead(this.getMsg().getHead());
        entity.setName(this.getMsg().getName());
        entity.setPassword(this.getMsg().getPassword());
        entity.setWeekDay(DateUtils.getTodayOnWeek());
        PlayerInfo info = new PlayerInfo();
        BeanUtils.copyProperties(entity,info);
        info.update();
        this.response(this.getMsg());
    }
}
