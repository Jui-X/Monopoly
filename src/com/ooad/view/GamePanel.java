package com.ooad.view;

import javax.swing.*;
import java.awt.*;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2018-12-18 19:29
 **/
public class GamePanel extends JPanel {

    //游戏背景
    private BoardView boardView = null;
    private SquareView squareView = null;
    private DiceView diceView = null;
    private PlayerView playerView = null;

    public GamePanel(){
        //采用BorderLayout布局
        setLayout(new BorderLayout());
        initGame();
    }

    public void initGame(){
        initUI();
    }

    public void initUI(){

        // 实例化背景
        this.boardView = new BoardView();
        // 实例化方格
        this.squareView = new SquareView();
    }

}
