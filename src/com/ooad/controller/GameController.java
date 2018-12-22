package com.ooad.controller;

import com.ooad.controller.ModelController.*;
import com.ooad.model.Bank;
import com.ooad.model.Buildings.Hotel;
import com.ooad.model.Buildings.House;
import com.ooad.model.Dice;
import com.ooad.model.Piece;
import com.ooad.model.Player;

import java.util.List;

/**
 * @param: none
 * @description: 游戏运行时Controller
 * @author: KingJ
 * @create: 2018-12-20 10:58
 **/
public class GameController {

    private Bank bank;
    private BankController bankController = null;
    private Dice dice1 = null;
    private Dice dice2 = null;
    private Dice otherDice = null;
    private DiceController diceController1 = null;
    private DiceController diceController2 = null;
    private DiceController otherDiceController = null;
    private Player player;
    private List<Piece> pieceList;
    private PlayerController playerController = null;
    private MoveCotroller moveCotroller = null;
    private PieceController pieceController = null;
    private House house = null;
    private HouseController houseController = null;
    private Hotel hotel = null;
    private HotelController hotelController = null;
    private CashController cashController = null;

    public GameController(Player player, Bank bank){
        this.player = player;
        this.bank = bank;
    }

    public int startNewRound(){
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
        return step;
    }

    public void moveOn(){
        moveCotroller = new MoveCotroller(player, playerController, pieceList);
        // 开始一个新的回合
        Piece nowPiece = moveCotroller.moveOn(startNewRound());
        // 到达新位置以后的状态
        moveCotroller.landOn(nowPiece, pieceController);
    }

    public void purchasePiece(Piece piece){
        playerController = new PlayerController(player, piece);
        pieceController = new PieceController(piece, player);
        // 玩家进行买房操作
        if (playerController.purchasePiece()) {
            // 地皮被卖
            pieceController.isPurchased();
        }
        else {
            if (playerController.bankrupt()) {
                cashOutOrSell(piece.getPrice());
            }
        }
    }

    public void buildHouse(Piece piece, Bank bank){
        house = new House(piece);
        houseController = new HouseController(house, player, piece);
        playerController = new PlayerController(player, house);
        pieceController = new PieceController(piece, house);
        bankController = new BankController(bank);
        // 玩家建房
        if (playerController.buildHouse()) {
            // 房屋拥有者变更为玩家
            houseController.houseOwner();
            // 房屋与地皮相关联
            houseController.pieceOfHouse();
            // 地皮上建房
            pieceController.houseBuilt();
            // 银行建房操作
            bankController.buildHouse();
        }
        else {
            if (playerController.bankrupt()) {
                cashOutOrSell(house.getPrice());
            }
        }
    }

    public void buildHotel(Piece piece, Bank bank){
        hotel = new Hotel(piece);
        hotelController = new HotelController(hotel, player);
        playerController = new PlayerController(player, hotel);
        pieceController = new PieceController(piece, hotel);
        bankController = new BankController(bank);
        // 玩家建旅馆
        if (playerController.buildHotel()) {
            // 旅馆拥有者变更为玩家
            hotelController.hotelOwner();
            // 旅馆与地皮相关联
            hotelController.pieceOfHotel();
            // 地皮上建旅馆
            pieceController.hotelBuilt();
            // 银行建旅馆操作
            bankController.buildHotel();
        }
        else {
            if (playerController.bankrupt()) {
                cashOutOrSell(hotel.getPrice());
            }
        }
    }

    public void cashOut(Piece piece){
        playerController = new PlayerController(player);
        pieceController = new PieceController(piece, bank);
        cashController = new CashController(playerController, pieceController);
        // 地皮套现操作
        cashController.cashOutPiece();
    }

    public void soldHouse(House house){
        playerController = new PlayerController(player);
        bankController = new BankController(bank);
        houseController = new HouseController(house, bank);
        cashController = new CashController(playerController, bankController, houseController);
        // 卖房套现
        cashController.soldHouse();
    }

    public void soldHotel(Hotel hotel){
        playerController = new PlayerController(player);
        bankController = new BankController(bank);
        hotelController = new HotelController(hotel, bank);
        cashController = new CashController(playerController, bankController, hotelController);
        // 卖旅馆套现
        cashController.soldHotel();
    }

    public void cashOutOrSell(int price){
        if (player.getHotels() != null) {
            for (Hotel h: player.getHotels()) {
                this.soldHotel(h);
                if (player.getCash() >= price) return;
            }
        }
        else if (player.getHouses() != null) {
            for (House h: player.getHouses()) {
                this.soldHouse(h);
                if (player.getCash() >= price) return;
            }
        }
        else if (player.getPieces() != null) {
            for (Piece p: player.getPieces()) {
                this.cashOut(p);
                if (player.getCash() >= price) return;
            }
        }

    }

}
