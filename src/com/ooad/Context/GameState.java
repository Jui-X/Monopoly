package com.ooad.Context;

/**
 * @param: none
 * @description: 常量
 * @author: KingJ
 * @create: 2018-12-22 20:51
 **/
public class GameState {

    public static final int MAX_HOUSENUM = 4;

    public static final int MAX_HOTELNUM = 1;

    public static final int ORANGE_PIECE = 1;

    public static final int PURPLE_PIECE = 2;

    /**
     * 地皮的三种状态
     * OWNERLESS： 未售出的
     * SOLD： 已售出的
     * PLEDGED： 已抵押的
     */
    public static final int OWNERLESS = 0;
    public static final int SOLD = 1;
    public static final int PLEDGED = 2;

    /**
     *
     * 正常状态：0
     * 进入监狱状态：1
     * 破产：2
     *
     */
    public static final int NOMARL = 0;
    public static final int IN_JAIL = 1;
    public static final int BANKRUPTCY = 2;

    /*
     * 最大房屋数量
     */
    public static final int MAX_HOUSE = 32;

    /*
     * 最大旅馆数量
     */
    public static final int MAX_HOTEL = 12;

    /*
     * 最大旅馆数量
     */
    public static final int FINE = 50;

}
