package com.ooad.view;

import com.ooad.controller.Monopoly;

import javax.swing.*;
import java.awt.*;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-01-02 20:44
 **/
public class RunningView extends Layer{

    private Image bg = new ImageIcon("img/days/bg.png").getImage();
    private Image[] numberIMG = {
            new ImageIcon("img/days/0.png").getImage(),
            new ImageIcon("img/days/1.png").getImage(),
            new ImageIcon("img/days/2.png").getImage(),
            new ImageIcon("img/days/3.png").getImage(),
            new ImageIcon("img/days/4.png").getImage(),
            new ImageIcon("img/days/5.png").getImage(),
            new ImageIcon("img/days/6.png").getImage(),
            new ImageIcon("img/days/7.png").getImage(),
            new ImageIcon("img/days/8.png").getImage(),
            new ImageIcon("img/days/9.png").getImage()
    };
    private Image bgDay = new ImageIcon("images/string/days/bg_day.png").getImage();
    private Image[] numberR = {
            new ImageIcon("img/days/r/0.png").getImage(),
            new ImageIcon("img/days/r/1.png").getImage(),
            new ImageIcon("img/days/r/2.png").getImage(),
            new ImageIcon("img/days/r/3.png").getImage(),
            new ImageIcon("img/days/r/4.png").getImage(),
            new ImageIcon("img/days/r/5.png").getImage(),
            new ImageIcon("img/days/r/6.png").getImage(),
            new ImageIcon("img/days/r/7.png").getImage(),
            new ImageIcon("img/days/r/8.png").getImage(),
            new ImageIcon("img/days/r/9.png").getImage()
    };
    private Image rule = new ImageIcon("images/string/days/rule.png").getImage();

    private Monopoly game = null;
    private GamePanel panel;

    protected RunningView(int x, int y, int w, int h,Monopoly game,GamePanel panel) {
        super(x, y, w, h);
        this.game = game;
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

    @Override
    public void paint(Graphics g) {
        // 显示游戏天数
        g.drawImage(bg, 0, 0, bg.getWidth(null), bg.getHeight(null), 0, 0, bg.getWidth(null), bg.getHeight(null), null);
        // 显示数字
        int day = game.getDay();
        int posX = 100;
        int posY = 16;
        while ((int)day > 0){
            int num = day % 10;
            g.drawImage(numberIMG[num], posX,posY,posX + numberIMG[num].getWidth(null),posY + numberIMG[num].getHeight(null),0,0,numberIMG[num].getWidth(null),numberIMG[num].getHeight(null),null);
            day /= 10;
            posX -= 26;
        }
        if (Monopoly.GAME_DAY > 0 ) {
            posY += 14;
            posX = 100;
            g.drawImage(bgDay, 0, posY, bgDay.getWidth(null),posY + bgDay.getHeight(null), 0, 0, bgDay.getWidth(null), bgDay.getHeight(null), null);
            int day_m = Monopoly.GAME_DAY ;
            posY += 16;
            while ((int)day_m >0){
                int num = day_m % 10;
                g.drawImage(numberR[num], posX,posY,posX + numberR[num].getWidth(null),posY + numberR[num].getHeight(null),0,0,numberR[num].getWidth(null),numberIMG[num].getHeight(null),null);
                day_m /= 10;
                posX -= 26;
            }
        }
    }

    @Override
    public void startPanel() {

    }

}
