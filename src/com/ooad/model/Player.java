package com.ooad.model;

import com.ooad.Context.GameState;
import com.ooad.controller.Monopoly;
import com.ooad.model.Buildings.Hotel;
import com.ooad.model.Buildings.House;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @param: none
 * @description: 玩家Model
 * @author: KingJ
 * @create: 2018-12-19 20:11
 **/
public class Player extends Tick implements Port {

    /**
     * 姓名
     */
    private String name;

    /**
     * 现金
     */
    private int cash;

    /**
     * 当前位置x坐标
     */
    private int x;

    /**
     * 当前位置y坐标
     */
    private int y;

    /**
     * 玩家状态
     */
    private int state;

    /**
     * 剩余坐牢天数
     */
    private int inJail;

    /**
     * 房屋数
     */
    private List<Piece> pieces = new ArrayList<Piece>();

    /**
     * 房屋数
     */
    private List<House> houses = new ArrayList<House>();

    /**
     * 旅馆数
     */
    private List<Hotel> hotels = new ArrayList<Hotel>();

    /**
     * 玩家图片
     **/
    private Image[] playerIMG = new Image[100];

    /**
     * 玩家编号,显示房屋图片使用
     */
    private int number = 0;

    /**
     * 当前玩家
     **/
    private int role = 0;

    /**
     * 对方玩家
     **/
    private Player otherPlayer = null;

    /**
     * 游戏控制器
     */
    private Monopoly game = null;



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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getInJail() {
        return inJail;
    }

    public void setInJail(int inJail) {
        this.inJail = inJail;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    public Player(int number, Monopoly game){
        this.game = game;
        this.number = number;
        this.houses = null;
        this.hotels = null;
    }

    /**
     * 初始化玩家图像
     */
    private void initPlayerIMG() {
        // LOGO
        this.playerIMG[0] = new ImageIcon("img/player/" + this.getRole()
                + "/logo.png").getImage();
        // mini_false
        this.playerIMG[1] = new ImageIcon("img/player/" + this.getRole()
                + "/mini_01.png").getImage();
        // mini_true
        this.playerIMG[2] = new ImageIcon("img/player/" + this.getRole()
                + "/mini_01_on.png").getImage();
        // head_h5
        this.playerIMG[3] = new ImageIcon("img/player/" + this.getRole()
                + "/head_h5.png").getImage();
        // smile
        this.playerIMG[4] = new ImageIcon("img/player/" + this.getRole()
                + "/smile.png").getImage();
        // sad
        this.playerIMG[5] = new ImageIcon("img/player/" + this.getRole()
                + "/sad.png").getImage();
        // mini_02
        this.playerIMG[6] = new ImageIcon("img/player/" + this.getRole()
                + "/mini_02.png").getImage();
    }

    /**
     *
     * 获取玩家图像
     *
     * @return <li>logo LOGO</li> <li>mini 小图标-无边</li> <li>mini_on 小图标-有边</li>
     *         <i>h5 图像 </li> <li>other null</li>
     */
    public Image getIMG(String str) {
        if (str.equals("logo"))
            return this.playerIMG[0];
        else if (str.equals("mini"))
            return this.playerIMG[1];
        else if (str.equals("mini_on"))
            return this.playerIMG[2];
        else if (str.equals("h5"))
            return this.playerIMG[3];
        else if (str.equals("smile"))
            return this.playerIMG[4];
        else if (str.equals("sad"))
            return this.playerIMG[5];
        else if (str.equals("mini_02"))
            return this.playerIMG[6];
        else
            return null;
    }

    @Override
    public void startGameInit() {
        // 初始化玩家图像
        this.initPlayerIMG();
        // 设置单位方格（60px）的运动时间
        this.lastTime = Monopoly.rate / 3;
        // 初始化玩家金钱
        this.cash = GameState.PLAYER_ORIGIN_CASH;
    }

    @Override
    public void updateData(long tick) {

    }
}
