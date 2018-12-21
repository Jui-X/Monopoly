package com.ooad.model;


import com.ooad.model.Buildings.Building;

import java.time.Period;
import java.util.List;

/**
 * @param: none
 * @description: 地皮Model
 * @author: KingJ
 * @create: 2018-12-19 20:31
 **/
public class Piece{

    /*
     * 房屋数
     */
    private int houseNum;

    /*
     * 旅馆数
     */
    private int hotelNum;

    /*
     * 颜色
     */
    private int color;

    /*
     * 可购买性
     */
    protected boolean purchasability;

    /*
     * 价格
     */
    protected int price;

    /*
     * 建筑拥有者姓名
     */
    protected Player owner;

    /*
     * 建筑列表
     */
    protected List<Building> building;

    /*
     * 所属方格
     */
    protected Square square = null;

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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isPurchasability() {
        return purchasability;
    }

    public void setPurchasability(boolean purchasability) {
        this.purchasability = purchasability;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public List<Building> getBuilding() {
        return building;
    }

    public void setBuilding(List<Building> building) {
        this.building = building;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Piece(Square square){
        this.houseNum = 0;
        this.hotelNum = 0;
        this.color = 0;
        this.price = 10000;
        this.purchasability = true;
        this.owner = null;
        this.building = null;
        this.square = square;
    }
}
