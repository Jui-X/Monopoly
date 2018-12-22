package com.ooad.model.Buildings;

import com.ooad.controller.ModelController.PlayerController;

/**
 * @param: none
 * @description: 起点UI
 * @author: KingJ
 * @create: 2018-12-19 20:57
 **/
public class Go extends Building{

    /*
     * 经过起点奖励金
     */
    private static final int rewardMoney = 2000;
    private PlayerController playerController;

    public Go(PlayerController playerController){
        this.playerController = playerController;
    }

    public void passGo(){
        // 经过起点奖励
        playerController.goPass(rewardMoney);
    }
}
