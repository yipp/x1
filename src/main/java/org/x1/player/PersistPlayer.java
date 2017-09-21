package org.x1.player;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：泡泡大湿
 * 时间： 2017/8/22.
 * 描述：
 */
public class PersistPlayer {
    /**channel和player的缓存*/
    public static Map<Channel,CorePlayer> playerMap = new HashMap<>();
    /**id和player的缓存*/
    public static Map<Integer,CorePlayer> playerId = new HashMap<>();
    /**channel和账号的缓存*/
    public static Map<Channel,String> accountMap = new HashMap<>();
    /**channel和id缓存*/
    public static Map<Channel,Integer> idMap = new HashMap<>();
    /**id和channel的缓存*/
    public static Map<Integer,Channel> mapId = new HashMap<>();
}
