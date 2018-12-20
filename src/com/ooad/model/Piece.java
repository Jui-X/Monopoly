package com.ooad.model;


/**
 * @param: none
 * @description: 地皮Model
 * @author: KingJ
 * @create: 2018-12-19 20:31
 **/
public class Piece extends Square implements Interface{

    private static final int MAX_HOUSENUM = 4;

    private static final int MAX_HOTELNUM = 1;

    private static final int ORANGE_PIECE = 1;

    private static final int PURPLE_PIECE = 2;

    /*
     * 房屋数
     */
    private int houseNum = 0;

    /*
     * 旅馆数
     */
    private int hotelNum = 0;

    /*
     * 颜色
     */
    private int color = 0;

    /*
     * 可购买性
     */
    protected boolean purchasability = true;

    /*
     * 价格
     */
    protected int price = 0;

    /*
     * 建筑拥有者姓名
     */
    protected Player owner = null;

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

    @Override
    public void updateData(){

    }

    @Override
    public void initGame(){

    }
}
