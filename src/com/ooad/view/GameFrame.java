package com.ooad.view;

import com.ooad.util.FrameUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @param: none
 * @description: 游戏界面
 * @author: KingJ
 * @create: 2018-12-18 19:16
 **/
public class GameFrame extends JFrame {

    private GamePanel gamePanel = null;

    public GameFrame(){

        //设置标题Monopoly
        this.setTitle("Monopoly");

        //获取屏幕宽度与高度
//        Toolkit kit = Toolkit.getDefaultToolkit();
//        Dimension screenSize = kit.getScreenSize();
//        int screenHeight = screenSize.height;
//        int screenWidth = screenSize.width;
//        System.out.println(screenHeight);
//        System.out.println(screenWidth);

        this.setSize(1280, 853);
        // 居中
        FrameUtil.setFrameCenter(this);

        //设置窗口大小不可变
        this.setResizable(false);

        //去掉窗口所有装饰
        this.setUndecorated(false);

        //设置logo
        Image img = new ImageIcon("img/monopoly.png").getImage();
        this.setIconImage(img);

        //将Panel加入Frame
        this.gamePanel = new GamePanel();
        this.add(this.gamePanel);

        //设置窗口退出状态
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public GamePanel getPanelGame() { return gamePanel;}
}
