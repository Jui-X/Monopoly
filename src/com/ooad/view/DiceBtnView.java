package com.ooad.view;

import com.ooad.controller.Monopoly;
import com.ooad.model.Dice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2018-12-30 21:03
 **/
public class DiceBtnView extends JPanel implements MouseListener {

    private Monopoly game;
    private Dice dice;

    private Image normalImage;
    private Image rolloverImage;
    private Image pressedImage;
    private Image currentImage;

    private boolean enabled = true;


    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public DiceBtnView(Monopoly game, int x, int y) {
        this.game = game;
        this.dice = game.getDice();
        this.normalImage = dice.getDiceIMG()[0].getImage();
        this.rolloverImage = dice.getDiceIMG()[1].getImage();
        this.pressedImage =dice.getDiceIMG()[2].getImage();
        this.currentImage = normalImage;
        this.setBounds(x, y, 50, 50);
        this.addMouseListener(this);
        repaint();
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
            // 按下
            game.pressButton();
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
