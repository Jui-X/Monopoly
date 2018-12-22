package com.ooad.controller.ModelController;

import com.ooad.Context.GameState;
import com.ooad.model.Buildings.Hotel;
import com.ooad.model.Buildings.House;
import com.ooad.model.Piece;
import com.ooad.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @param: none
 * @description: 地皮Controller
 * @author: KingJ
 * @create: 2018-12-19 20:54
 **/
public class PieceController {

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

    public void pieceOwner(){
        // 更新地皮拥有者
        piece.setOwner(player);
    }

    public boolean isPurchased(){
        // 将地皮可购买性设置为false
        if(piece.getState() == GameState.OWNERLESS){
            piece.setState(GameState.SOLD);
            return true;
        }
        return false;
    }

    public void isPledged(){
        if(piece.getState() == GameState.SOLD){
            piece.setState(GameState.PLEDGED);
        }
    }

    public void isRedeemed(){
        if (piece.getState() == GameState.PLEDGED){
            piece.setState(GameState.SOLD);
        }
    }

    public void houseBuilt(){
       if (piece.getHouseNum() < GameState.MAX_HOUSENUM){
           // 地皮上的房产数量增加
           piece.setHouseNum(piece.getHouseNum() + 1);
           // 地皮新增房产
           piece.getHouses().add(house);
       }
    }

    public void hotelBuilt(){
        if (piece.getHotelNum() < GameState.MAX_HOTELNUM){
            // 地皮上的旅馆数量增加
            piece.setHotelNum(piece.getHotelNum() + 1);
            // 地皮新增旅馆
            piece.setHotel(hotel);
            //
            piece.getHouses().removeAll(piece.getHouses());
        }
    }

    public int getRent(){
        // 计算总租金
        if (piece.getState() == GameState.SOLD){
            double rent = piece.getHouseNum() * house.getPrice() * 0.1 +
                    piece.getHotelNum() * hotel.getPrice() * 0.05;
            return (int)rent;
        }
        else {return 0;}
    }
}
