package com.ooad.model;

import com.ooad.Context.GameState;
import com.ooad.model.Building.Building;
import com.ooad.model.Building.Go;
import com.ooad.model.Building.House;
import com.ooad.model.Building.Jail;

import java.util.ArrayList;
import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-01-01 19:30
 **/
public class Buildings extends Tick implements Port {

    /**
     * 房屋链表
     **/
    private List<Building> buildings = null;

    private Piece piece = null;

    public Buildings(Piece piece) {
        this.piece = piece;
    }

    /**
     *
     * 初始化房屋
     *
     */
    private void initBuilding() {
        // 初始化链表
        buildings = new ArrayList<Building>();
        // 对应地图加入房屋
        int[][] temp = this.piece.getLand();
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                switch (temp[i][j]) {
                    case GameState.SPACE:
                        Building tempBuidling = new House(i, j);
                        // 设置空地的属性为可以购买的
                        tempBuidling.setPurchasability(true);
                        buildings.add(tempBuidling);
                        break;
                    case GameState.ORIGIN:
                        buildings.add(new Go(i, j));
                        break;
                    case GameState.PRISON:// 监狱
                        buildings.add(new Jail(i, j));
                        //设置全图监狱点
                        Piece.prison = new java.awt.Point(j * 60, i * 60);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * 获得房屋表
     * @return:List<Building>
     */
    public List<Building> getBuilding(){
        return buildings;
    }
    /**
     * 获得当前位置房屋
     */
    public Building getBuilding(int x,int y){
        for (Building temp : buildings){
            if (temp.getPosX() == x && temp.getPosY() == y){
                return temp;
            }
        }
        return null;
    }

    /**
     * 开始游戏设置
     */
    public void startGameInit (){
        // 初始化房屋
        initBuilding();
    }

    @Override
    public void updateData(long tick) {
        this.nowTick = tick;
    }
}
