package com.ooad.controller;

import com.ooad.controller.ModelController.*;
import com.ooad.model.*;
import com.ooad.model.Building.Building;
import com.ooad.model.Building.Hotel;
import com.ooad.model.Building.House;

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
    private Buildings buildings = null;
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
        //
        moveCotroller.moveOn();
    }

    public void landOn() {
        moveCotroller = new MoveCotroller(player, playerController, pieceList);
        // 该地点房屋
        Building building = this.buildings.getBuilding(player.getY() / 60,
                player.getX() / 60);
        if (building != null) {// 获取房屋
            int event = building.getEvent();
            // 触发房屋信息
            moveCotroller.landOn(building, event, player);
        }
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
        int X = player.getX();
        int Y = player.getY();
        houseController = new HouseController(house, player, piece);
        hotelController = new HotelController(hotel, player);
        playerController = new PlayerController(player, house, hotel);
        pieceController = new PieceController(piece, house, hotel);
        bankController = new BankController(bank);
        // 玩家建房
        if (piece.getHouses().getLevel() <4) {
            house = new House(X, Y);
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
        else {
            hotel = new Hotel(X, Y);
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
