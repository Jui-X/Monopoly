package com.ooad.model;

import com.ooad.controller.Monopoly;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2018-12-30 21:12
 **/
public class TextTip extends Tick implements Port {

    private Player player = null;

    private String tipString = "游戏开始！谁才是最后的大富翁呢？";

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getTipString() {
        return tipString;
    }

    public void setTipString(String tipString) {
        this.tipString = tipString;
    }

    public TextTip() {}

    /**
     * 显示文字提示
     * */
    public void showTextTip(Player player,String str, int time) {
        this.player = player;
        this.setTipString(str);
        this.setStartTick(this.nowTick);
        this.setNextTick(this.nowTick + time * Monopoly.rate);
    }

    @Override
    public void updateData(long tick) {this.nowTick = tick;}

    @Override
    public void startGameInit() {}
}
