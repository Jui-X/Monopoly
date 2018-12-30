package com.ooad.model;


import com.ooad.model.Buildings.Building;
import com.ooad.model.Buildings.Hotel;
import com.ooad.model.Buildings.House;

import java.util.ArrayList;

/**
 * @param: none
 * @description: 地皮Model
 * @author: KingJ
 * @create: 2018-12-19 20:31
 **/
public class Piece{

    /**
     * 房屋数
     */
    private int houseNum;

    /**
     * 旅馆数
     **/
    private int hotelNum;

    /**
     * 颜色
     **/
    private int color;

    /**
     * 价格
     **/
    protected int price;

    /**
     * 状态
     **/
    protected int state;

    /**
     * 建筑拥有者姓名
     **/
    protected Player owner;

    /**
     * 房产列表
     **/
    protected ArrayList<House> houses;

    /**
     * 旅馆列表
     **/
    protected Hotel hotel;

    /**
     * 方格X坐标
     **/
    private int X;

    /**
     * 方格Y坐标
     **/
    private int Y;

    /*
     * 下一块方格
     */
    private Piece nextPiece;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public void setHouses(ArrayList<House> houses) {
        this.houses = houses;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public Piece getNextPiece() {
        return nextPiece;
    }

    public void setNextPiece(Piece nextPiece) {
        this.nextPiece = nextPiece;
    }

    public Piece(){
        this.houseNum = 0;
        this.hotelNum = 0;
        this.color = 0;
        this.price = 1000;
        this.owner = null;
        this.houses = null;
        this.hotel = null;
    }
}
