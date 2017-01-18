import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Fangshu Gao on 2017-01-17.
 */
public class ResultGUI {
    private JPanel resultPanel;
    private JLabel titleLabel;
    private JLabel yearLabel;
    private JLabel imdbidLabel;
    private JLabel typeLabel;
    private JLabel posterLabel;
    private JTextArea titleTArea;
    private JTextArea yearTArea;
    private JTextArea imdbidTArea;
    private JTextArea typeTArea;
    private JButton buttonDetails;

    public void init(String url) throws IOException {

        UrlToJson urlToJson = new UrlToJson();
        String[] jsonList = urlToJson.readURL(url);

        SetJTArea setJTArea = new SetJTArea();
        setJTArea.setJTArea(titleTArea, jsonList[0], "Title");
        setJTArea.setJTArea(yearTArea, jsonList[0], "Year");
        setJTArea.setJTArea(imdbidTArea, jsonList[0], "imdbID");
        setJTArea.setJTArea(typeTArea, jsonList[0], "Type");

        JsonToMap jsonToMap = new JsonToMap();
        setPosterLabel(jsonToMap.getValue(jsonToMap.transfer(jsonList[0]), "Poster"));

        setButtonDetails(jsonList[0]);
    }

    public JPanel getResultPanel() {
        return resultPanel;
    }

    public void setJTArea(JTextArea jTextArea, String var) {
        jTextArea.setText(var);
    }

    public void setPosterLabel(String var) throws IOException {
        URL url = new URL(var);
        BufferedImage image = ImageIO.read(url);
        this.posterLabel.setIcon(new ImageIcon(image));
    }

    public void setButtonDetails(String json) {
        buttonDetails.addActionListener(new DetailsActionListener(json));
    }

    public class DetailsActionListener implements ActionListener {
        private String json; // Reference:
                            //   http://stackoverflow.com/questions/11037622/pass-variables-to-actionlistener-in-java
                            //   http://stackoverflow.com/questions/2488006/how-can-i-give-a-variable-to-an-action-listener
        public DetailsActionListener(String json) {
            this.json = json;
        }
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            JsonToMap jsonToMap = new JsonToMap();
            String id = jsonToMap.getValue(jsonToMap.transfer(json), "imdbID");

            ConditionToUrl conditionToUrl = new ConditionToUrl();
            conditionToUrl.setMode(true);
            conditionToUrl.setId(id);

            UrlToJson urlToJson = new UrlToJson();
            try {
                String detailsJson = urlToJson.readURL(conditionToUrl.conditionToUrl())[0];
                JFrame detialsFrame = new JFrame("Details");
                DetailsGUI detialsGUI = new DetailsGUI();
                detialsGUI.init(detailsJson);
                detialsFrame.setContentPane(detialsGUI.getDetailsPanel());
                detialsFrame.pack();
                detialsFrame.setVisible(true);
                detialsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }



}
