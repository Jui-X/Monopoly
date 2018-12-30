package com.ooad.model;

import javax.swing.*;
import java.awt.*;

/**
 * @param: none
 * @description: 面板Model
 * @author: KingJ
 * @create: 2018-12-19 19:59
 **/
public class Board extends Tick implements Port {

    /**
     * 方格最大数量
     **/
    private static final int MAX_SQUARE = 36;

    /**
     * 方格数量
     **/
    private int squareNum;

    /**
     * 背景图像
     */
    private Image bg = null;

    public int getSquareNum() {
        return squareNum;
    }

    public void setSquareNum(int squareNum) {
        this.squareNum = squareNum;
    }

    public Image getBg() {
        return bg;
    }

    public void setBg(Image bg) {
        this.bg = bg;
    }

    public Board(){
        this.squareNum = MAX_SQUARE;
    }

    /**
     * 开始游戏设置
     */
    @Override
    public void startGameInit (){
        this.bg = new ImageIcon("images/background/bg.jpg").getImage();
    }

    @Override
    public void updateData(long tick) {
        this.nowTick = tick;
    }

}
