package com.ooad.view;

import com.ooad.controller.Monopoly;
import com.ooad.main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-01-03 22:43
 **/
public class PlayerInfoBtn extends JPanel implements MouseListener {

    private Image[] img = {
            new ImageIcon("img/end/button/normal.png").getImage(),
            new ImageIcon("img/end/button/mouseOver.png").getImage(),
            new ImageIcon("img/end/button/pressed.png").getImage()
    };

    private Image normalImage;
    private Image rolloverImage;
    private Image pressedImage;
    private Image currentImage;

    private boolean enabled = true;

    private String name = null;

    private Monopoly game;

    public PlayerInfoBtn(String name, int x, int y) {
        this.name = name;//设置名称
        this.normalImage = this.img[0];
        this.rolloverImage = this.img[1];
        this.pressedImage =this.img[2];
        this.currentImage = normalImage;
        this.setBounds(x, y, this.img[0].getWidth(null), this.img[0].getHeight(null));
        this.addMouseListener(this);
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void paint(Graphics g) {
        this.setOpaque(false); // 背景透明
        if (enabled){
            g.drawImage(currentImage, this.getX(), this.getY(), this.getWidth(),
                    this.getHeight(), this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        currentImage = pressedImage;
        if(enabled){
            System.exit(0);
            Main.main(null);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        currentImage = rolloverImage;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        currentImage = rolloverImage;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        currentImage = normalImage;
    }
}
