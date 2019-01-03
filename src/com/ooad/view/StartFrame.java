package com.ooad.view;

import javax.swing.*;

/**
 * @param: none
 * @description: 开始界面
 * @author: KingJ
 * @create: 2018-12-19 21:00
 **/
public class StartFrame extends JFrame {


    public StartFrame(){

        this.setTitle("Monopoly");

        this.setSize(600, 480);

        this.setLocationByPlatform(true);

        this.setUndecorated(true);

        add(new JLabel("游戏初始化中，请稍后", JLabel.CENTER));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
