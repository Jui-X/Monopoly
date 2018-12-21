package com.ooad.model.Buildings;

import com.ooad.model.Piece;

/**
 * @param: none
 * @description: 旅馆Model
 * @author: KingJ
 * @create: 2018-12-19 20:47
 **/
public class Hotel extends Building{

    public Hotel(Piece piece){
        this.price = 15000;
        this.piece = piece;
    }
}
