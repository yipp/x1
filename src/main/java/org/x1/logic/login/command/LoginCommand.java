package org.x1.logic.login.command;

import org.x1.calendar.DateUtils;
import org.x1.error.data.ErrorCode;
import org.x1.error.manager.AppErrorGeneral;
import org.x1.logic.activity.model.PersistActivity;
import org.x1.logic.login.dto.AccountDto;
import org.x1.logic.moneytree.model.MoneyTree;
import org.x1.logic.shop.model.Shop;
import org.x1.player.data.CorePlayer;
import org.x1.player.data.PersistPlayer;
import org.x1.player.manager.SerializerPlayerModel;
import org.x1.player.model.PlayerEntity;
import org.x1.player.model.PlayerInfo;
import org.x1.player.model.Wealth;
import org.x1.utils.SpringUtils;
import org.x1.utils.net.logic.ProtocolLogicAdapter;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/29******
 * 描述：登陆协议
 */
public class LoginCommand extends ProtocolLogicAdapter {
    /**登陆类型*/
    private final int loginType;
    /**账号*/
    private final String account;
    /**密码*/
    private final String password;

    public LoginCommand(int loginType, String account, String password) {
        this.loginType = loginType;
        this.account = account;
        this.password = password;
    }

    @Override
    public void executor() {
        SerializerPlayerModel model = SpringUtils.getBean(SerializerPlayerModel.class);
        PlayerEntity entity = entity = model.getPlayer(account,loginType);
        if(entity == null)
            entity = regist(model);
        if(loginType == CorePlayer.LoginType.Account.id())
            if (password != entity.getPlayerInfo().getAccount())
                new AppErrorGeneral(this.getCtx(), ErrorCode.PASSWORD_ERROR);

        //this.response(this.getCorePlayer().getPlayerEntity());
        this.getCorePlayer().setScenesId(CorePlayer.ScenesId.Main.id());
        this.getCorePlayer().setChannel(this.getCtx());
        this.getCorePlayer().setPlayerEntity(entity);
        PersistPlayer.playerId.put(this.getCorePlayer().getPlayerEntity().getId(),this.getCorePlayer());
    }

    /**
     * 注册
     */
    private PlayerEntity regist(SerializerPlayerModel model){
        //TODO 好友
        PlayerInfo info = new PlayerInfo();
        Wealth wealth = new Wealth();
        Shop shop = new Shop();
        PersistActivity activity = new PersistActivity();
        MoneyTree tree = new MoneyTree();

        return model.insertPlayer(null);
    }
}
