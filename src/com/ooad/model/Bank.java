package com.ooad.model;

/**
 * @param: none
 * @description: 银行Model
 * @author: KingJ
 * @create: 2018-12-19 20:27
 **/
public class Bank implements Interface{

    /*
     * 房屋数量
     */
    private int houseNum;

    /*
     * 旅馆数量
     */
    private int hotelNum;

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public int getHotelNum() {
        return hotelNum;
    }

    public void setHotelNum(int hotelNum) {
        this.hotelNum = hotelNum;
    }

    public Bank(){
        initGame();
    }

    @Override
    public void updateData(){

    }

    @Override
    public void initGame(){
        this.houseNum = 32;
        this.hotelNum = 12;
    }
}
