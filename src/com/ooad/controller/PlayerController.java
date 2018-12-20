package com.ooad.controller;

import com.ooad.model.Buildings.Hotel;
import com.ooad.model.Buildings.House;
import com.ooad.model.Dice;
import com.ooad.model.Piece;
import com.ooad.model.Player;

import java.util.List;

/**
 * @param: none
 * @description: 玩家Controller
 * @author: KingJ
 * @create: 2018-12-19 20:53
 **/
public class PlayerController {

    private Player player;
    private Dice dice1;
    private Dice dice2;
    private Dice otherDice;
    private Piece piece;
    private House house;
    private Hotel hotel;

    public PlayerController(Player player, Dice dice1, Dice dice2, Dice otherDice){
        this.player = player;
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.otherDice = otherDice;
    }

    public PlayerController(Player player, Piece piece){
        this.player = player;
        this.piece = piece;
    }

    public PlayerController(Player player, House house){
        this.player = player;
        this.house = house;
    }

    public PlayerController(Player player, Hotel hotel){
        this.player = player;
        this.hotel = hotel;
    }

    public int rollDice(){
        int step;
        // 判断两次掷色点数是否相同，若相同增加额外回合
        if (dice1.getPoint()==dice2.getPoint()){
            // 若第三回合点数与前两回合也相同，则直接进监狱
            if (otherDice.getPoint() == dice1.getPoint()){
                step = 0;
                player.putIntoJail();
                return step;
            }
            // 否则总步数等于三次掷色之和
            else {
                step = dice1.getPoint() + dice2.getPoint() + otherDice.getPoint();
                return step;
            }
        }
        // 不同则总步数等于两次掷色之和
        else {
            step = dice1.getPoint() + dice2.getPoint();
            return step;
        }
    }

    public void moveOn(){
        int step = rollDice();
    }

    public void purchasePiece(){
        // 玩家现金减少，减少数量对应相应的地皮价格
        player.setCash(player.getCash() - piece.getPrice());
        // 玩家地产增加
        player.getPieces().add(piece);
    }

    public void buildHouse(){
        // 玩家现金减少，减少数量对应相应的房屋价格
        player.setCash(player.getCash() - house.getPrice());
        // 玩家房产增加
        player.getHouses().add(house);
    }

    public void buildHotel(){
        // 玩家现金减少，减少数量对应相应的旅馆价格
        player.setCash(player.getCash() - hotel.getPrice());
        // 玩家房产增加
        player.getHotels().add(hotel);
    }
}
