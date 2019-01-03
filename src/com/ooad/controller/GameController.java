package com.ooad.controller;

import com.ooad.Context.GameState;
import com.ooad.controller.ModelController.*;
import com.ooad.model.*;
import com.ooad.model.Building.Building;
import com.ooad.model.Building.Go;
import com.ooad.model.Building.Hotel;
import com.ooad.model.Building.House;
import com.ooad.util.MyThread;

import javax.swing.*;
import java.util.List;

/**
 * @param: none
 * @description: 游戏运行时Controller
 * @author: KingJ
 * @create: 2018-12-20 10:58
 **/
public class GameController {

    private Monopoly game;
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


    public GameController(Monopoly game, Player player, Bank bank){
        this.game = game;
        this.player = player;
        this.bank = bank;
    }

    public int startNewRound(){
        dice1 = new Dice(game);
        dice2 = new Dice(game);
        otherDice = new Dice(game);
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
        moveCotroller = new MoveCotroller(game, player);
        // 玩家移动
        moveCotroller.moveOn();
    }

    public void landOn() {
        moveCotroller = new MoveCotroller(game, player);
        // 该地点房屋
        Building building = game.getBuildings().getBuilding(player.getY() / 60,
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

    public void buildHouse(Building building, Bank bank){
        int X = player.getX();
        int Y = player.getY();
        bankController = new BankController(bank);
        // 玩家建房
        if (building.getLevel() == 0) {
            house = new House(X, Y);
            houseController = new HouseController(house, player);
            playerController = new PlayerController(player, house);
            if (playerController.buildHouse(house)) {
                // 房屋拥有者变更为玩家
                houseController.houseOwner();
                // 银行建房操作
                bankController.buildHouse();
            } else {
                if (playerController.bankrupt()) {
                    cashOutOrSell(house.getPrice());
                }
            }

        }
        else if (building.getLevel() < 4) {
            houseController = new HouseController(house, player);
            playerController = new PlayerController(player, house);
            if (playerController.buildHouse(null)) {
                // 房屋升级
                houseController.levelUp(building.getLevel() + 1);
                // 银行建房操作
                bankController.buildHouse();
            } else {
                if (playerController.bankrupt()) {
                    cashOutOrSell(house.getPrice());
                }
            }
        }
        else {
            hotel = new Hotel(X, Y);
            hotelController = new HotelController(hotel, player);
            playerController = new PlayerController(player, hotel);
            if (playerController.buildHotel(hotel)) {
                // 旅馆拥有者变更为玩家
                hotelController.hotelOwner();
                // 银行建旅馆操作
                bankController.buildHotel();
            }
            else {
                if (playerController.bankrupt()) {
                    cashOutOrSell(hotel.getPrice());
                }
            }
        }
        new Thread(new MyThread(game, 1)).start();
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

    }

    public void goPass(Building building) {
        playerController.goPass(((Go) building).getPassReward());
    }

    public void payRent(Building building, Player player) {
        int revenue = building.getRevenue();
        // 该玩家减少金币
        playerController.payRent(revenue);
        PlayerController otherController = new PlayerController(building.getOwner());
        // 业主得到金币
        otherController.collectRent(revenue);
    }

}
