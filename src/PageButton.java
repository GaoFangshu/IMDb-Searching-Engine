import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Fangshu Gao on 2017-01-31.
 */
public class PageButton {
    private JButton buttonNextPage;
    private JPanel pagePanel;
    private JButton buttonPreviousPage;
    private JLabel pageLabel;

    public void init(int pageNow, int pageAll, int pagenum){
        pageLabel.setText("  " + pageNow + " / " + pageAll + "  ");
        setButtonNextPage();
    }

    public JPanel getPagePanel() {
        return pagePanel;
    }

    public void setButtonNextPage() {
        buttonNextPage.addActionListener(new nextpageActionListener());
    }

    public class nextpageActionListener implements ActionListener {

        @override
        public void actionPerformed(ActionEvent actionevent) {
            PrintMovieList printMovieList = new PrintMovieList();
            printMovieList.printMovieList(title, year, pagenum);
        }
    }
}
