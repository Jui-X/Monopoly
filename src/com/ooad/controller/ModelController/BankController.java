package com.ooad.controller.ModelController;

import com.ooad.model.Bank;

/**
 * @param: none
 * @description: 银行Controller
 * @author: KingJ
 * @create: 2018-12-19 20:53
 **/
public class BankController {

    /*
     * 最大房屋数量
     */
    private static final int MAX_HOUSE = 32;

    /*
     * 最大旅馆数量
     */
    private static final int MAX_HOTEL = 12;

    private Bank bank;

    public BankController(Bank bank){
        this.bank = bank;
    }

    public boolean buildHouse(){
        // 银行房产数 - 1
        bank.setHouseNum(bank.getHouseNum() - 1);
        return true;
    }

    public boolean buildHotel(){
        // 银行旅馆数 - 1
        bank.setHotelNum(bank.getHotelNum() - 1);
        return true;
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
