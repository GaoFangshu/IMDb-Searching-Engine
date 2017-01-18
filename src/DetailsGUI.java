import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Fangshu Gao on 2017-01-18.
 */
public class DetailsGUI {
    private JPanel detailsPanel;
    private JLabel titleLabel;
    private JLabel releasedLabel;
    private JLabel genreLabel;
    private JLabel imdbratingLabel;
    private JLabel imdbvotesLabel;
    private JLabel metascoreLabel;
    private JLabel languageLabel;
    private JLabel countryLabel;
    private JLabel runtimeLabel;
    private JLabel awardsLabel;
    private JLabel ratedLabel;
    private JLabel directorLabel;
    private JLabel writerLabel;
    private JLabel actorsLabel;
    private JLabel plotLabel;
    private JLabel typeLabel;
    private JLabel imdbidLabel;
    private JTextArea titleTArea;
    private JTextArea releasedTArea;
    private JTextArea genreArea;
    private JTextArea imdbratingArea;
    private JTextArea imdbvotesArea;
    private JTextArea metascoreTArea;
    private JTextArea languageTArea;
    private JTextArea countryTArea;
    private JTextArea runtimeTArea;
    private JTextArea ratedTArea;
    private JTextArea awardsTArea;
    private JTextArea directorTArea;
    private JTextArea writerTArea;
    private JTextArea actorsTArea;
    private JTextArea plotTArea;
    private JTextArea imdbidTArea;
    private JTextArea typeTArea;
    private JLabel posterLabel;

    public void init(String detailsJson) throws IOException {
        SetJTArea setJTArea = new SetJTArea();
        setJTArea.setJTArea(titleTArea, detailsJson, "Title");
        setJTArea.setJTArea(releasedTArea, detailsJson, "Released");
        setJTArea.setJTArea(genreArea, detailsJson, "Genre");
        setJTArea.setJTArea(imdbratingArea, detailsJson, "imdbRating");
        setJTArea.setJTArea(imdbvotesArea, detailsJson, "imdbVotes");
        setJTArea.setJTArea(metascoreTArea, detailsJson, "Metascore");
        setJTArea.setJTArea(languageTArea, detailsJson, "Language");
        setJTArea.setJTArea(countryTArea, detailsJson, "Country");
        setJTArea.setJTArea(runtimeTArea, detailsJson, "Runtime");
        setJTArea.setJTArea(ratedTArea, detailsJson, "Rated");
        setJTArea.setJTArea(awardsTArea, detailsJson, "Awards");
        setJTArea.setJTArea(directorTArea, detailsJson, "Director");
        setJTArea.setJTArea(writerTArea, detailsJson, "Writer");
        setJTArea.setJTArea(actorsTArea, detailsJson, "Actors");
        setJTArea.setJTArea(plotTArea, detailsJson, "Plot");
        setJTArea.setJTArea(imdbidTArea, detailsJson, "imdbID");
        setJTArea.setJTArea(typeTArea, detailsJson, "Type");

        JsonToMap jsonToMap = new JsonToMap();
        setPosterLabel(jsonToMap.getValue(jsonToMap.transfer(detailsJson), "Poster"));
    }

    public JPanel getDetailsPanel() {
        return detailsPanel;
    }

    public void setPosterLabel(String var) throws IOException {
        URL url = new URL(var);
        BufferedImage image = ImageIO.read(url);
        this.posterLabel.setIcon(new ImageIcon(image));
    }
}
