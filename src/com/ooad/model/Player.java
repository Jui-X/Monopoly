package com.ooad.model;

import com.ooad.model.Buildings.Hotel;
import com.ooad.model.Buildings.House;

import java.util.ArrayList;
import java.util.List;

/**
 * @param: none
 * @description: 玩家Model
 * @author: KingJ
 * @create: 2018-12-19 20:11
 **/
public class Player implements Interface{

    /*
     * 姓名
     */
    private String name;

    /*
     * 现金
     */
    private int cash;

    /*
     * 当前位置x坐标
     */
    private int x;

    /*
     * 当前位置y坐标
     */
    private int y;

    /*
     * 剩余坐牢天数
     */
    private int inJail;

    /*
     * 房屋数
     */
    private List<House> houses = new ArrayList<House>();

    /*
     * 旅馆数
     */
    private List<Hotel> hotels = new ArrayList<Hotel>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getInJail() {
        return inJail;
    }

    public void setInJail(int inJail) {
        this.inJail = inJail;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public void updateData(){

    }

    @Override
    public void initGame() {

    }
}
