/**
 * Created by Fangshu Gao on 2017-01-15.
 */

public class ConditionToUrl {
    private boolean mode; // 1:By ID or Title; 0:By Search
    private String id = "";
    private String title = ""; // Parameter is different between "By ID/Title" and "By Search"
    private String type = "";
    private String year = "";
    private int page; // Default value is 1.
    private String plot = "full"; // Always full.

    public void setMode(boolean mode) {
        this.mode = mode;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title.replace(" ", "+");
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String conditionToUrl() {
        String url = new String();

        if (mode == true) { // By ID or Title

            if (!title.equals("")) {
                url = "http://www.omdbapi.com/?" + "t=" + title +
                        "&" + "y=" + year +
                        "&" + "plot=" + plot + // full
                        "&" + "r=json";
                System.out.println(url);
                return url;
            } else if (!id.equals("")){
                url = "http://www.omdbapi.com/?" + "i=" + id +
                        "&" + "y=" + year +
                        "&" + "plot=" + plot + // full
                        "&" + "r=json";
                System.out.println(url);
                return url;
            } else {
                System.out.println("Please enter title or IMDb ID of the movie.");
                return url;
            }

        } else { // By Search

            if (!title.equals("")) {
                url = "http://www.omdbapi.com/?" + "s=" + title +
                        "&" + "y=" + year +
                        "&" + "plot=" + plot + //full
                        "&" + "page=" + page +
                        "&" + "type=" + type +
                        "&" + "r=json";
                System.out.println(url);
                return url;
            } else {
                System.out.println("Please enter title of the movie.");
                return url;
            }

        }
    }
}
