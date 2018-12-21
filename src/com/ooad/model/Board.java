package com.ooad.model;

/**
 * @param: none
 * @description: 面板Model
 * @author: KingJ
 * @create: 2018-12-19 19:59
 **/
public class Board{

    /*
     * 方格最大数量
     */
    private static final int MAX_SQUARE = 36;

    /*
     * 方格数量
     */
    private int squareNum = 0;

    public int getSquareNum() {
        return squareNum;
    }

    public void setSquareNum(int squareNum) {
        this.squareNum = squareNum;
    }

    public Board(){
        this.squareNum = MAX_SQUARE;
    }

}
