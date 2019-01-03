package com.ooad.util;

import com.ooad.controller.GameController;
import com.ooad.controller.Monopoly;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-01-02 18:54
 **/
public class MyThread  implements Runnable{

    private Monopoly game;

    int times;

    int time;

    public MyThread (Monopoly game, int times) {
        this.game = game;
        this.times = times;
    }
    @Override
    public void run() {
        while (true) {
            if (time >= times){
                game.nextState();
                break;
            }
            time++;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void start() {
        this.run();
    }

}
