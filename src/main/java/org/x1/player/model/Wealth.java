package org.x1.player.model;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.x1.player.data.CorePlayer;
import org.x1.player.data.PersistPlayer;
import org.x1.player.dto.WealthDto;
import org.x1.sqlmapper.PersistJson;
import org.x1.sqlmapper.PlayerInfoMapper;
import org.x1.sqlmapper.WealthMapper;
import org.x1.utils.SpringUtils;
import org.x1.utils.net.model.Response;
import org.x1.utils.serializer.protostuffer.SerializerUtils;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/12******
 * 描述：玩家财富
 */
public class Wealth extends PersistJson<WealthMapper>{
    /**vip*/
    private int vip; // vip
    /**金幣*/
    private int gold; // 金币
    /**鑽石*/
    private int diamond; // 钻石
    /**vip到期时间*/
    private long vipUpdateTime;
    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
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

    public long getVipUpdateTime() {
        return vipUpdateTime;
    }

    public void setVipUpdateTime(int vipUpdateTime) {
        this.vipUpdateTime = vipUpdateTime;
    }

    @Override
    public boolean executorUpdate() {
        //    /**更新角色信息*/
        String wealth = JSON.toJSONString(this);
        PlayerModel model = new PlayerModel();
        model.setWealth(wealth);
        model.setId(this.getId());
        this.serializer = SpringUtils.getBean(WealthMapper.class);
        this.serializer.update(model);
        wealthNotify();
        return false;
    }
    private void wealthNotify(){
        //财富刷新
        CorePlayer corePlayer = PersistPlayer.playerId.get(this.getId());
        Response response = new Response();
        WealthDto wealthDto = new WealthDto();
        BeanUtils.copyProperties(this,wealthDto);
        response.setId((short) 100);
        byte[] buf = SerializerUtils.serializer(wealthDto);
        response.setData(buf);
        corePlayer.getChannel().writeAndFlush(response);
    }
}
