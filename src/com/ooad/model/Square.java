package com.ooad.model;

/**
 * @param: nonez
 * @description: 方块Model
 * @author: KingJ
 * @create: 2018-12-19 20:13
 **/
public class Square{

    /*
     * 方格X坐标
     */
    private int X;

    /*
     * 方格Y坐标
     */
    private int Y;

    /*
     * 下一块方格
     */
    private Square nextSqaure;

    /*
     * 方格数量
     */
    private Piece piece;

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

    public Square(){
        this.piece = new Piece(this);
    }

}
