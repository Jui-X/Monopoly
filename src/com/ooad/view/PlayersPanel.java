package com.ooad.view;

import com.ooad.model.Player;

import java.awt.*;
import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-01-03 23:32
 **/
public class PlayersPanel extends Layer {

    private List<Player> players;

    protected PlayersPanel(int x, int y, int w, int h, List<Player> players) {
        super(x, y, w, h);
        this.players = players;
    }

    /**
     *
     * 玩家信息显示面板绘制
     *
     */
    public void paintPlayerInformation(Graphics g) {
        int tempX = 0;
        tempX += 30;
        for (Player temp : players) {
            // 玩家信息面板绘制
            paintPlayerPanel(temp, g, tempX, 15);
            tempX += 100;
        }
    }

    /**
     *
     * 玩家信息面板绘制
     *
     */
    private void paintPlayerPanel(Player player, Graphics g, int x,
                                  int y) {
        // 玩家信息字符串
        String[] information = { player.getName(),
                Integer.toString(player.getCash()) + " 金币"};

        g.drawImage(player.getIMG("mini_02"), x, y,
                x + player.getIMG("mini_02").getWidth(null) ,
                y + player.getIMG("mini_02").getHeight(null) ,
                0, 0, player.getIMG("mini_02").getWidth(null),
                player.getIMG("mini_02").getHeight(null), null);
        y += 60;
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font(null,0,14));
        // 信息重绘
        FontMetrics fm = g.getFontMetrics();
        for (int k = 0; k < information.length; g.drawString(information[k], x
                + (50 - fm.stringWidth(information[k])), y += 25), k++) ;

    }

    @Override
    public void paint(Graphics g) {
        this.createWindow(g);
        // 玩家信息显示面板重绘
        this.paintPlayerInformation(g);

    }

    @Override
    public void startPanel() { }

}
