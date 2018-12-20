package com.ooad.controller;

import com.ooad.model.Player;

/**
 * @param: none
 * @description: 游戏Controller
 * @author: KingJ
 * @create: 2018-12-19 20:54
 **/
public class GameController {

    Player player;

    public RunningController running = new RunningController(player);
}
