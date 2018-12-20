package com.ooad.controller;

import com.ooad.model.Piece;
import com.ooad.model.Player;

/**
 * @param: none
 * @description: 地皮Controller
 * @author: KingJ
 * @create: 2018-12-19 20:54
 **/
public class PieceController {
    private Piece piece;
    private Player player;

    public PieceController(Piece piece){
        this.piece = piece;
    }

    public PieceController(Piece piece, Player player){
        this.piece = piece;
        this.player = player;
    }

    public boolean isPurchased(){
        piece.setOwner(player);
        piece.setPurchasability(false);
        return true;
    }

    public void houseBuilt(){
        piece.setHouseNum(piece.getHouseNum()+1);
    }

    public void hotelBuilt(){
        piece.setHotelNum(piece.getHotelNum()+1);
    }
}
