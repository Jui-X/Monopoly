package com.ooad.controller.ModelController;

import com.ooad.Context.GameState;
import com.ooad.model.Building.Hotel;
import com.ooad.model.Building.House;
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

    public PlayerController(Player player, House house, Hotel hotel){
        this.player = player;
        this.house = house;
        this.hotel = hotel;
    }

    public int rollDice(){
        int step = 0;
        if(player.getState() == GameState.NOMARL){
            // 判断两次掷色点数是否相同，若相同增加额外回合
            if (dice1.getPoint()==dice2.getPoint()){
                // 若第三回合点数与前两回合也相同，则直接进监狱
                if (otherDice.getPoint() == dice1.getPoint()){
                    step = 0;
                    this.putIntoJail(otherDice.getPoint());
                }
                // 否则总步数等于三次掷色之和
                else {
                    step = dice1.getPoint() + dice2.getPoint() + otherDice.getPoint();
                }
            }
            // 不同则总步数等于两次掷色之和
            else {
                step = dice1.getPoint() + dice2.getPoint();
            }
        }
        // 如果玩家仍是入狱状态且在狱中天数尚未清零
        else if(player.getState() == GameState.IN_JAIL && player.getInJail() >= 1){
            // 在监狱中掷出相同点数方可出狱
            if (dice1.getPoint() == dice2.getPoint()){
                player.setState(GameState.NOMARL);
                step = dice1.getPoint() + dice2.getPoint();
            }
            else {
                player.setInJail(player.getInJail() - 1);
                // 玩家在监狱中待到第三回合仍未掷出相同点数，需要支付罚金然后按刚才掷出点数移动
                if (player.getInJail() == 0){
                    this.payFine();
                    step = dice1.getPoint() + dice2.getPoint();
                }
                else {
                    step = 0;
                }
            }
        }
        return step;
    }

    public void goPass(int reward){
        // 经过起点奖励
        player.setCash(player.getCash() + reward);
    }

    public boolean purchasePiece(){
        if (player.getCash() >= piece.getPrice() ) {
            // 玩家现金减少，减少数量对应相应的地皮价格
            player.setCash(player.getCash() - piece.getPrice());
            // 玩家地产增加
            player.getPieces().add(piece);
            return true;
        }
        else {return false;}
    }

    public boolean buildHouse(){
        if (player.getCash() >= house.getPrice()) {
            // 玩家现金减少，减少数量对应相应的房屋价格
            player.setCash(player.getCash() - house.getPrice());
            // 玩家房产增加
            player.getHouses().add(house);
            return true;
        }
        else {return false;}
    }

    public boolean buildHotel(){
        if (player.getCash() >= hotel.getPrice()) {
            // 玩家现金减少，减少数量对应相应的旅馆价格
            player.setCash(player.getCash() - hotel.getPrice());
            // 玩家房产增加
            player.getHotels().add(hotel);
            return true;
        }
        else {return false;}
    }

    public void putIntoJail(int diceValue){
        // 将玩家状态设置为入狱
        player.setState(GameState.IN_JAIL);
        // 玩家入狱天数初始化为3天
        player.setInJail(3);
    }

    public boolean payFine(){
        if (player.getCash() >= GameState.FINE){
            // 缴纳罚金
            player.setCash(player.getCash() - GameState.FINE);
            player.setState(GameState.NOMARL);
            return true;
        }
        else {return false;}
    }

    public void collectRent(int rent){
        // 收过路费
        player.setCash(player.getCash() + rent);
    }

    public boolean payRent(int rent){
        if (player.getCash() >= rent){
            // 交过路费
            player.setCash(player.getCash() - rent);
            return true;
        }
        else {return false;}
    }

    public boolean payDeal(int price){
        if (player.getCash() >= price) {
            player.setCash(player.getCash() - price);
            this.payTax((int) (price * 0.1));
            return true;
        }
        else {return false;}
    }

    public void sellPiece(){
        // 将地皮抵押，获得半数现金
        int cash = (int) (player.getCash() + piece.getPrice() * 0.5);
        player.setCash(cash);
    }

    public boolean redeemPiece(){
        if (player.getCash() >= piece.getPrice()) {
            // 花费半数现金赎回地皮
            int cash = (int) (player.getCash() - piece.getPrice() * 0.5);
            player.setCash(cash);
            this.payTax((int) (piece.getPrice() * 0.1));
            return true;
        }
        else {return false;}
    }

    public void payTax(int tax){
        // 付抵押值10%的交易税
        player.setCash(player.getCash() - tax);
    }

    public void sellHouse(){
        // 卖房，获得半数现金
        int cash = (int) (player.getCash() + house.getPrice() * 0.5);
        player.setCash(cash);
    }

    public void sellHotel(){
        // 卖旅馆，获得半数现金
        int cash = (int) (player.getCash() + hotel.getPrice() * 0.5);
        player.setCash(cash);
    }

    public int houseValue(){
        // 计算玩家当前所有房产总价
        int totalValue = 0;
        for(House h : player.getHouses()) {
            totalValue += (h.getPrice() * 0.5);
        }
        return totalValue;
    }

    public int hotelValue(){
        // 计算玩家当前所有旅馆总价
        int totalValue = 0;
        for(Hotel h : player.getHotels()) {
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
            player.setState(GameState.BANKRUPTCY);
            return false;
        }
        else {return true; }
    }

    // 拍卖竞价
    public int bidding(int bidding){
        return bidding;

    }

}
