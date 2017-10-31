package org.x1.player.manager;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.x1.calendar.DateUtils;
import org.x1.logic.activity.model.PersistActivity;
import org.x1.logic.login.dto.AccountDto;
import org.x1.logic.moneytree.model.MoneyTree;
import org.x1.logic.shop.model.Shop;
import org.x1.player.data.CorePlayer;
import org.x1.player.data.PlayerTable;
import org.x1.player.model.*;
import org.x1.sqlmapper.PlayerMapper;

/**
 * Created by ppdashi on 2017/7/14.
 */
@Service
public class SerializerPlayerModel {
    @Autowired
    private PlayerMapper playerMapper;
    /**查找角色信息*/
    public PlayerEntity getPlayer(int id){
        PlayerModel playerModel = playerMapper.selectUser(id);
        return entity(playerModel);
    }
    public PlayerEntity getPlayer(String account,int loginType){
        PlayerModel playerModel = null;
        PlayerEntity entity = null;
        try {
            if(loginType != CorePlayer.LoginType.Account.ordinal())
                playerModel = playerMapper.selectUserForAccount(account);
            else
                playerModel = playerMapper.selectUser(Integer.parseInt(account));
        }catch (Exception e){
            e.printStackTrace();
            playerModel = null;
        }
        if(playerModel == null) {
            return null;
        }else
            entity = entity(playerModel);
        return entity;
    }
    /**添加角色信息*/
    public PlayerEntity insertPlayer(PlayerEntity entity){

        String playerInfo = JSON.toJSONString(entity.getPlayerInfo());
        String wealth = JSON.toJSONString(entity.getWealth());
        String shop = JSON.toJSONString(entity.getWealth());
        String friend = JSON.toJSONString(entity.getFriend());
        String activity = JSON.toJSONString(entity.getActivity());
        String moneyTree = JSON.toJSONString(entity.getMoneyTree());

        PlayerModel model = new PlayerModel();

        model.setAccount(entity.getPlayerInfo().getAccount());
        model.setActivity(activity);
        model.setFriend(friend);
        model.setMoneyTree(moneyTree);
        model.setPlayerInfo(playerInfo);
        model.setWealth(wealth);
        model.setShop(shop);
        model.setId(entity.getId());

        try {
            playerMapper.addUser(model);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("添加对象错误" + e);
        }
        return entity;
    }
//    /**更新角色信息*/
//    public void updatePlayer(Player player){
//        String basicInfo = JSON.toJSONString(player.getBasicInfo());
//        String resources = JSON.toJSONString(player.getResources());
//        String frients  = JSON.toJSONString(player.getFrients(),true);
//        String account = player.getAccount();
//        PlayerModel model = new PlayerModel(player.getId(),basicInfo,resources,frients,account);
//        playerMapper.updateUser(model);
//    }
    public void delectPlayer(Integer id){
        playerMapper.deleteUser(id);
    }
    private PlayerEntity entity(PlayerModel model){
        PlayerInfo info = JSON.parseObject(model.getPlayerInfo(),PlayerInfo.class);
        Wealth wealth = JSON.parseObject(model.getWealth(),Wealth.class);
        PersistActivity activity = JSON.parseObject(model.getActivity(),PersistActivity.class);
        MoneyTree moneyTree = JSON.parseObject(model.getMoneyTree(),MoneyTree.class);
        Shop shop = JSON.parseObject(model.getShop(),Shop.class);
        // TODO 好友

        PlayerEntity entity = new PlayerEntity();
        entity.setId(model.getId());
        entity.setActivity(activity);
        entity.setMoneyTree(moneyTree);
        entity.setShop(shop);
        entity.setMoneyTree(moneyTree);
        entity.setWealth(wealth);
        return entity;
    }
}
