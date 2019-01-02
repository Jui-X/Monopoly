package com.ooad.view;

import com.ooad.model.TextTip;

import javax.swing.*;
import java.awt.*;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-01-02 19:46
 **/
public class TextTipView extends Layer {

    private TextTip textTip = null;
    private Image bg = new ImageIcon("images/window/tip_01.png").getImage();

    private Point pointWindow = null;

    public TextTipView(int x, int y, int w, int h, TextTip textTip) {
        super(x, y, w, h);
        this.pointWindow = new Point((x + w) / 2, (y + h) / 2);
        this.textTip = textTip;

    }

    /**
     *
     * 绘制信息面板
     *
     */
    private void paintTextTip(Graphics g, TextTipView textTip2) {
        if (textTip.getStartTick() < textTip.getNowTick()
                && textTip.getNextTick() >= textTip.getNowTick()) {
            this.pointWindow.x = textTip.getPlayer().getX() + 45;
            this.pointWindow.y =textTip.getPlayer().getY() + 10;
            g.drawImage(bg, pointWindow.x, pointWindow.y, pointWindow.x + bg.getWidth(null),
                    pointWindow.y + bg.getHeight(null), 0, 0, bg.getWidth(null),
                    bg.getHeight(null), null);
            // 绘制文字
            drawSting(g);
        }

    }

    /**
     *
     * 绘制文字
     *
     */
    private void drawSting(Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        String str = this.textTip.getTipString();
        int maxSize = 13;
        int posY = 32;
        int front = 0;
        int rear = maxSize;
        while (front < str.length() - 1) {
            if (rear >= str.length()) {
                rear = str.length() - 1;
            }
            char[] temp = new char[maxSize];
            str.getChars(front, rear, temp, 0);
            // Char[] 转换成string
            String s = new String(temp);
            g.drawString(s, pointWindow.x + 20, pointWindow.y + posY);
            front = rear;
            rear += maxSize;
            posY += 20;
        }
    }

    @Override
    public void paint(Graphics g) {
        // 绘制信息面板
        paintTextTip(g, this);
    }

    @Override
    public void startPanel() { }
}
