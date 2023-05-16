package DomainClasses;

import java.util.ArrayList;
import java.util.Date;

public class Text extends Publication{
    private int characterAmount;
    private String font;
    private double size;
    private double zoom;


    public Text(String user, Date uploadDate, int likes, String description, ArrayList<String> hashtags, ArrayList<String> comments, int characterAmount, String font, double size) {
        super(user, uploadDate, likes, description, hashtags, comments);
        this.characterAmount = characterAmount;
        this.font = font;
        this.size = size;
        this.zoom = 100;
    }

    public String toString() {
        return super.toString()+"Text{" +
                "characterAmount=" + characterAmount +
                ", font='" + font + '\'' +
                ", size=" + size +
                ", zoom=" + zoom +
                '}';
    }
}
