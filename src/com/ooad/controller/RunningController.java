package com.ooad.controller;

import com.ooad.model.Bank;
import com.ooad.model.Buildings.Hotel;
import com.ooad.model.Buildings.House;
import com.ooad.model.Dice;
import com.ooad.model.Piece;
import com.ooad.model.Player;

/**
 * @param: none
 * @description: 游戏运行时Controller
 * @author: KingJ
 * @create: 2018-12-20 10:58
 **/
public class RunningController {

    private Bank bank;
    private BankController bankController = null;
    private Dice dice1 = null;
    private Dice dice2 = null;
    private Dice otherDice = null;
    private DiceController diceController1 = null;
    private DiceController diceController2 = null;
    private DiceController otherDiceController = null;
    private Player player;
    private PlayerController playerController = null;
    private PieceController pieceController = null;
    private House house = null;
    private Hotel hotel = null;

    public RunningController(Player player){
        this.player = player;
    }

    public void startNewRound(){
        dice1 = new Dice();
        dice2 = new Dice();
        otherDice = new Dice();
        diceController1 = new DiceController(dice1);
        diceController2 = new DiceController(dice2);
        otherDiceController = new DiceController(otherDice);
        // 三个色子分别掷一次
        diceController1.roll();
        diceController2.roll();
        otherDiceController.roll();
        playerController = new PlayerController(player, dice1, dice2, otherDice);
        // 获得前进步数
        int step = playerController.rollDice();

    }

    public void purchasePiece(Piece piece){
        playerController = new PlayerController(player, piece);
        // 玩家进行买房操作
        playerController.purchasePiece();
        pieceController = new PieceController(piece, player);
        // 房屋被卖
        pieceController.isPurchased();
    }

    public void buildHouse(Piece piece, Bank bank){
        house = new House(piece);
        playerController = new PlayerController(player, house);
        // 玩家建房
        playerController.buildHouse();
        pieceController = new PieceController(piece);
        // 地皮上建房
        pieceController.houseBuilt();
        bankController = new BankController(bank);
        // 银行建房操作
        bankController.buildHouse();
    }

    public void buildHotel(Piece piece, Bank bank){
        hotel = new Hotel(piece);
        playerController = new PlayerController(player, hotel);
        // 玩家建旅馆
        playerController.buildHotel();
        pieceController = new PieceController(piece);
        // 地皮上建旅馆
        pieceController.hotelBuilt();
        bankController = new BankController(bank);
        // 银行建旅馆操作
        bankController.buildHotel();
    }
}
