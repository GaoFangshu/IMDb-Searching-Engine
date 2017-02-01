/**
 * Created by Fangshu Gao on 2017-01-15.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private String title;  //t=
    private String year;  //y=
    private String plot;  //plot=full
    private String reponse;  //r=json
    private String type; //type=

    private JLabel mainTitle;
    private JLabel titleLabel;
    private JTextField titleTextField;
    private JLabel typeLabel;
    private JComboBox typeBox;
    private JLabel yearLabel;
    private JTextField yearTextField;
    private JButton buttonSearch;
    private JPanel mainPanel;
    private JPanel resultPanel;

    int pagenum=1;

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public void init() {
        setButtonSearch();
        setTypeBox();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setType(String type) {
        this.type = type;
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
            printMovieList.printMovieList(title, year, type, pagenum);
        }
    }

    public void setTypeBox() {
        typeBox.addActionListener(new typeActionListener());
    }

    public class typeActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JComboBox typeBox = (JComboBox) actionEvent.getSource();
            Object selected = typeBox.getSelectedItem();

            if (selected.toString().equals("Movie")) {
                setType("movie");
            } else if (selected.toString().equals("Series")) {
                setType("series");
            } else if (selected.toString().equals("Episode")) {
                setType("episode");
            } else {
                setType("");
            }
        }
    }


}
