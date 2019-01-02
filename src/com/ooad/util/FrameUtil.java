package com.ooad.util;

import javax.swing.*;
import java.awt.*;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-01-02 22:51
 **/
public class FrameUtil {

    /**
     *
     * frame面板居中
     *
     * @param jf
     */
    public static void setFrameCenter (JFrame jf) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();// 接数据对象
        int x = (screen.width - jf.getWidth()) / 2;
        int y = (screen.height - jf.getHeight()) / 2 - 32;
        jf.setLocation(x, y);
    }
}
