package org.x1.player.data;

import org.x1.logic.activity.model.PersistActivity;
import org.x1.logic.moneytree.model.MoneyTree;
import org.x1.utils.net.model.ISerializer;

/**
 * 作者：泡泡大湿
 * 时间： 2017/8/22.
 * 描述：
 */
public class PlayerEntity implements ISerializer {
    /**
     * id
     */
    private int id; // id
    /**
     * 名稱
     */
    private String name; // 名称
    /**
     * 賬號
     */
    private String account; // 账号
    /**
     * 賬號類型
     */
    private int type; // 账号类型（QQ,WX）
    /**
     * vip
     */
    private int vip; // vip
    /**
     * 排名
     */
    private int rank; // 排名
    /**
     * 金幣
     */
    private int gold; // 金币
    /**
     * 鑽石
     */
    private int diamond; // 钻石
    /**
     * 性別
     */
    private int gender; // 性别
    /**
     * 頭像
     */
    private int head; // 头像
    /**
     * 描述
     */
    private String discibe; // 描述
    /**
     * 摇钱树
     */
    private MoneyTree moneyTree;
    /**
     * 签到
     */
    private PersistActivity activity;
    /**
     * 密码
     */
    private String password;
    /**今天是周几*/
    private int weekDay;

    public PlayerEntity() {
    }

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

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
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

    public MoneyTree getMoneyTree() {
        return moneyTree;
    }

    public void setMoneyTree(MoneyTree moneyTree) {
        this.moneyTree = moneyTree;
    }

    public PersistActivity getActivity() {
        return activity;
    }

    public void setActivity(PersistActivity activity) {
        this.activity = activity;
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
}
