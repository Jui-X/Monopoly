package com.ooad.controller.ModelController;

import com.ooad.model.Bank;
import com.ooad.model.Buildings.House;
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

    public HouseController(House house, Player player){
        this.house = house;
        this.player = player;
    }

    public void houseOwner(){
        house.setOwner(player);
    }

}
