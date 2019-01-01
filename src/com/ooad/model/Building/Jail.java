package com.ooad.model.Building;

import com.ooad.Context.GameState;
import com.ooad.model.Player;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-01-01 19:38
 **/
public class Jail extends Building {

    private String[] events = { "去监狱看望好友，", "被冤枉入狱，", "被监狱管理员抓去打扫卫生，" };

    private Player player;

    public Jail(int posX, int posY) {
        super(posX, posY);
        this.name = "监狱";
    }

    public String[] getEvents() {
        return events;
    }

    @Override
    public int getEvent() {
        return GameState.PRISON_EVENT;
    }
}
