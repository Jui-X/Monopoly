package com.ooad.controller.ModelController;

import com.ooad.model.Buildings.Hotel;
import com.ooad.model.Player;

/**
 * @param: none
 * @description: 旅馆Controller
 * @author: KingJ
 * @create: 2018-12-19 21:37
 **/
public class HotelController {

    private Hotel hotel;

    public HotelController(Hotel hotel){
        this.hotel = hotel;
    }

    public void hotelOwner(Player player){
        hotel.setOwner(player);
    }


}
