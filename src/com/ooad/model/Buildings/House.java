package com.ooad.model.Buildings;

import com.ooad.model.Piece;

/**
 * @param: none
 * @description: 房屋Model
 * @author: KingJ
 * @create: 2018-12-19 20:44
 **/
public class House extends Building{

    public House(Piece piece){
        this.price = 500;
        this.piece = piece;
    }
}
