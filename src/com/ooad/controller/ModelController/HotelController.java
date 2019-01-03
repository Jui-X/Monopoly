package com.ooad.controller.ModelController;

import com.ooad.model.Building.Building;
import com.ooad.model.Building.Hotel;
import com.ooad.model.Piece;
import com.ooad.model.Player;

/**
 * @param: none
 * @description: 旅馆Controller
 * @author: KingJ
 * @create: 2018-12-19 21:37
 **/
public class HotelController {

    private Building building;
    private Player player;

    public HotelController(Building building, Player player){
        this.building = building;
        this.player = player;
    }

    public void hotelOwner(){
        building.setOwner(player);
    }

}
