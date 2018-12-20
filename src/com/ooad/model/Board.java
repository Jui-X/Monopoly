package com.ooad.model;

/**
 * @param: none
 * @description: 面板Model
 * @author: KingJ
 * @create: 2018-12-19 19:59
 **/
public class Board implements Interface{

    private static final int MAP_SQUARE = 36;

    private int squareNum = 0;

    @Override
    public void updateData(){

    }

    @Override
    public void initGame(){
        this.squareNum = MAP_SQUARE;
    }
}
