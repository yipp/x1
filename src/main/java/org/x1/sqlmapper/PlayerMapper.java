package org.x1.sqlmapper;

import org.springframework.stereotype.Service;
import org.x1.player.model.PlayerModel;

/**
 * 作者：---->泡泡大湿<-----
 * 时间：********2017/10/12******
 * 描述：
 */
@Service
public interface PlayerMapper extends ISqlJsonSerializer{
    PlayerModel selectUser(Integer id);
    PlayerModel selectUserForAccount(String account);
    String selectAll();
    void addUser(PlayerModel model);
    void updateUser(PlayerModel model);
    void deleteUser(Integer id);
}