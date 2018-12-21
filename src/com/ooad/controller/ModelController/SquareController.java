package com.ooad.controller.ModelController;

import com.ooad.model.Piece;
import com.ooad.model.Square;

import java.util.List;

/**
 * @param: none
 * @description: 方块Controller
 * @author: KingJ
 * @create: 2018-12-19 20:55
 **/
public class SquareController {

    private Square square;
    private List<Piece> pieceList = null;

    public SquareController(Square square){
        this.square = square;

    }
}
