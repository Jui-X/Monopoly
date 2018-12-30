package com.ooad.view;

import com.ooad.controller.Monopoly;
import com.ooad.model.Player;

import java.awt.*;
import java.util.List;

/**
 * @param: none
 * @description: 玩家UI
 * @author: KingJ
 * @create: 2018-12-19 20:50
 **/
public class PlayerView extends Layer {

    private Monopoly game = null;
    private List<Player> players = null;

    public PlayerView(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public PlayerView(int x, int y, int w, int h, Monopoly game, List<Player> players) {
        super(x, y, w, h);
        this.game = game;
        this.players = players;
    }

    /**
     *
     * 绘制单个玩家
     *
     */
    private void paintPlayer(Player player, Graphics g) {
        // 判断是否为当前玩家
        boolean show = true;
        Image temp = player.getIMG("mini");
        if (player.equals(this.game.getNowPlayer())) {
            temp = player.getIMG("mini_on");
        } else {
            if (this.x == player.getOtherPlayer().getX()
                    && this.y == player.getOtherPlayer().getY()) {
                // 重合不显示
                show = false;
            }
        }
        if (show)
            g.drawImage(temp, player.getX() + 28, player.getY() + 28, player.getX() + 60,
                    player.getY() + 60, 0, 0, 32, 32, null);
    }

    @Override
    public void startPanel() { }

    @Override
    public void paint(Graphics g) {
        // 绘制玩家在地图中情况
        for (Player player : players) {
            paintPlayer(player, g);
        }
    }
}
