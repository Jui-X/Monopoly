package com.ooad.view;

import com.ooad.model.Building.Building;
import com.ooad.model.Buildings;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-01-01 19:23
 **/
public class BuildingsView extends Layer {

    /**
     * 加载房屋信息
     */
    private Buildings buildingsInfo;

    /**
     * 房屋链表
     */
    private List<Building> building;

    /**
     * house 图片 1-5级别
     *
     */
    private Image HOUSE_01 = new ImageIcon("img/building/house01.png").getImage();
    /**
     * house 图片 1-5级别
     *
     */
    private Image HOUSE_02 = new ImageIcon("img/building/house02.png").getImage();
    /**
     * 伪透明图片
     *
     */
    public Image TRANSPARENT = new ImageIcon("img/building/transparent.png").getImage();


    protected BuildingsView(int x, int y, int w, int h, Buildings buildingsInfo) {
        super(x, y, w, h);
        this.buildingsInfo = buildingsInfo;
    }

    /**
     *
     * 绘制建筑物
     *
     */
    private void paintBuildings(Graphics g) {
        for(Building temp : this.building){
            // 房屋绘制
            paintBuilding(temp, g);
        }
    }

    private void paintBuilding(Building building, Graphics g) {
        int x = 0;
        int y = 0;
        if (building.getOwner() != null) {
            int level = building.getLevel();
            int i = building.getPosX();
            int j = building.getPosY();
            Image temp = building.getOwner().getNumber() == 1 ? this.HOUSE_01
                    : this.HOUSE_02;
            if (level > 0) {
                g.drawImage(temp, x + j * 60,
                        y + i * 60 - (temp.getHeight(null) - 60), x + (j + 1)
                                * 60, y + (i + 1) * 60, 60 * (level - 1), 0,
                        60 * level, temp.getHeight(null), null);
            }
            // 透明覆盖白条
            g.drawImage(this.TRANSPARENT, x + j * 60, y + i * 60, x + (j + 1)
                    * 60, y + (i + 1) * 60, 0, 0, 60, 60, null);
            // 土地拥有者名字显示
            g.drawString("" + building.getOwner().getName(), x + j * 60 + 4, y + i
                    * 60 + 14);
        }
    }

    @Override
    public void paint(Graphics g) {
        // 绘制建筑物
        paintBuildings(g);
    }

    @Override
    public void startPanel() {
        this.building = this.buildingsInfo.getBuilding();
    }

}
