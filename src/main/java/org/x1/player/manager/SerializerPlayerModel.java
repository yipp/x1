package org.x1.player.manager;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.x1.calendar.DateUtils;
import org.x1.logic.activity.model.PersistActivity;
import org.x1.logic.login.dto.AccountDto;
import org.x1.logic.moneytree.model.MoneyTree;
import org.x1.player.data.CorePlayer;
import org.x1.player.data.PlayerEntity;
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
    public PlayerEntity getPlayer(AccountDto dto){
        int account = 7788;
        PlayerModel playerModel = null;
        PlayerEntity entity = null;
        try {
            if(dto.getLoginType() == CorePlayer.LoginType.Photon.ordinal())
                playerModel = playerMapper.selectUserForAccount(dto.getAccount());
            else
                playerModel = playerMapper.selectUser(77888);
        }catch (Exception e){
            e.printStackTrace();
            playerModel = null;
        }
        if(playerModel == null)
            entity = insertPlayer(dto);
        else
            entity = entity(playerModel);
        return entity;
    }
    /**添加角色信息*/
    public PlayerEntity insertPlayer(AccountDto dto){
        PlayerEntity entity = null;
        PlayerInfo info = new PlayerInfo();
        info.setAccount(dto.getAccount());
        PlayerTable table = PlayerTable.get(1);
        info.setWeekDay(DateUtils.getTodayOnWeek());
        info.setId(77888);
        BeanUtils.copyProperties(table,info);
        String playerInfo = JSON.toJSONString(info);
        String wealth = JSON.toJSONString(new Wealth());
        String shop = JSON.toJSONString(new PersistActivity());
        String friend = JSON.toJSONString(new PersistActivity());
        String activity = JSON.toJSONString(new PersistActivity());
        String moneyTree = JSON.toJSONString(new MoneyTree());
        PlayerModel model = new PlayerModel();
        model.setAccount(dto.getAccount());
        model.setActivity(activity);
        model.setFriend(friend);
        model.setMoneyTree(moneyTree);
        model.setPlayerInfo(playerInfo);
        model.setWealth(wealth);
        model.setShop(shop);
        model.setId(77888);
        try {
            playerMapper.addUser(model);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("添加对象错误" + e);
        }
        entity = new PlayerEntity();
        PersistActivity activity1 = new PersistActivity();
        activity1.setId(77888);
        entity.setActivity(activity1);
        MoneyTree tree = new MoneyTree();
        tree.setId(77888);
        entity.setMoneyTree(tree);
        BeanUtils.copyProperties(info,entity);
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
        PlayerEntity entity = new PlayerEntity();
        entity.setActivity(activity);
        entity.setMoneyTree(moneyTree);
        BeanUtils.copyProperties(wealth,entity);
        BeanUtils.copyProperties(info,entity);
        return entity;
    }
}
