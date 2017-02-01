/**
 * Created by Fangshu Gao on 2017-01-31.
 */

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PrintMovieList {


    public void printMovieList(String title, String year, String type, int pagenum) {

        ConditionToUrl conditionToUrl = new ConditionToUrl();
        conditionToUrl.setMode(false);
        conditionToUrl.setTitle(title);
        conditionToUrl.setYear(year);
        conditionToUrl.setPage(pagenum);
        conditionToUrl.setType(type);
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
            pagebutton.setPagenum(pagenum);
            pagebutton.setTitle(title);
            pagebutton.setYear(year);
            pagebutton.init(type);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPanel = new JScrollPane(listPanel);

        scrollPanel.setPreferredSize(new Dimension(500, 750));


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                scrollPanel.getVerticalScrollBar().setValue(0);
            }
        });  // Reference: http://stackoverflow.com/questions/41974427/how-to-let-scrollbars-default-position-be-at-top

        resultFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // TODO: Automatically close current JFrame when click page button
        resultFrame.setContentPane(scrollPanel);
        resultFrame.pack();
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setVisible(true);
    }
}
