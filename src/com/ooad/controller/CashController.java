package com.ooad.controller;

import com.ooad.controller.ModelController.*;

/**
 * @param: none
 * @description: 抵押Controller
 * @author: KingJ
 * @create: 2018-12-22 10:36
 **/
public class CashController {

    private PlayerController playerController;
    private BankController bankController;
    private PieceController pieceController;
    private HouseController houseController;
    private HotelController hotelController;

    public CashController(PlayerController playerController, PieceController pieceController) {
        this.playerController = playerController;
        this.pieceController = pieceController;
    }

    public CashController(PlayerController playerController, BankController bankController, HouseController houseController) {
        this.playerController = playerController;
        this.bankController = bankController;
        this.houseController = houseController;
    }

    public CashController(PlayerController playerController, BankController bankController, HotelController hotelController) {
        this.playerController = playerController;
        this.bankController = bankController;
        this.hotelController = hotelController;
    }

    // 玩家抵押地皮套现
    public void cashOutPiece(){
        // 地皮拥有者变更为Bank
        pieceController.pieceOwner();
        // 地皮状态变更为已抵押
        pieceController.isPledged();
        // 玩家抵押地皮套现操作
        playerController.sellPiece();
    }

    public void soldHouse(){
        // 房产拥有者变为Bank
        houseController.houseOwner();
        // 玩家卖掉房产获得现金操作
        playerController.sellHouse();
        // 银行获得房产操作
        bankController.cashoutHouse();
    }

    public void soldHotel(){
        // 房产拥有者变为Bank
        hotelController.hotelOwner();
        // 玩家卖掉旅馆获得现金操作
        playerController.sellHotel();
        // 银行获得旅馆操作
        bankController.cashoutHotel();
    }
}
