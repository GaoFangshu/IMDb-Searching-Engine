import javax.swing.*;

/**
 * Created by Fangshu Gao on 2017-01-15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        JFrame mainFrame = new JFrame("IMDb");
        GUI gui = new GUI();
        gui.init();
        mainFrame.setContentPane(gui.getMainPanel());
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);






        /*
        String website = new String("http://www.omdbapi.com/?t=the+walking+dead&plot=full");

        UrlToJson url = new UrlToJson();
        String page = url.readURL(website);
        System.out.println(page);

        JsonToMap json = new JsonToMap();
        json.transfer(page);
        */
    }
}
