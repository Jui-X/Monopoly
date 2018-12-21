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

    private House house;

    public HouseController(House house){
        this.house = house;
    }

    public void houseOwner(Player player){
        house.setOwner(player);
    }

}
