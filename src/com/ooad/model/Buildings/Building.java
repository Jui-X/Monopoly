package com.ooad.model.Buildings;

import com.ooad.model.Piece;
import com.ooad.model.Player;

/**
 * @param: none
 * @description: 建筑Model
 * @author: KingJ
 * @create: 2018-12-20 11:00
 **/
public class Building {

    /*
     * 建筑名字
     */
    protected String name = null;

    /*
     * 税率
     */
    protected int revenue;

    /*
     * 建筑价格
     */
    protected int price;

    /*
     * 所属地皮
     */
    protected Piece piece;

    /*
     * 所属地皮
     */
    protected Player owner;

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

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
