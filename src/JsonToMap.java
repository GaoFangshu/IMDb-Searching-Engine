/**
 * Created by Fangshu Gao on 2017-01-15.
 */

import org.json.JSONObject;

public class JsonToMap {
    private JSONObject obj;

    public JSONObject transfer(String urlpage) {
        this.obj = new JSONObject(urlpage);
        //System.out.println(obj.get("Search")); //John
        return obj;
    }

    public String getValue(JSONObject obj, String var) {
        return String.valueOf(obj.get(var));
    }

}
