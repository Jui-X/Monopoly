package com.ooad.view;

import com.ooad.model.Piece;

import java.awt.*;

/**
 * @param: none
 * @description: 地皮UI
 * @author: KingJ
 * @create: 2018-12-19 20:49
 **/
public class PieceView extends Layer {

    /**
     *	土地模型
     **/
    private Piece piece;

    /**
     * 土地图片
     **/
    private Image pieceIMG;


    protected PieceView(int x, int y, int w, int h,Piece piece) {
        super(x, y, w, h);
        this.piece =piece;
        this.pieceIMG = this.piece.getPieceIMG();
    }

    /**
     * 土地绘制
     */
    private void paintLands(Graphics g) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < piece.getLand().length; i++) {
            for (int j = 0; j < piece.getLand()[i].length; j++) {
                if (piece.getLand()[i][j] != 0) {
                    // 图片部分显示
                    g.drawImage(pieceIMG, x + j * 60, y + i * 60, x
                                    + (j + 1) * 60, y + (i + 1) * 60,
                            (piece.getLand()[i][j] - 1) * 60, 0, piece.getLand()[i][j] * 60, 60, null);
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        // 土地绘制
        this.paintLands(g);
    }

    @Override
    public void startPanel() { }
}
