import javax.swing.*;

/**
 * Created by Fangshu Gao on 2017-01-18.
 */
public class SetJTPanel {
    public void setJTPanel(JTextPane jTextPane, String jsonVar, String var) {
        JsonToMap jsonToMap = new JsonToMap();
        jTextPane.setText(jsonToMap.getValue(jsonToMap.transfer(jsonVar), var));
    }
}
