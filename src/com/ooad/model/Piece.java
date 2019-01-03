package com.ooad.model;


import com.ooad.model.Building.Hotel;
import com.ooad.model.Building.House;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.ooad.Context.GameState.*;

/**
 * @param: none
 * @description: 地皮Model
 * @author: KingJ
 * @create: 2018-12-19 20:31
 **/
public class Piece extends Tick implements Port {

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
    protected House houses;

    /**
     * 旅馆列表
     **/
    protected Hotel hotel;

    /**
     * 土地图片
     **/
    private Image pieceIMG;

    /**
     * 监狱信息
     */
    public static Point prison = new Point(0, 0);


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

    public House getHouses() {
        return houses;
    }

    public void setHouses(House houses) {
        this.houses = houses;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Image getPieceIMG() {
        return pieceIMG;
    }

    public void setPieceIMG(Image pieceIMG) {
        this.pieceIMG = pieceIMG;
    }


    public Piece(){
        this.houseNum = 0;
        this.hotelNum = 0;
        this.color = 0;
        this.price = 1000;
        this.owner = null;
        this.houses = null;
        this.hotel = null;
        this.pieceIMG =  new ImageIcon("img/background/land.jpg").getImage();
    }

    protected int[][] land = {
            // 模仿大富翁其中一个地图设置
            { ORIGIN, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, PRISON },
            { SPACE, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET,NULL_SET, NULL_SET, NULL_SET, NULL_SET, SPACE },
            { SPACE, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET,NULL_SET, NULL_SET, NULL_SET, NULL_SET, SPACE },
            { SPACE, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET,NULL_SET, NULL_SET, NULL_SET, NULL_SET, SPACE },
            { SPACE, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET,NULL_SET, NULL_SET, NULL_SET, NULL_SET, SPACE },
            { SPACE, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET, NULL_SET,NULL_SET, NULL_SET, NULL_SET, NULL_SET, SPACE },
            { PRISON, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE,SPACE, SPACE, SPACE, SPACE, SPACE }};

    public int[][] getLand() {
        return land;
    }

    /**
     * 开始游戏设置
     */
    @Override
    public void startGameInit() { }

    @Override
    public void updateData(long tick) {
        this.nowTick = tick;
    }
}
