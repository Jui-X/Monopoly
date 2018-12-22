package com.ooad.controller.ModelController;

import com.ooad.model.Board;
import com.ooad.model.Piece;
import com.ooad.model.Square;

import java.util.List;

/**
 * @param: none
 * @description: 面板Controller
 * @author: KingJ
 * @create: 2018-12-19 20:54
 **/
public class BoardController {

    private Board board;
    private List<Square> squareList = null;

    public BoardController(Board board){
        this.board = board;
        // 初始化所有方格
        for (int i = 0; i < board.getSquareNum(); i++){
            this.squareList.add(new Square());
        }
    }


}
