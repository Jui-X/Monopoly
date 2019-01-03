package com.ooad.config;

import javax.swing.*;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-01-02 22:49
 **/
public class Photo {
    /**
     *  玩家一选定图片
     */
    public static ImageIcon PLAYER_01_SELECTED = new ImageIcon("img/config/playerChoose/selected_01.png");

    /**
     *  玩家二选定图片
     */
    public static ImageIcon PLAYER_02_SELECTED = new ImageIcon("img/config/playerChoose/selected_02.png");

    /**
     *  左按钮
     */
    public static ImageIcon[] BUTTON_LEFT = {
            new ImageIcon("img/config/左按钮/normal.png"),
            new ImageIcon("img/config/左按钮/disabled.png"),
            new ImageIcon("img/config/左按钮/mouseOver.png"),
            new ImageIcon("img/config/左按钮/pressed.png")
    };

    /**
     *  右按钮
     */
    public static ImageIcon[] BUTTON_RIGHT = {
            new ImageIcon("img/config/右按钮/normal.png"),
            new ImageIcon("img/config/右按钮/disabled.png"),
            new ImageIcon("img/config/右按钮/mouseOver.png"),
            new ImageIcon("img/config/右按钮/pressed.png")
    };

    /**
     * 可选人物图片
     * */
    public static ImageIcon[] PLAYER_CHOOSE = {
            new ImageIcon("img/peasant.png"),
            new ImageIcon("img/landlord.png"),
            new ImageIcon("img/princess.png"),
            new ImageIcon("img/ninja.png")
    };
}
