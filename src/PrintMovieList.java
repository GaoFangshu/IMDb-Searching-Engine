import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Fangshu Gao on 2017-01-31.
 */
public class PrintMovieList {


    public void printMovieList(String title, String year, int pagenum) {

        ConditionToUrl conditionToUrl = new ConditionToUrl();
        conditionToUrl.setMode(false);
        conditionToUrl.setTitle(title);
        conditionToUrl.setYear(year);
        conditionToUrl.setPage(pagenum);
        String url = conditionToUrl.conditionToUrl();

        JFrame resultFrame = new JFrame("Searching Result");

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        UrlToJson urlToJson = new UrlToJson();
        try {
            String[] jsonList = urlToJson.readURL(url);
            // print panel list of searching results
            for (int i=0; i<jsonList.length; i++) {
                try {
                    ResultGUI resultGUI = new ResultGUI();
                    resultGUI.init(jsonList, i);
                    listPanel.add(resultGUI.getResultPanel());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // add page button
            PageButton pagebutton = new PageButton();
            listPanel.add(pagebutton.getPagePanel());
        } catch (IOException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPanel = new JScrollPane(listPanel);
        scrollPanel.setPreferredSize(new Dimension(500, 750));

        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultFrame.setContentPane(scrollPanel);
        resultFrame.pack();
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setVisible(true);
    }
}
