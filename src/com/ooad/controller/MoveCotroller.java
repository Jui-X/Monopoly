package com.ooad.controller;

import com.ooad.Context.GameState;
import com.ooad.controller.ModelController.PieceController;
import com.ooad.controller.ModelController.PlayerController;
import com.ooad.model.Building.Building;
import com.ooad.model.Building.Go;
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
    private PlayerController playerController;
    private List<Piece> pieceList;
    private Piece nowPiece = null;
    private int landOnState = 0;

    public MoveCotroller(Monopoly game, Player player, PlayerController playerController, List<Piece> pieceList){
        this.game = game;
        this.player = player;
        this.playerController = playerController;
        this.pieceList = pieceList;
    }

    public void moveOn(){
        for (int i = 0; i < (60 / game.getNowPlayer().getLastTime()); i++) {
            Player p = game.getNowPlayer();
            // 单位移动像素
            int movePixel = 1;
            if (p.getX() < 12 * 60 && p.getY() == 0) {
                p.setX(p.getX() + movePixel);
            } else if (p.getX() == 12 *60 && p.getY() < 7 * 60){
                p.setY(p.getY() + movePixel);
            } else if (p.getX() > 0 && p.getY() == 7 * 60){
                p.setX(p.getX() - movePixel);
            } else if (p.getX() == 0 && p.getY() > 0){
                p.setY(p.getY() - movePixel);
            }
        }
    }

    public void landOn(Piece nowPiece, PieceController pieceController){
        if(nowPiece.getState() == 0){
            // 询问玩家是否要购买地皮
            if(playerController.purchasePiece()) {

            }
            //否则立刻开始拍卖
            else {

            }
        }
        else {
            // 向路过玩家收税
            if (playerController.payRent(pieceController.getRent())) {
                Player owner = nowPiece.getOwner();
                PlayerController ownerController = new PlayerController(owner);
                ownerController.collectRent(pieceController.getRent());
            }
        }
    }


}
