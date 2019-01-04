package com.ooad.model.Building;

import com.ooad.Context.GameState;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-01-04 10:51
 **/
public class Point extends Building {

    private int point;


    public Point(int posX, int posY, int point) {
        super(posX, posY);
        this.name = point + "点卷位";
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public int getEvent() {
        return GameState.POINT_EVENT;
    }
}
