package com.ooad.model.Building;

import com.ooad.model.Piece;
import com.ooad.model.Player;

import java.util.List;

/**
 * @param: none
 * @description: 建筑Model
 * @author: KingJ
 * @create: 2018-12-20 11:00
 **/
public class Building {

    /**
     * 建筑名字
     */
    protected String name = null;

    /**
     * 税率
     */
    protected int revenue;

    /**
     * 建筑价格
     */
    protected int price;

    /**
     * 状态
     */
    protected int state;

    /**
     * 所属地皮
     */
    protected Piece piece;

    /**
     * 坐标
     */
    protected int posX;
    protected int posY;

    /**
     * 所属玩家
     */
    protected Player owner;

    /**
     * 可购买性
     */
    protected boolean purchasability = false;

    /**
     * 当前房屋等级
     */
    protected int level;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
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

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean isPurchasability() {
        return purchasability;
    }

    public void setPurchasability(boolean purchasability) {
        this.purchasability = purchasability;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public Building(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.name = "house";
    }

    /**
     * 触发事件
     */
    public int getEvent() { return 0;}
    /**
     * 路过事件
     */
    public int passEvent() { return 0;}
}
