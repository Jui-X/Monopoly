package com.ooad.controller;

import com.ooad.controller.ModelController.PlayerController;
import com.ooad.model.Building.Hotel;
import com.ooad.model.Building.House;
import com.ooad.model.Piece;
import com.ooad.model.Player;


/**
 * @param: none
 * @description: 交易Controller
 * @author: KingJ
 * @create: 2018-12-21 22:09
 **/
public class DealController {

    private Player player1;
    private Player player2;
    private PlayerController playerController1 = null;
    private PlayerController playerController2 = null;
    private Piece piece;
    private House house;
    private Hotel hotel;

    public DealController(Player player1, Player player2, Piece piece){
        this.player1 = player1;
        this.player2 = player2;
        this.piece = piece;
    }

    public DealController(Player player1, Player player2, House house) {
        this.player1 = player1;
        this.player2 = player2;
        this.house = house;
    }

    public DealController(Player player1, Player player2, Hotel hotel) {
        this.player1 = player1;
        this.player2 = player2;
        this.hotel = hotel;
    }

    public void makeDeal(int price, Piece piece){
        playerController1 = new PlayerController(player1);
        playerController2 = new PlayerController(player2, piece);
        playerController1.payDeal(price);
        playerController2.sellPiece();
    }

    public void makeDeal(int price, House house){
        playerController1 = new PlayerController(player1);
        playerController2 = new PlayerController(player2, house);
        playerController1.payDeal(price);
        playerController2.sellHouse();
    }

    public void makeDeal(int price, Hotel hotel){
        playerController1 = new PlayerController(player1);
        playerController2 = new PlayerController(player2, hotel);
        playerController1.payDeal(price);
        playerController2.sellHotel();
    }

    public void makeDeal(Piece piece, int price){
        playerController1 = new PlayerController(player1, piece);
        playerController2 = new PlayerController(player2);
        playerController1.sellPiece();
        playerController2.payDeal(price);
    }

    public void makeDeal(House house, int price){
        playerController1 = new PlayerController(player1, house);
        playerController2 = new PlayerController(player2);
        playerController1.sellHouse();
        playerController2.payDeal(price);
    }

    public void makeDeal(Hotel hotel, int price){
        playerController1 = new PlayerController(player1, hotel);
        playerController2 = new PlayerController(player2);
        playerController1.sellHotel();
        playerController2.payDeal(price);
    }
}
