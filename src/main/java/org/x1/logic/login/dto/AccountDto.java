package org.x1.logic.login.dto;

import org.x1.utils.net.model.ISerializer;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/12******
 * 描述：
 */
public class AccountDto implements ISerializer {
    /**登陆类型qq，微信，手机唯一标识*/
    private int loginType;
    /**账号*/
    private String account;
    /**密码*/
    private String password;

    public AccountDto() {
    }

    public AccountDto(int loginType, String account, String password) {
        this.loginType = loginType;
        this.account = account;
        this.password = password;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
