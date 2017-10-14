package org.x1.logic.login.command;

import org.springframework.stereotype.Service;
import org.x1.logic.login.dto.AccountDto;
import org.x1.player.data.CorePlayer;
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
        this.getCorePlayer().setScenesId(CorePlayer.ScenesId.Main.id());
        this.response(this.getCorePlayer().getPlayerEntity());
    }
}
