package com.ooad.controller;

import com.ooad.model.Dice;
import com.ooad.model.Player;

import java.util.List;

/**
 * @param: none
 * @description: 骰子Controller
 * @author: KingJ
 * @create: 2018-12-19 20:52
 **/
public class DiceController {

    private Dice dice;

    private int faceValue = 0;

    public DiceController(Dice dice){
        this.dice = dice;
    }

    public int getFaceValue(){
        faceValue = (int) Math.random() * 6;
        return faceValue;
    }

    public void roll(){
        dice.setPoint(getFaceValue());
    }

}
