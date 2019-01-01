package com.ooad.controller.ModelController;

import com.ooad.model.Building.House;
import com.ooad.model.Piece;
import com.ooad.model.Player;

/**
 * @param: none
 * @description: 房屋Controller
 * @author: KingJ
 * @create: 2018-12-19 21:37
 **/
public class HouseController {

    private static final int NORAMAL = 1;
    private static final int PLEDGED = 0;

    private House house;
    private Player player;
    private Piece piece;

    public HouseController(House house, Player player) {
        this.house = house;
        this.player = player;
    }

    public HouseController(House house, Player player, Piece piece){
        this.house = house;
        this.player = player;
        this.piece = piece;
    }

    public void houseOwner(){
        house.setOwner(player);
    }

    public void pieceOfHouse(){
        house.setPiece(piece);
    }

}
