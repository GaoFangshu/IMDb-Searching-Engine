import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
    private JTextPane titleTPanel;
    private JTextPane yearTPanel;
    private JTextPane imdbidTPanel;
    private JTextPane typeTPanel;

    public void init(String[] jsonList, int i) throws IOException {

        //UrlToJson urlToJson = new UrlToJson();
        //String[] jsonList = urlToJson.readURL(url);

        SetJTPanel setJTPanel = new SetJTPanel();
        setJTPanel.setJTPanel(titleTPanel, jsonList[i], "Title");
        setJTPanel.setJTPanel(yearTPanel, jsonList[i], "Year");
        setJTPanel.setJTPanel(imdbidTPanel, jsonList[i], "imdbID");
        setJTPanel.setJTPanel(typeTPanel, jsonList[i], "Type");

        JsonToMap jsonToMap = new JsonToMap();
        setPosterLabel(jsonToMap.getValue(jsonToMap.transfer(jsonList[i]), "Poster"));

        setButtonDetails(jsonList[i]);
    }

    public JPanel getResultPanel() {
        //resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
        return resultPanel;
    }

    public void setJTPanel(JTextPane jTextPane, String var) {
        jTextPane.setText(var);
    }

    public void setPosterLabel(String var) throws IOException {
        URL url = new URL(var);
        BufferedImage image = ImageIO.read(url);
        BufferedImage imageResized = resizeImage(image, 150);
        this.posterLabel.setIcon(new ImageIcon(imageResized));
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
                detialsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                detialsFrame.setContentPane(detialsGUI.getDetailsPanel());
                detialsFrame.pack();
                detialsFrame.setLocationRelativeTo(null);
                detialsFrame.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }

    public BufferedImage resizeImage(BufferedImage inputImage, double width) {
        double width0 = inputImage.getWidth();
        double height0 = inputImage.getHeight();
        int height = (int)((width/width0)*height0);
        BufferedImage outputImage = new BufferedImage((int)width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = outputImage.createGraphics();
        g.drawImage(inputImage, 0, 0, (int)width, height, null);
        g.dispose();
        return outputImage;
    }



}
