package com.ooad.model.Building;

import com.ooad.Context.GameState;
import com.ooad.controller.ModelController.PlayerController;

/**
 * @param: none
 * @description: 起点UI
 * @author: KingJ
 * @create: 2018-12-19 20:57
 **/
public class Go extends Building{

    /**
     * 通过时奖励的金钱
     */
    private int passReward;
    /**
     * 停留时奖励金钱
     */
    private int reward;

    public Go(int posX, int posY){
        super(posX, posY);
    }

    public int getPassReward() {
        return passReward;
    }

    public int getReward() {
        return reward;
    }

    @Override
    public int getEvent() {
        return GameState.ORIGIN_EVENT;
    }
}
