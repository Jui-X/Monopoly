package com.ooad.controller;

import com.ooad.Context.GameState;
import com.ooad.model.*;
import com.ooad.model.Building.Building;
import com.ooad.model.Building.Go;
import com.ooad.view.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * @param: none
 * @description: 游戏Controller
 * @author: KingJ
 * @create: 2018-12-19 20:54
 **/
public class Monopoly {

    /**
     *
     * 游戏tick值
     *
     */
    public static long tick;
    /**
     *
     * 每秒画面刷新频率
     *
     */
    public static int rate = 30;
    /**
     * 游戏主面板
     */
    private GamePanel panel;

    /**
     * 游戏对象
     */
    private GameController running;

    private List<Port> models = new ArrayList<Port>();
    private List<Player> players = null;
    private Board board = null;
    private Piece piece = null;
    private Dice dice = null;
    private TextTip textTip = null;
    private Buildings buildings;
    private static Bank bank;

    /**
     * 骰子当前点数
     */
    private int point;
    /**
     * 游戏计时器
     */
    private Timer gameTimer = null;

    /**
     * 当前操作玩家
     */
    private Player nowPlayer = null;

    /**
     * 玩家目前状态
     */
    private int nowPlayerState;

    /**
     * 游戏进行天数
     */
    public static int day = 1;

    /**
     * 游戏上限天数 - 1为无上限
     */
    public static int GAME_DAY = -1;

    /**
     * 游戏金钱上线（即胜利条件）-1为无上限
     */
    public static int MONEY_MAX = -1;


    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public Player getNowPlayer() {
        return nowPlayer;
    }

    public void setNowPlayer(Player nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public int getNowPlayerState() {
        return nowPlayerState;
    }

    public void setNowPlayerState(int nowPlayerState) {
        this.nowPlayerState = nowPlayerState;
    }

    public Monopoly() {
        this.running = new GameController(nowPlayer, bank);
//        this.initGame();
    }

    /**
     *
     * 按下骰子
     *
     */
    public void pressButton() {
        Player player = this.getNowPlayer();
        if (player.getInJail() > 0) {
            this.nextState();
            if (player.getInJail() > 0) {
                this.textTip.showTextTip(player, player.getName() + "在监狱.", 3);
            }
            this.nextState();
        } else {
            // 设置骰子对象开始转动时间
            this.dice.setStartTick(Monopoly.tick);
            // 设置骰子对象结束转动时间
            this.dice.setNextTick(this.dice.getStartTick()
                    + this.dice.getLastTime());
            // 将运行对象点数传入骰子对象
            this.dice.setPoint(this.getPoint());
            // 转换状态至“移动状态”
            this.nextState();
            // 骰子转动完毕后玩家移动
            this.getNowPlayer().setStartTick(this.dice.getNextTick() + 10);
            this.getNowPlayer().setNextTick(
                    this.getNowPlayer().getStartTick()
                            + this.getNowPlayer().getLastTime()
                            * (this.getPoint() + 1));
        }
    }

    /**
     *
     * 判断游戏是否结束
     *
     */
    public boolean gameContinue() {
        Player p1 = this.nowPlayer;
        Player p2 = this.nowPlayer.getOtherPlayer();
        // 天数
        if (GAME_DAY > 0 && day >= GAME_DAY) {
            this.gameOver();
            return false;
        }
        // 最大金钱
        if (MONEY_MAX > 0 && p1.getCash() >= MONEY_MAX) {
            this.gameOver();
            return false;
        } else if (MONEY_MAX > 0 && p2.getCash() >= MONEY_MAX) {
            this.gameOver();
            return false;
        }
        // 破产
        if (p1.getCash() < 0) {
            this.gameOver();
            return false;
        } else if (p2.getCash() < 0) {
            this.gameOver();
            return false;
        }
        return true;
    }

    /**
     *
     * 转换玩家状态
     *
     */
    public void nextState() {
        // 判断游戏是否得出结果
        if (gameContinue()) {
            if (this.nowPlayerState == GameState.STATE_THROWDICE) {
                // 移动状态
                this.nowPlayerState = GameState.STATE_MOVE;
            } else if (this.nowPlayerState == GameState.STATE_MOVE) {
                this.nextPlayer();
                // 产生一个点数
                this.setPoint((int) (Math.random() * 6));
            }
        }
    }

    /**
     * 换人操作
     */
    private void nextPlayer() {
        // 减少时间
        if (this.nowPlayer.getInJail() > 0) {
            this.nowPlayer.setInJail(this.nowPlayer.getInJail() - 1);
        }
        // 换人
        if (this.nowPlayer.equals(this.players.get(0))) {
            this.nowPlayer = this.players.get(1);
        } else {
            this.nowPlayer = this.players.get(0);
            // 结束后游戏天数增加
            day++;
        }
    }

    /**
     * 玩家中途路过建筑
     */
    public void prassBuilding() {
        // 该地点房屋
        Building building = buildings.getBuilding(player.getY() / 60,
                player.getX() / 60);
        if (building != null && player.getX() % 60 == 0
                && player.getY() % 60 == 0) {
            // 经过房屋发生事件
            int event = building.passEvent();
            // 进入经过房屋事件处理
            disposePassEvent(building, event, player);
        }
    }

    /**
     * 经过房屋事件处理
     */
    private void disposePassEvent(Building b, int event, Player player) {
        switch (event) {
            case GameState.ORIGIN_PASS_EVENT:
                // 中途经过原点
                passOrigin(b, player);
                break;
            default:
                break;
        }
    }

    /**
     * 中途经过原点
     */
    private void passOrigin(Building b, Player player) {
        this.textTip.showTextTip(player, player.getName() + " 路过原点，奖励 "
                + ((Go) b).getPassReward() + "金币.", 3);
        player.setCash(player.getCash() + ((Go) b).getPassReward());
    }

    /**
     *
     * 游戏结束~
     *
     * @param:winer
     */
    public void gameOver () {
        this.setNowPlayerState(GameState.GAME_STOP);
//        this.panel.getBackgroundUI().moveToFront();
//        this.panel.getRunning().moveToFront();
//        this.panel.getPlayerInfo().moveToFront();
//        this.panel.getEffect().moveToFront();
//        this.effect.showImg("timeover2");

    }

}
