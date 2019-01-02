package com.ooad.model;

import com.ooad.Context.GameState;
import com.ooad.controller.Monopoly;

import javax.swing.*;
import java.awt.*;

/**
 * @param: none
 * @description: 骰子Model
 * @author: KingJ
 * @create: 2018-12-19 20:12
 **/
public class Dice extends Tick implements Port {

    /**
     *
     * 骰子运动
     *
     **/
    private Image[] img = new Image[] {
            new ImageIcon("img/dice/dice_play_01.png").getImage(),
            new ImageIcon("img/dice/dice_play_02.png").getImage(),
            new ImageIcon("img/dice/dice_play_03.png").getImage(),
            new ImageIcon("img/dice/dice_play_04.png").getImage(),
            new ImageIcon("img/dice/dice_play_05.png").getImage() };
    /**
     *
     * 骰子点数图像
     *
     **/
    private Image[] dicePoints = new Image[] {
            new ImageIcon("img/dice/point/1.png").getImage(),
            new ImageIcon("img/dice/point/2.png").getImage(),
            new ImageIcon("img/dice/point/3.png").getImage(),
            new ImageIcon("img/dice/point/4.png").getImage(),
            new ImageIcon("img/dice/point/5.png").getImage(),
            new ImageIcon("img/dice/point/6.png").getImage() };

    /**
     * 骰子按钮图片
     **/
    public  ImageIcon[] diceIMG = new ImageIcon[] {
            new ImageIcon("img/dicebtn/dice.png"),
            new ImageIcon("img/dicebtn/diceEnter.png"),
            new ImageIcon("img/dicebtn/dicePress.png"),
            new ImageIcon("img/dicebtn/diceBan.png")
    };

    /**
     * 点数
     **/
    private int point = 0;

    /**
     * 骰子状态
     **/
    private int diceState = 0;

    /**
     * 按钮状态
     **/
    private boolean btnState;

    /**
     * 图片滚动次数记载（用于图片的滚动显示）
     **/
    private int imgCount;

    private Monopoly game;



    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Image[] getImg() {
        return img;
    }

    public void setImg(Image[] img) {
        this.img = img;
    }

    public Image[] getDicePoints() {
        return dicePoints;
    }

    public void setDicePoints(Image[] dicePoints) {
        this.dicePoints = dicePoints;
    }

    public ImageIcon[] getDiceIMG() {
        return diceIMG;
    }

    public void setDiceIMG(ImageIcon[] diceIMG) {
        this.diceIMG = diceIMG;
    }

    public int getDiceState() {
        return diceState;
    }

    public void setDiceState(int diceState) {
        this.diceState = diceState;
    }

    public boolean isBtnState() {
        return btnState;
    }

    public void setBtnState(boolean btnState) {
        this.btnState = btnState;
    }

    public int getImgCount() {
        return imgCount;
    }

    public void setImgCount(int imgCount) {
        this.imgCount = imgCount;
    }

    public Monopoly getGame() {
        return game;
    }

    public void setGame(Monopoly game) {
        this.game = game;
    }


    public Dice(Monopoly game){
        this.game = game;
    }

    public Image getNowImg(){
        this.imgCount = this.imgCount % this.img.length;
        return this.img[this.imgCount];
    }

    /**
     * 确认按钮状态
     **/
    private void checkButton() {
        if (this.game.getNowPlayerState() == GameState.STATE_THROWDICE) {// "掷点状态"
            this.btnState = true;
        } else {
            this.btnState = false;
        }
    }

    public void addImgCount(int add) {
        this.imgCount+=add;
    }

    @Override
    public void updateData(long tick) {
        this.nowTick = tick;
        // 确认按钮状态
        this.checkButton();
    }

    @Override
    public void startGameInit() {

        // 初始化骰子状态为“产生点数状态”
        this.diceState = GameState.DICE_STOP;
        // 初始化按钮可以点击
        this.btnState = true;
        // 骰子运动持续时间设定
        this.lastTime = Monopoly.rate * 1;
    }
}
