package DomainClasses;

import java.util.ArrayList;
import java.util.Date;

public class Text extends Publication implements Filtrable{
    private int characterAmount;
    private String font;
    private double size;
    private double zoom;

    //Constructors
    public Text(String user, Date uploadDate, int likes, String publicationName, ArrayList<String> hashtags, ArrayList<String> comments, int characterAmount, String font, double size) {
        super(user, uploadDate, likes, publicationName, hashtags, comments);
        this.characterAmount = characterAmount;
        this.font = font;
        this.size = size;
        this.zoom = 100;
    }

    //toString
    public String toString() {
        return super.toString()+
                "\n     Type= Text" +
                "\n     characterAmount=" + characterAmount +
                "\n     font='" + font + '\'' +
                "\n     size=" + size +
                "\n     zoom=" + zoom +
                "\n     ---------------------";
    }

    @Override
    public void Filter() {
        System.out.println("Se aplico un filtro al Texto");
    }
}
