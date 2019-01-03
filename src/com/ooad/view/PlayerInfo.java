package com.ooad.view;

import com.ooad.controller.Monopoly;
import com.ooad.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-01-03 22:43
 **/
public class PlayerInfo extends JPanel {

    private Image bg = new ImageIcon("img/end/bg.png").getImage();
    private Image str = new ImageIcon("img/end/str.png").getImage();
    private Image none = new ImageIcon("img/end/none.png").getImage();
    private Image win = new ImageIcon("img/end/win.png").getImage();
    private Image lose = new ImageIcon("img/end/lose.png").getImage();
    private Image[] numberIMG = {
            new ImageIcon("img/end/number/0.png").getImage(),
            new ImageIcon("img/end/number/1.png").getImage(),
            new ImageIcon("img/end/number/2.png").getImage(),
            new ImageIcon("img/end/number/3.png").getImage(),
            new ImageIcon("img/end/number/4.png").getImage(),
            new ImageIcon("img/end/number/5.png").getImage(),
            new ImageIcon("img/end/number/6.png").getImage(),
            new ImageIcon("img/end/number/7.png").getImage(),
            new ImageIcon("img/end/number/8.png").getImage(),
            new ImageIcon("img/end/number/9.png").getImage()
    };

    private PlayerInfoBtn button;

    private int x, y, w, h;

    private Point origin = new Point();

    private java.util.List<Player> players;
    private GamePanel panel;

    public PlayerInfo(List<Player> players, GamePanel panel) {
        this.players = players;
        this.panel = panel;
        setLayout(null);
        initBounds();
        button = new PlayerInfoBtn("", 200 - 58, 430);
        add(button);
        addListener();
    }

    private void initBounds() {
        this.x = (1280 - bg.getWidth(null)) / 2;
        this.y = (853 - bg.getHeight(null)) / 2;
        this.w = bg.getWidth(null);
        this.h = bg.getHeight(null);
        setBounds(x, y, w, h);
    }

    /**
     *
     * 将窗体隐藏
     *
     */
    public void moveToBack() {
        this.panel.getLayeredPane().moveToBack(this);
    }

    /**
     *
     * 将窗体显现
     *
     */
    public void moveToFront() {
        this.panel.getLayeredPane().moveToFront(this);
    }

    public void paint(Graphics g) {
        this.setOpaque(false); // 背景透明
        g.drawImage(bg, 0, 0, w, h, this);
        drawPlayers(g);
        button.update(g);
    }

    private void drawPlayers(Graphics g) {
        int y = 92;
        for (Player a : players) {
            drawPlayer(g,a,y);
            y += 180;
        }
        String str = "";
        if (Monopoly.day >= Monopoly.GAME_DAY) {
            str ="达到游戏天数 "+ Monopoly.day +" 天.";
        }
        //最大金钱
        Player p1 = players.get(0);
        Player p2 = players.get(1);
        if (Monopoly.MONEY_MAX > 0 && p1.getCash() >= Monopoly.MONEY_MAX) {
            str ="\"" + p1.getName() +"\" 金钱达到游戏金钱上限.";
        } else if (Monopoly.MONEY_MAX > 0 && p2.getCash() >= Monopoly.MONEY_MAX) {
            str ="\"" + p2.getName() +"\" 金钱达到游戏金钱上限.";
        }
        // 破产
        if (p1.getCash() <= 0 ){
            str ="\"" + p1.getName() +"\"破产.";
        } else if (p2.getCash() <= 0 ){
            str ="\"" + p2.getName() +"\"破产.";
        }
        FontMetrics fm = g.getFontMetrics();
        g.drawString("结束原因："+str, 200 - fm.stringWidth(str)/2, 86);
    }

    private void drawPlayer(Graphics g, Player player,int y) {
        Image h5 = (player.getCash() > player.getOtherPlayer().getCash())? player.getIMG("smile"):player.getIMG("sad");
        Image out = (player.getCash() > player.getOtherPlayer().getCash())? win:lose;
        g.drawImage(str, 44 + 130, y + 40, 44 + 130 + str.getWidth(null), y + 40 + str.getHeight(null), 0, 0, str.getWidth(null), str.getHeight(null), null);
        g.drawImage(h5, 44, y + 40 - 14, 44 + h5.getWidth(null), y + 40 - 14 + h5.getHeight(null), 0, 0, h5.getWidth(null), h5.getHeight(null), null);
        g.setFont(new Font(null,1,16));
        int posX = 44 + 130 + str.getWidth(null) + 10;
        int posY =  y + 40 + 16;
        g.drawString(player.getName(), posX,posY);
        int cash = player.getCash();
        int cPosX = posX + 70;
        int cPosY = posY + 14;
        if (cash <= 0 ){
            cPosX-=70;
            g.drawImage(none, cPosX, cPosY, cPosX +none.getWidth(null), cPosY + none.getHeight(null), 0,0,none.getWidth(null), none.getHeight(null),null);
        }
        while ((int )cash > 0){
            int num = cash % 10;
            g.drawImage(numberIMG[num], cPosX,cPosY,cPosX + numberIMG[num].getWidth(null),cPosY + numberIMG[num].getHeight(null),0,0,numberIMG[num].getWidth(null),numberIMG[num].getHeight(null),null);
            cash /= 10;
            cPosX -= 16;
        }
        g.drawImage(out, 44 + 130 + 187, y + 40 - 28, 44 + 130 + 187 + out.getWidth(null), y + 40 - 28 + out.getHeight(null), 0, 0, out.getWidth(null), out.getHeight(null), null);

    }

    private void addListener() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) { // 按下
                origin.x = e.getX(); // 当鼠标按下的时候获得窗口当前的位置
                origin.y = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) { // 拖动
                x += e.getX() - origin.x;
                y += e.getY() - origin.y;
                if (x < 0) {
                    x = 0;
                }
                if (x + w > 950) {
                    x = 950 - w;
                }
                if (y < 0) {
                    y = 0;
                }
                if (y + h > 650) {
                    y = 650 - h;
                }
                setBounds(x, y, w, h);
            }
        });
    }
}
