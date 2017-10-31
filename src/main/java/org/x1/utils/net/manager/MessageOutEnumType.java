package org.x1.utils.net.manager;

import org.x1.logic.activity.command.ActivityCommand;
import org.x1.logic.login.command.LoginCommand;
import org.x1.logic.moneytree.command.MoneyTreeCommand;
import org.x1.logic.playerinfo.command.PlayerInfoCommand;
import org.x1.logic.shop.command.ShopCommand;
import org.x1.utils.net.logic.ProtocolLogicAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/29******
 * 描述：
 */
public  enum  MessageOutEnumType {
    /**登陆*/
    LOGIN(1) {
        @Override
        public ProtocolLogicAdapter process(String[] params) {
            int loginType = Integer.parseInt(params[0]);
            String accont = params[1];
            String password = params[2];
            return new LoginCommand(loginType,accont,password);
        }
    },
    /**资料编辑*/
    PLAYER_INFO(2) {
        @Override
        public ProtocolLogicAdapter process(String[] params) {
            int head = Integer.parseInt(params[0]);
            String describle = params[1];
            String name = params[2];
            String password = params[3];
            return new PlayerInfoCommand(head,describle,name,password);
        }
    },
    /**签到*/
    ACTIVITY(3) {
        @Override
        public ProtocolLogicAdapter process(String[] params) {
            int weekDay = Integer.parseInt(params[0]);
            boolean draw = Boolean.parseBoolean(params[1]);
            return new ActivityCommand(weekDay,draw);
        }
    },
    /**摇钱树*/
    MONEY_TREE(4) {
        @Override
        public ProtocolLogicAdapter process(String[] params) {
            boolean get = Boolean.parseBoolean(params[0]);
            long time = Long.parseLong(params[1]);
            int money = Integer.parseInt(params[2]);
            int vipAdd = Integer.parseInt(params[3]);
            boolean buy = Boolean.parseBoolean(params[4]);
            return new MoneyTreeCommand(get,time,money,vipAdd,buy);
        }
    },
    /**商城*/
    SHOP(5) {
        @Override
        public ProtocolLogicAdapter process(String[] params) {
            int shopId = Integer.parseInt(params[0]);
            int goodsId = Integer.parseInt(params[1]);
            return new ShopCommand(shopId,goodsId);
        }
    };
    private int id;
    private MessageOutEnumType(int id){
        this.id = id;
    }
    public int id(){
        return id;
    }
    private static Map<Integer,MessageOutEnumType> map = new HashMap<>(MessageOutEnumType.values().length);
    static{
        MessageOutEnumType[] t = MessageOutEnumType.values();
        for(MessageOutEnumType e:MessageOutEnumType.values()){
            map.put(e.id(),e);
        }
    }
    public static MessageOutEnumType value(int id){
        return map.getOrDefault(id,null);
    }
    public abstract ProtocolLogicAdapter process(String[] params);
}
