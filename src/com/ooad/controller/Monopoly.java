package com.ooad.controller;

import com.ooad.Context.GameState;
import com.ooad.model.*;
import com.ooad.model.Building.Building;
import com.ooad.model.Building.Go;
import com.ooad.model.Building.Jail;
import com.ooad.util.MyThread;
import com.ooad.view.GamePanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
    private MoveCotroller moveCotroller;

    private List<Port> models = new ArrayList<Port>();
    private List<Player> players = null;
    private Board board = null;
    private Piece piece = null;
    private Dice dice1 = null;
    private Dice dice2 = null;
    private Dice dice3 = null;
    private TextTip textTip = null;
    private Buildings buildings = null;
    private Bank bank = null;

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


    public void setPanel(GamePanel panel) {
        this.panel = panel;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Piece getPiece() {
        return piece;
    }

    public TextTip getTextTip() {
        return textTip;
    }

    public Buildings getBuildings() {
        return buildings;
    }

    public Dice getDice() {
        return dice1;
    }

    public void setDice(Dice dice) {
        this.dice1 = dice;
    }

    public Dice getDice2() {
        return dice2;
    }

    public void setDice2(Dice dice2) {
        this.dice2 = dice2;
    }

    public Dice getDice3() {
        return dice3;
    }

    public void setDice3(Dice dice3) {
        this.dice3 = dice3;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
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

    public static int getDay() {
        return day;
    }

    public Monopoly() {
        this.running = new GameController(this, nowPlayer, bank);
        this.initGame();
        // 向游戏状态中加入玩家模型
        this.setPlayers(players);
    }

    /**
     *
     * 初始化游戏对象
     *
     */
    private void initGame() {
        // 创建新的背景模型
        this.board = new Board();
        this.models.add(board);
        // 创建新的土地模型
        this.piece = new Piece();
        this.models.add(piece);
        // 创建新的文本显示模型
        this.textTip = new TextTip();
        this.models.add(textTip);
        // 创建一个新的建筑模型
        this.buildings = new Buildings(piece);
        this.models.add(buildings);
        // 创建一个新的玩家数组
        this.players = new ArrayList<Player>();
        this.players.add(new Player(this, 1));
        this.players.add(new Player(this, 2));
        this.models.add(players.get(0));
        this.models.add(players.get(1));
        // 创建一个新的骰子模型
        this.dice1 = new Dice(this);
//        this.dice2 = new Dice(this);
//        this.dice3 = new Dice(this);
        this.models.add(dice1);
//        this.models.add(dice2);
//        this.models.add(dice3);
        //
        this.bank = new Bank();
        this.models.add(bank);

    }

    /**
     *
     * 控制器启动
     *
     */
    public void start() {
        // 创建一个计时器
        this.createGameTimer();
        // 刷新对象初始数据
        for (Port temp : this.models) {
            temp.startGameInit();
        }
        // 游戏环境开始
        this.startGameInit();
        // panel 初始化
        this.panel.startGamePanelInit();
    }

    /**
     *
     * 开始游戏设置
     *
     */
    public void startGameInit() {
        // 设定当前游戏玩家
        this.nowPlayer = this.players.get(0);
    }

    /**
     *
     * 游戏计时器
     *
     */
    private void createGameTimer() {
        this.gameTimer = new Timer();
        this.gameTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                tick++;
                // 更新各对象
                for (Port temp : models) {
                    temp.updateData(tick);
                }
                // UI更新
                panel.repaint();
            }
        }, 0, (1000 / rate));
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
            this.dice1.setStartTick(Monopoly.tick);
            // 设置骰子对象结束转动时间
            this.dice1.setNextTick(this.dice1.getStartTick()
                    + this.dice1.getLastTime());
            // 将运行对象点数传入骰子对象
            this.dice1.setPoint(this.getPoint());
            // 转换状态至“移动状态”
            this.nextState();
            // 骰子转动完毕后玩家移动
            this.getNowPlayer().setStartTick(this.dice1.getNextTick() + 10);
            this.getNowPlayer().setNextTick(
                    this.getNowPlayer().getStartTick()
                            + this.getNowPlayer().getLastTime()
                            * (this.getPoint() + 1));
        }
    }

    /**
     *
     * 玩家移动
     *
     */
    public void movePlayer() {
        // 人物运动
        for (int i = 0; i < (60 / this.getNowPlayer().getLastTime()); i++) {
            moveCotroller = new MoveCotroller(nowPlayer);
            // 移动玩家
            moveCotroller.moveOn();
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
        Building building = buildings.getBuilding(nowPlayer.getY() / 60,
                nowPlayer.getX() / 60);
        if (building != null && nowPlayer.getX() % 60 == 0
                && nowPlayer.getY() % 60 == 0) {
            // 经过房屋发生事件
            int event = building.passEvent();
            // 进入经过房屋事件处理
            disposePassEvent(building, event, nowPlayer);
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
        running.goPass(b);
    }

    /**
     *
     * 玩家移动完毕，停下判断
     *
     */
    public void palyerStop() {
        // 当前玩家
        Player nowPlayer = this.getNowPlayer();
        if (nowPlayer.getInJail() > 0) {
            this.textTip.showTextTip(nowPlayer, nowPlayer.getName() + "当前在监狱,不能移动.",
                    2);
            // 更换玩家状态
            this.nextState();
        } else {
            // 进行玩家操作（买房 事件等）
            running.landOn();
        }
    }

    /**
     *
     *
     * 停留在可操作土地
     *
     *
     */
    public void stopInHouse(Building building, Player player) {
        if (building.isPurchasability()) {// 玩家房屋
            if (building.getOwner() == null) { // 无人房屋
                Piece nowPiece = building.getPiece();
                int price = nowPiece.getPrice();
                int choose = JOptionPane.showConfirmDialog(
                        null,
                        "亲爱的:" + player.getName() + "\r\n" + "是否购买下这块地？\r\n"
                                + "\r\n" + "价格：" + price + " 金币.");
                if (choose == JOptionPane.OK_OPTION) {
                    // 执行买地操作
                    running.purchasePiece(nowPiece);
                    this.textTip.showTextTip(player, player.getName()
                            + " 买下了一块空地.花费了: " + price + "金币. ", 3);
                } else {
                    this.textTip.showTextTip(player, player.getName()
                            + " 金币不足,操作失败. ", 3);
                }
            } else {// 有人房屋
                if (building.getOwner().equals(player)) {// 自己房屋
                    int price = building.getPrice();
                    int choose = JOptionPane.showConfirmDialog(null,
                            "亲爱的:" + player.getName() + "\r\n" + "是否升级这块地？\r\n" + "价格：" + price + " 金币.");
                    if (choose == JOptionPane.OK_OPTION) {
                        // 执行升级房屋操作
                        running.buildHouse(building, bank);
                        this.textTip.showTextTip(player, player.getName() + ".花费了 " + price
                                + "金币. ", 3);
                    } else {
                        // 增加文本提示
                        this.textTip.showTextTip(player, player.getName()
                                + " 金币不足,操作失败. ", 3);
                    }
                } else {// 别人房屋
                    int revenue = building.getRevenue();
                    // 执行交税操作
                    running.payRent(building, player);
                    this.textTip.showTextTip(player, player.getName() + "经过"
                            + building.getOwner().getName() + "的地盘，过路费:" + revenue + "金币.", 3);
                }
            }
        }
    }

    /**
     *
     * 停留在原点
     *
     */
    public void stopInOrigin(Building b, Player player) {
        this.textTip.showTextTip(player, player.getName() + " 在起点停留，奖励 "
                + ((Go) b).getReward() + "金币.", 3);
        player.setCash(player.getCash() + ((Go) b).getReward());
        new Thread(new MyThread(this, 1)).start();
    }

    /**
     *
     * 停留在监狱
     *
     */
    public void stopInPrison(Building b, Player player) {
        int days = (int) (Math.random() * 3) + 2;
        player.setInJail(days);
        int random = (int) (Math.random() * ((Jail) b).getEvents().length);
        String text = ((Jail) b).getEvents()[random];
        this.textTip.showTextTip(player, player.getName() + text + "停留"
                + (days - 1) + "天.", 3);
    }

    /**
     *
     * 游戏结束~
     *
     * @param:winer
     */
    public void gameOver () {
        this.setNowPlayerState(GameState.GAME_STOP);
        this.panel.getBoardView().moveToFront();
        this.panel.getRunning().moveToFront();

    }

}
