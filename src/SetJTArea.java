import javax.swing.*;

/**
 * Created by Fangshu Gao on 2017-01-18.
 */
public class SetJTArea {
    public void setJTArea(JTextArea jTextArea, String jsonVar, String var) {
        JsonToMap jsonToMap = new JsonToMap();
        jTextArea.setText(jsonToMap.getValue(jsonToMap.transfer(jsonVar), var));
    }
}
