/**
 * Created by Fangshu Gao on 2017-01-15.
 */
import org.json.JSONObject;

import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class UrlToJson {

    public static String[] readURL(String website) throws IOException {
        URL url = new URL(website);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream())
        );
        String inputline;
        if ((inputline = in.readLine()) != null) {
            in.close();

            JSONObject jsonObject = new JSONObject(inputline);  // Check whether `inputline` contains more than one movie.
            if (jsonObject.has("Search")) {
                String searchString = String.valueOf(jsonObject.get("Search"));  // Value of key "Search".
                String searchMark = searchString.replace("{", "%#{");  // Mark the location of each "{".
                String moviesString = searchMark.substring(3, searchMark.length()-1);
                String[] movies = moviesString.split(",%#");  // String[] of movies' Type, Year, imdbID, Poster, Title.
                //System.out.println("电影："+movies);
                //System.out.println("页数："+movies.length);
                return movies;
            } else {
                return new String[] { inputline };
            }
        } else {
            String emptyError = "The website is empty";
            in.close();
            return new String[] { emptyError };
        }
    }
}
