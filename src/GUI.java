import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Fangshu Gao on 2017-01-15.
 */
public class GUI {
    private String title;  //t=
    private String year;  //y=
    private String plot;  //plot=full
    private String reponse;  //r=json


    private JLabel mainTitle;
    private JLabel titleLabel;
    private JTextField titleTextField;
    private JLabel typeLabel;
    private JComboBox typeBox1;
    private JLabel yearLabel;
    private JTextField yearTextField;
    private JButton buttonSearch;
    private JPanel mainPanel;
    private JPanel resultPanel;

    int pagenum = 1;

    public void init() {
        setButtonSearch();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setButtonSearch() {
        buttonSearch.addActionListener(new buttonActionListener());
    }

    public class buttonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String title = titleTextField.getText();
            String year = yearTextField.getText();



            PrintMovieList printMovieList = new PrintMovieList();
            printMovieList.printMovieList(title, year, pagenum);



        }
    }


}
