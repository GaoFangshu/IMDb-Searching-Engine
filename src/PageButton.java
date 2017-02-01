/**
 * Created by Fangshu Gao on 2017-01-31.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageButton {
    private JButton buttonNextPage;
    private JPanel pagePanel;
    private JButton buttonPreviousPage;
    private JLabel pageLabel;

    int pagenum;
    String title;
    String year;
    String type;

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void init(String type){  // TODO: get total pages: "CurrentPage/TotalPages"
        this.type = type;
        pageLabel.setText("  page: " + pagenum + "  ");
        setButtonNextPage();
        setButtonPreviousPagePage();
    }

    public JPanel getPagePanel() {
        return pagePanel;
    }

    public void setButtonNextPage() {
        buttonNextPage.addActionListener(new nextpageActionListener());
    }

    public class nextpageActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionevent) {
            pagenum++;
            PrintMovieList printMovieList = new PrintMovieList();
            printMovieList.printMovieList(title, year, type, pagenum);
        }
    }

    public void setButtonPreviousPagePage() {
        buttonPreviousPage.addActionListener(new previouspageActionListener());
    }

    public class previouspageActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionevent) {
            pagenum--;
            PrintMovieList printMovieList = new PrintMovieList();
            printMovieList.printMovieList(title, year, type, pagenum);
        }
    }
}
