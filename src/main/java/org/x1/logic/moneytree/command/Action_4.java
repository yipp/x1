package org.x1.logic.moneytree.command;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.x1.calendar.DateUtils;
import org.x1.logic.activity.dto.ActivityDto;
import org.x1.logic.moneytree.dto.MoneyTreeDto;
import org.x1.logic.moneytree.model.MoneyTree;
import org.x1.player.data.PlayerEntity;
import org.x1.player.model.Wealth;
import org.x1.utils.net.logic.ProtocolLogicAdapter;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/14******
 * 描述：
 */
@Service
public class Action_4 extends ProtocolLogicAdapter<MoneyTreeDto> {
    @Override
    public void executor() {
        PlayerEntity entity = getCorePlayer().getPlayerEntity();
        MoneyTree tree = entity.getMoneyTree();
        boolean recieve = false;
        if(!tree.isBuyTree()){
            tree.setBuyTree(true);
            tree.setId(entity.getId());
            tree.setTime(DateUtils.currentTime());
            recieve = true;
        }else{
            int time = (int) (DateUtils.currentTime() - tree.getTime());
            if(time/(1000*60*60)>0){
                //加金币
                int money = entity.getGold();
                entity.setGold(money+1000);
                Wealth wealth = new Wealth();
                BeanUtils.copyProperties(entity,wealth);
                wealth.update();
                recieve = true;
            }else{
                //时间不够需要等待
            }
        }
        tree.update();
        this.response(new MoneyTreeDto(recieve,DateUtils.currentTime(),101));
    }
}
