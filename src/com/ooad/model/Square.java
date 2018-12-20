package com.ooad.model;

/**
 * @param: none
 * @description: 方块Model
 * @author: KingJ
 * @create: 2018-12-19 20:13
 **/
public class Square implements Interface{

    private int X;

    private int Y;

    private Square nextSqaure;

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

    public Square getNextSqaure() {
        return nextSqaure;
    }

    public void setNextSqaure(Square nextSqaure) {
        this.nextSqaure = nextSqaure;
    }

    @Override
    public void updateData(){

    }

    @Override
    public void initGame(){

    }
}
