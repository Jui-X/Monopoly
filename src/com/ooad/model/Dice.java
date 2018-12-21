package com.ooad.model;

/**
 * @param: none
 * @description: 骰子Model
 * @author: KingJ
 * @create: 2018-12-19 20:12
 **/
public class Dice{

    /*
     * 骰子运行状态
     */
    private static final int DICE_RUNNING = 1;

    /*
     * 骰子停止状态
     */
    private static final int DICE_STOP = 2;

    /*
     * 点数
     */
    private int point = 0;

    /*
     * 骰子状态
     */
    private int diceState = 0;

    /*
     * 按钮状态
     */
    private int btnState = 0;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getDiceState() {
        return diceState;
    }

    public void setDiceState(int diceState) {
        this.diceState = diceState;
    }

    public int getBtnState() {
        return btnState;
    }

    public void setBtnState(int btnState) {
        this.btnState = btnState;
    }

    public Dice(){
        this.point = 0;
    }

}
