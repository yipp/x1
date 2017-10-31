package org.x1.logic.playerinfo.command;

import org.x1.utils.net.logic.ProtocolLogicAdapter;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/29******
 * 描述：
 */
public class PlayerInfoCommand extends ProtocolLogicAdapter {
    private final int head;
    private final String describle;
    private final String name;
    private final String password;

    public PlayerInfoCommand(int head, String describle, String name, String password) {
        this.head = head;
        this.describle = describle;
        this.name = name;
        this.password = password;
    }

    @Override
    public void executor() {

    }
}
