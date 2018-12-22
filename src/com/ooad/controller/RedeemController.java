package com.ooad.controller;

import com.ooad.controller.ModelController.*;


/**
 * @param: none
 * @description: 赎回Controller
 * @author: KingJ
 * @create: 2018-12-22 10:37
 **/
public class RedeemController {

    private PlayerController playerController;
    private BankController bankController;
    private PieceController pieceController;
    private HouseController houseController;
    private HotelController hotelController;

    public RedeemController(PlayerController playerController, PieceController pieceController){
        this.playerController = playerController;
        this.pieceController = pieceController;
    }

    public RedeemController(BankController bankController, PlayerController playerController, HouseController houseController) {
        this.bankController = bankController;
        this.playerController = playerController;
        this.houseController = houseController;
    }

    public RedeemController(BankController bankController, PlayerController playerController, HotelController hotelController) {
        this.bankController = bankController;
        this.playerController = playerController;
        this.hotelController = hotelController;
    }

    // 赎回地皮
    public void redeemPiece(){
        // 地皮拥有者变回玩家
        pieceController.pieceOwner();
        // 地皮状态变更
        pieceController.isRedeemed();
        // 玩家赎回操作
        playerController.redeemPiece();
    }

}
