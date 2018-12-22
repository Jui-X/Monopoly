package com.ooad.controller;

import com.ooad.model.Player;

/**
 * @param: none
 * @description: 游戏Controller
 * @author: KingJ
 * @create: 2018-12-19 20:54
 **/
public class Monopoly {

    Player player;

    public GameController running = new GameController(player);
}
