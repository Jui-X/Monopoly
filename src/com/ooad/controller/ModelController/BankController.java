package com.ooad.controller.ModelController;

import com.ooad.Context.GameState;
import com.ooad.model.Bank;
import com.ooad.Context.GameState;

/**
 * @param: none
 * @description: 银行Controller
 * @author: KingJ
 * @create: 2018-12-19 20:53
 **/
public class BankController {

    private Bank bank;

    public BankController(Bank bank){
        this.bank = bank;
    }

    public boolean buildHouse(){
        // 银行房产数 - 1
        bank.setHouseNum(bank.getHouseNum() - 1);
        return true;
    }

    public void buildHotel(){
        // 银行旅馆数 - 1
        bank.setHotelNum(bank.getHotelNum() - 1);
        bank.setHouseNum(bank.getHouseNum() + GameState.MAX_HOUSE);
    }

    public void cashoutHouse(){
        // 银行房产数 + 1
        bank.setHouseNum(bank.getHotelNum() + 1);
    }

    public void cashoutHotel(){
        // 银行旅馆数 + 1
        bank.setHotelNum(bank.getHotelNum() + 1);
    }

    public void acution(){
        bank.setHouseNum(bank.getHotelNum() - 1);
    }
}
