package org.x1.player.model;

import com.alibaba.fastjson.JSON;
import org.x1.sqlmapper.PersistJson;
import org.x1.sqlmapper.PlayerInfoMapper;
import org.x1.utils.SpringUtils;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/12******
 * 描述：玩家基础信息
 */
public class PlayerInfo extends PersistJson<PlayerInfoMapper> {
    /**id*/
    private int id; // id
    /**名稱*/
    private String name; // 名称
    /**賬號*/
    private String account; // 账号
    /**賬號類型*/
    private int type; // 账号类型（QQ,WX）
    /**排名*/
    private int rank; // 排名
    /**性別*/
    private int gender; // 性别
    /**頭像*/
    private int head; // 头像
    /**描述*/
    private String discibe; // 描述
    /**密码*/
    private  String password;
    private int weekDay;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getDiscibe() {
        return discibe;
    }

    public void setDiscibe(String discibe) {
        this.discibe = discibe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public boolean update() {
        //    /**更新角色信息*/
        String playerInfo = JSON.toJSONString(this);
        PlayerModel model = new PlayerModel();
        model.setPlayerInfo(playerInfo);
        model.setId(this.id);
        this.serializer = SpringUtils.getBean(PlayerInfoMapper.class);
        this.serializer.update(model);
        return false;
    }
}
