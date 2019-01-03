package com.ooad.Context;

/**
 * @param: none
 * @description: 常量
 * @author: KingJ
 * @create: 2018-12-22 20:51
 **/
public class GameState {

    /**
     * 一块地皮上最大房屋数量
     **/
    public static final int MAX_HOUSENUM = 4;

    /**
     * 一块地皮上最大旅馆数量
     **/
    public static final int MAX_HOTELNUM = 1;

    public static final int ORANGE_PIECE = 1;

    public static final int PURPLE_PIECE = 2;

    /**
     * 地皮的三种状态
     * OWNERLESS： 未售出的
     * SOLD： 已售出的
     * PLEDGED： 已抵押的
     **/
    public static final int OWNERLESS = 0;
    public static final int SOLD = 1;
    public static final int PLEDGED = 2;

    /**
     *
     * 正常状态：0
     * 进入监狱状态：1
     * 破产：2
     *
     **/
    public static final int NOMARL = 0;
    public static final int IN_JAIL = 1;
    public static final int BANKRUPTCY = 2;

    /**
     * 最大房屋数量
     **/
    public static final int MAX_HOUSE = 32;

    /**
     * 最大旅馆数量
     **/
    public static final int MAX_HOTEL = 12;

    /**
     * 最大旅馆数量
     **/
    public static final int FINE = 50;

    /**
     * 骰子运行状态
     **/
    public static final int DICE_RUNNING = 1;

    /**
     * 骰子停止状态
     **/
    public static final int DICE_STOP = 2;

    /**
     * 玩家掷点状态
     **/
    public static int STATE_THROWDICE = 1;

    /**
     * 玩家移动状态
     */
    public static int STATE_MOVE = 2;

    /**
     * 游戏终止状态
     */
    public static int GAME_STOP = 3;

    /**
     * 玩家初始金钱
     */
    public static int PLAYER_ORIGIN_CASH = 15000;

    /**
     * 无建筑
     */
    public final static int NULL_SET = 0;

    /**
     * 空地
     */
    public final static int SPACE = 1;

    /**
     * 起点
     */
    public final static int ORIGIN = 10;

    /**
     * 监狱
     */
    public final static int PRISON = 11;

    /**
     * 停留在建筑返回状态
     */
    public  final static int HOUSE_EVENT = 1;


    public  final static int ORIGIN_EVENT = 2;


    public  final static int PRISON_EVENT = 3;

    /**
     * 路过建筑返回状态
     */

    public final static int ORIGIN_PASS_EVENT = 1;


}
