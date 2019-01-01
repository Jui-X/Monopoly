package com.ooad.view;

import com.ooad.model.Piece;

import javax.swing.*;
import java.awt.*;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2018-12-18 19:29
 **/
public class GamePanel extends JPanel {

    private GameFrame gameFrame = null;
    private JLayeredPane layeredPane;

    //游戏背景
    private BoardView boardView = null;
    private PieceView pieceView = null;
    private DiceView diceView = null;
    private PlayerView playerView = null;

    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    public void setLayeredPane(JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
    }

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
//        this.boardView = new BoardView();
    }

}
