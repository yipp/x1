package org.x1.logic.login.command;

import org.springframework.stereotype.Service;
import org.x1.calendar.DateUtils;
import org.x1.error.data.ErrorCode;
import org.x1.error.manager.AppErrorGeneral;
import org.x1.logic.login.dto.AccountDto;
import org.x1.player.data.CorePlayer;
import org.x1.player.data.PersistPlayer;
import org.x1.utils.net.logic.ProtocolLogicAdapter;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/12******
 * 描述：
 */
@Service
public class Action_1 extends ProtocolLogicAdapter<AccountDto> {
    @Override
    public void executor() {
        if(this.getMsg().getLoginType() == CorePlayer.LoginType.Account.id())
            if(this.getMsg().getPassword() != this.getCorePlayer().getPlayerEntity().getPassword())
                new AppErrorGeneral(this.getCtx(), ErrorCode.PASSWORD_ERROR);
        this.getCorePlayer().setScenesId(CorePlayer.ScenesId.Main.id());
        PlayerEntity entity = this.getCorePlayer().getPlayerEntity();
        if(entity.getActivity().getGetTime() != DateUtils.currentDay()) {
            entity.getActivity().setGetTime(DateUtils.currentDay());
            entity.getActivity().setDraw(false);
        }
        entity.setWeekDay(DateUtils.getTodayOnWeek());
        this.response(this.getCorePlayer().getPlayerEntity());
        PersistPlayer.playerId.put(this.getCorePlayer().getPlayerEntity().getId(),this.getCorePlayer());
    }
}
