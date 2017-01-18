import javax.swing.*;
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

            ConditionToUrl conditionToUrl = new ConditionToUrl();
            conditionToUrl.setMode(false);
            conditionToUrl.setTitle(title);
            conditionToUrl.setYear(year);
            String url = conditionToUrl.conditionToUrl();

            JFrame resultFrame = new JFrame("Searching Result");
            ResultGUI resultGUI = new ResultGUI();
            System.out.println(url);
            try {
                resultGUI.init(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            resultFrame.setContentPane(resultGUI.getResultPanel());
            resultFrame.pack();
            resultFrame.setVisible(true);
            resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }


}
