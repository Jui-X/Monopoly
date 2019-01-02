package com.ooad.model.Building;

import com.ooad.model.Piece;

/**
 * @param: none
 * @description: 旅馆Model
 * @author: KingJ
 * @create: 2018-12-19 20:47
 **/
public class Hotel extends Building{

    public Hotel(int posX, int posY){
        super(posX, posY);
        this.price = 1500;
        this.revenue = (int) (this.price * 0.2);
    }
}
