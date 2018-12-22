package com.ooad.view;

import com.ooad.model.Board;

import javax.swing.*;
import java.awt.*;

/**
 * @param: none
 * @description: 面板UI
 * @author: KingJ
 * @create: 2018-12-19 20:11
 **/
public class BoardView extends Layer{

    private Board board = null;
    private JPanel panel;

    public BoardView(int x, int y, int w, int h,
                     Board board,GamePanel panel) {
        super(x, y, w, h);
        this.board = board;
        this.panel = panel;
    }

    @Override
    public void paint(Graphics g){

    }

    @Override
    public void startPanel(){

    }
}
