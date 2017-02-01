/**
 * Created by Fangshu Gao on 2017-01-15.
 */

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        JFrame mainFrame = new JFrame("IMDb");
        GUI gui = new GUI();
        gui.init();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setContentPane(gui.getMainPanel());
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
