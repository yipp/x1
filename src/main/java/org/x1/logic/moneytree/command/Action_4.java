package org.x1.logic.moneytree.command;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.x1.calendar.DateUtils;
import org.x1.error.data.ErrorCode;
import org.x1.error.manager.AppErrorGeneral;
import org.x1.logic.moneytree.data.MoneyTreeTable;
import org.x1.logic.moneytree.dto.MoneyTreeDto;
import org.x1.logic.moneytree.model.MoneyTree;
import org.x1.logic.vip.data.VipTable;
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
        int vipAdd = 0;
        int getMoney = 0;
        if(!tree.isBuyTree() && this.getMsg().isBuy() && entity.getDiamond()<10) {
            new AppErrorGeneral(this.getCtx(), ErrorCode.DIAMOND_DEFICIENCY);
        }else if(!tree.isBuyTree() && this.getMsg().isBuy() && entity.getDiamond()>10){
            int diamond = entity.getDiamond();
            diamond -= 10;
            entity.setDiamond(diamond);
            tree.setBuyTree(true);
            tree.setId(entity.getId());
            tree.setTime(DateUtils.currentTime());
            recieve = true;
        }else if(tree.isBuyTree() && this.getMsg().isGet()){
            int time = (int) ((DateUtils.currentTime() - tree.getTime())/(1000*60*60));
            if(time>0){
                //加金币
                int money = entity.getGold();
                getMoney = MoneyTreeTable.get(entity.getVip()).getMake();
                int timer = time > 24 ? 24:time;
                getMoney *= timer;
                if(entity.getVip()>0)
                    vipAdd = (int) (getMoney*VipTable.get(entity.getVip()).getMoneyTreeAdd());
                entity.setGold(money+getMoney+vipAdd);
                recieve = true;
            }
        }
        if(recieve) {
            Wealth wealth = new Wealth();
            BeanUtils.copyProperties(entity,wealth);
            wealth.update();
            tree.update();
        }
        this.response(new MoneyTreeDto(recieve,DateUtils.currentTime(),getMoney,vipAdd,tree.isBuyTree()));
    }
}
