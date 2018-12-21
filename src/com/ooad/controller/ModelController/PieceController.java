package com.ooad.controller.ModelController;

import com.ooad.model.Buildings.Hotel;
import com.ooad.model.Buildings.House;
import com.ooad.model.Piece;
import com.ooad.model.Player;

/**
 * @param: none
 * @description: 地皮Controller
 * @author: KingJ
 * @create: 2018-12-19 20:54
 **/
public class PieceController {

    private static final int MAX_HOUSENUM = 4;
    private static final int MAX_HOTELNUM = 1;
    private static final int ORANGE_PIECE = 1;
    private static final int PURPLE_PIECE = 2;

    private Piece piece;
    private Player player;
    private House house;
    private Hotel hotel;

    public PieceController(Piece piece, Player player){
        this.piece = piece;
        this.player = player;
    }

    public PieceController(Piece piece, House house){
        this.piece = piece;
        this.house = house;
    }

    public PieceController(Piece piece, Hotel hotel){
        this.piece = piece;
        this.hotel = hotel;
    }

    public void setOwner(){
        // 更新地皮拥有者
        piece.setOwner(player);
    }

    public boolean isPurchased(){
        // 将地皮可购买性设置为false
        if(piece.isPurchasability()){
            piece.setPurchasability(false);
            return true;
        }
        return false;
    }

    public void houseBuilt(){
        // 地皮上的房产数量增加
        piece.setHouseNum(piece.getHouseNum()+1);
        // 地皮房产列表新增房产
        piece.getBuilding().add(house);
    }

    public void hotelBuilt(){
        // 地皮上的旅馆数量增加
        piece.setHotelNum(piece.getHotelNum()+1);
        // 地皮房产旅馆新增旅馆
        piece.getBuilding().add(hotel);
    }

    public int getRent(){
        // 计算总租金
        double rent = piece.getHouseNum() * house.getPrice() * 0.1 +
                piece.getHotelNum() * hotel.getPrice() * 0.05;
        return (int)rent;
    }
}
