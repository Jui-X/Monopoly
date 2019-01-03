package com.ooad.view;

import com.ooad.Context.GameState;
import com.ooad.controller.Monopoly;
import com.ooad.model.Dice;

import java.awt.*;

/**
 * @param: none
 * @description: 骰子UI
 * @author: KingJ
 * @create: 2018-12-19 20:49
 **/
public class DiceView extends Layer {

    private Monopoly game;
    private Dice dice;
    private DiceBtnView diceBtn;

    protected DiceView(int x, int y, int w, int h, Monopoly game) {
        super(x, y, w, h);
        setLayout(null);
        this.game = game;
        this.dice = game.getDice();
        this.diceBtn = new DiceBtnView(game, 105, 32);
        add(diceBtn);
    }

    /**
     *
     * 骰子绘制
     *
     */
    private void paintDice(Graphics g, int i, int j) {
        // 设置骰子运动
        if (dice.getStartTick() < dice.getNowTick()
                && dice.getNextTick() >= dice.getNowTick()) {
            dice.setDiceState(GameState.DICE_RUNNING);
        } else {
            dice.setDiceState(GameState.DICE_STOP);
        }

        if (dice.getDiceState() == GameState.DICE_STOP) {
            this.paintPoint(g, i, j);
        } else if (dice.getDiceState() == GameState.DICE_RUNNING) {
            this.paintRunning(g, i, j, dice.getNowTick() % 4 == 0);
        }
        g.setColor(Color.black);
        g.drawString(dice.getGame().getNowPlayer().getName() + ":", i + 120,
                j + 45);
    }

    /**
     *
     * 骰子运动状态绘制
     *
     */
    public void paintRunning(Graphics g, int x, int y, boolean change) {
        if (change) {
            dice.addImgCount(1);
        }
        Image temp = dice.getNowImg();
        g.drawImage(temp, x, y, x + temp.getWidth(null),
                y + temp.getHeight(null), 0, 0, temp.getWidth(null),
                temp.getHeight(null), null);
    }

    /**
     *
     * 骰子产生点数绘制
     *
     */
    public void paintPoint(Graphics g, int x, int y) {
        Image temp = dice.getDicePoints()[dice.getPoint()];
        g.drawImage(temp, x, y, x + temp.getWidth(null),
                y + temp.getHeight(null), 0, 0, temp.getWidth(null),
                temp.getHeight(null), null);
    }

    /**
     *
     * 骰子按钮显示
     *
     */
    private void showDice() {
        this.diceBtn.setEnabled(dice.isBtnState());
    }

    @Override
    public void paint(Graphics g) {
        //窗口绘制
        this.createWindow(g);
        //骰子绘制
        this.paintDice(g, -12, -15);
        //骰子按钮显示
        this.showDice();
        // 骰子按钮刷新
        this.diceBtn.update(g);
    }

    @Override
    public void startPanel() {
    }
}
