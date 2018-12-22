package com.ooad.controller;

import com.ooad.controller.ModelController.PieceController;
import com.ooad.controller.ModelController.PlayerController;
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

    private Player player;
    private PlayerController playerController;
    private List<Piece> pieceList;
    private Piece nowPiece = null;
    private int landOnState = 0;

    public MoveCotroller(Player player, PlayerController playerController, List<Piece> pieceList){
        this.player = player;
        this.playerController = playerController;
        this.pieceList = pieceList;
    }

    public Piece moveOn(int step){
        Piece nowPiece = null;
        player.setX(player.getX() + step);
        for (Piece p: pieceList){
            // 找到玩家新位置所处的地皮
            if (p.getSquare().getX() == player.getX() && p.getSquare().getY() == player.getY()){
                nowPiece = p;
                break;
            }
        }
        return nowPiece;
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
