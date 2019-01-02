import com.ooad.view.GameFrame;
import com.ooad.view.StartFrame;
import com.ooad.view.config.Config;

import javax.swing.*;

public class Main {

    static {
        // 设置样式
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e1) {

        }
    }

    public static void main(String[] args) {
	// write your code here
        GameFrame frame = new GameFrame();
        StartFrame startFrame = new StartFrame();
        new Config(startFrame, frame);
    }
}
