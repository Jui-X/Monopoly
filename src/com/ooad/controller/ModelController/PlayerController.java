package com.ooad.controller.ModelController;

import com.ooad.model.Buildings.Hotel;
import com.ooad.model.Buildings.House;
import com.ooad.model.Dice;
import com.ooad.model.Piece;
import com.ooad.model.Player;


/**
 * @param: none
 * @description: 玩家Controller
 * @author: KingJ
 * @create: 2018-12-19 20:53
 **/
public class PlayerController {

    /**
     *
     * 正常状态：0
     * 进入监狱状态：1
     * 破产：2
     *
     */
    private static final int NOMARL = 0;
    private static final int IN_JAIL = 1;
    private static final int BANKRUPCY = 2;

    private Player player;
    private Dice dice1;
    private Dice dice2;
    private Dice otherDice;
    private Piece piece;
    private House house;
    private Hotel hotel;

    public PlayerController(Player player){
        this.player = player;
    }

    public PlayerController(Player player, Dice dice1, Dice dice2, Dice otherDice){
        this.player = player;
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.otherDice = otherDice;
    }

    public PlayerController(Player player, Piece piece){
        this.player = player;
        this.piece = piece;
    }

    public PlayerController(Player player, House house){
        this.player = player;
        this.house = house;
    }

    public PlayerController(Player player, Hotel hotel){
        this.player = player;
        this.hotel = hotel;
    }

    public int rollDice(){
        int step;
        // 判断两次掷色点数是否相同，若相同增加额外回合
        if (dice1.getPoint()==dice2.getPoint()){
            // 若第三回合点数与前两回合也相同，则直接进监狱
            if (otherDice.getPoint() == dice1.getPoint()){
                step = 0;
                this.putIntoJail();
                return step;
            }
            // 否则总步数等于三次掷色之和
            else {
                step = dice1.getPoint() + dice2.getPoint() + otherDice.getPoint();
                return step;
            }
        }
        // 不同则总步数等于两次掷色之和
        else {
            step = dice1.getPoint() + dice2.getPoint();
            return step;
        }
    }

    public void goPass(int reward){
        // 经过起点奖励
        player.setCash(player.getCash() + reward);
    }

    public boolean purchasePiece(){
        // 玩家现金减少，减少数量对应相应的地皮价格
        player.setCash(player.getCash() - piece.getPrice());
        // 玩家地产增加
        player.getPieces().add(piece);
        return true;
    }

    public void buildHouse(){
        // 玩家现金减少，减少数量对应相应的房屋价格
        player.setCash(player.getCash() - house.getPrice());
        // 玩家房产增加
        player.getHouses().add(house);
    }

    public void buildHotel(){
        // 玩家现金减少，减少数量对应相应的旅馆价格
        player.setCash(player.getCash() - hotel.getPrice());
        // 玩家房产增加
        player.getHotels().add(hotel);
    }

    public void putIntoJail(){
        // 将玩家状态设置为入狱
        player.setState(IN_JAIL);
        // 玩家入狱天数初始化为3天
        player.setInJail(3);
    }

    public void collectRent(int rent){
        // 收过路费
        player.setCash(player.getCash() + rent);
    }

    public void payRent(int rent){
        // 交过路费
        player.setCash(player.getCash() - rent);
    }

    public void cashOutPiece(){
        // 将地皮抵押，获得半数现金
        int cash = (int) (player.getCash() + piece.getPrice() * 0.5);
        player.setCash(cash);
    }

    public void redeemPiece(){
        // 花费半数现金赎回地皮
        int cash = (int) (player.getCash() - piece.getPrice() * 0.5);
        player.setCash(cash);
    }

    public void cashOutHouse(){
        // 卖房，获得半数现金
        int cash = (int) (player.getCash() + house.getPrice() * 0.5);
        player.setCash(cash);
    }

    public void cashOutHotel(){
        // 卖旅馆，获得半数现金
        int cash = (int) (player.getCash() + hotel.getPrice() * 0.5);
        player.setCash(cash);
    }

    public int houseValue(){
        // 计算玩家当前所有房产总价
        int totalValue = 0;
        for(House h : player.getHouses()){
            totalValue += (h.getPrice() * 0.5);
        }
        return totalValue;
    }

    public int hotelValue(){
        // 计算玩家当前所有旅馆总价
        int totalValue = 0;
        for(Hotel h : player.getHotels()){
            totalValue += (h.getPrice() * 0.5);
        }
        return totalValue;
    }

    public int getAssets(){
        // 计算玩家当前总资产
        int assets = player.getCash() + houseValue() + hotelValue();
        return assets;
    }

    public boolean bankrupt(){
        // 若玩家总资产小于等于0，则宣布破产
        if (getAssets() <= 0){
            return true;
        }
        return false;
    }

    // 拍卖竞价
    public int bidding(int bidding){
        return bidding;
    }

}
