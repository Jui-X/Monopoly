package com.ooad.controller;

import com.ooad.controller.ModelController.PlayerController;
import com.ooad.model.Bank;
import com.ooad.model.Buildings.House;
import com.ooad.model.Piece;

import java.util.List;

/**
 * @param: none
 * @description: 拍卖Controller
 * @author: KingJ
 * @create: 2018-12-21 19:26
 **/
public class AcutionController {

    private List<PlayerController> participants;
    private Bank bank;
    private Piece piece;
    private House house;

    public AcutionController(Bank bank, List<PlayerController> participants, Piece piece){
        this.bank = bank;
        this.participants = participants;
        this.piece = piece;
    }

    public AcutionController(Bank bank, List<PlayerController> participants, House house){
        this.bank = bank;
        this.participants = participants;
        this.house = house;
    }

    public void PieceAcution(){
        int bidding = 0;

    }

    public void HouseAcution(){
        int bidding = 0;
    }

}
