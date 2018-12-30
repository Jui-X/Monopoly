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

    /**
     * 背景图片
     */
    private Image bg = null;

    /**
     * 背景模型
     */
    private Board board = null;
    private GamePanel panel;

    public BoardView(int x, int y, int w, int h,
                     Board board,GamePanel panel) {
        super(x, y, w, h);
        this.board = board;
        this.panel = panel;
    }

    /**
     * 将窗体隐藏
     */
    public void moveToBack() {
        this.panel.getLayeredPane().moveToBack(this);
    }

    /**
     * 将窗体显现
     */
    public void moveToFront() {
        this.panel.getLayeredPane().moveToFront(this);
    }

    /**
     * 背景绘制方法
     */
    public void paintBg(Graphics g){
        g.drawImage(this.bg, 0, 0, this.bg.getWidth(null),
                this.bg.getHeight(null), 0, 0, this.bg.getWidth(null),
                this.bg.getHeight(null), null);
    }

    @Override
    public void paint(Graphics g) {
        // 绘制背景
        this.paintBg(g);
    }

    @Override
    public void startPanel() {
        this.bg = board.getBg();
    }
}
