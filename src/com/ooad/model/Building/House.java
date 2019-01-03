package com.ooad.model.Building;

import com.ooad.Context.GameState;
import com.ooad.model.Piece;

/**
 * @param: none
 * @description: 房屋Model
 * @author: KingJ
 * @create: 2018-12-19 20:44
 **/
public class House extends Building{

    public House(int posX, int posY){
        super(posX, posY);
        this.price = 1000;
        this.revenue = (int) (this.price * 0.1);
        this.level = 0;
    }

    @Override
    public int getEvent() {
        return GameState.HOUSE_EVENT;
    }
}
