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

    private static final int NORAMAL = 1;
    private static final int PLEDGED = 0;

    private Hotel hotel;
    private Player player;

    public HotelController(Hotel hotel, Player player){
        this.hotel = hotel;
        this.player = player;
    }

    public void hotelOwner(){
        hotel.setOwner(player);
    }

}
