package com.ooad.controller;

import com.ooad.Context.GameState;
import com.ooad.controller.ModelController.PieceController;
import com.ooad.controller.ModelController.PlayerController;
import com.ooad.model.Building.Building;
import com.ooad.model.Building.Go;
import com.ooad.model.Building.Jail;
import com.ooad.model.Buildings;
import com.ooad.model.Piece;
import com.ooad.model.Player;

import java.util.List;

/**
 * @param: none
 * @description: 移动Controller
 * @author: KingJ
 * @create: 2018-12-21 11:19
 **/
public class MoveCotroller {

    private Monopoly game;
    private Player player;
    private int landOnState = 0;

    public MoveCotroller(Player player){
        this.player = player;
    }

    public void moveOn(){
        for (int i = 0; i < (60 / player.getLastTime()); i++) {
            // 单位移动像素
            int movePixel = 1;
            if (player.getX() < 12 * 60 && player.getY() == 0) {
                player.setX(player.getX() + movePixel);
            } else if (player.getX() == 12 *60 && player.getY() < 7 * 60){
                player.setY(player.getY() + movePixel);
            } else if (player.getX() > 0 && player.getY() == 7 * 60){
                player.setX(player.getX() - movePixel);
            } else if (player.getX() == 0 && player.getY() > 0){
                player.setY(player.getY() - movePixel);
            }
        }
    }

    public void landOn(Building b, int landOnState, Player player) {
        switch (landOnState) {
            case GameState.HUOSE_EVENT:
                // 停留在可操作土地
                game.stopInHouse(b, player);
                break;
            case GameState.ORIGIN_EVENT:
                // 停留在原点
                game.stopInOrigin(b, player);
                break;
            case GameState.PRISON_EVENT:
                // 停留在监狱
                game.stopInPrison(b, player);
                break;
        }
    }




}
