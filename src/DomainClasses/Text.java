package DomainClasses;

import java.util.ArrayList;
import java.util.Date;

/**
 * The {@code Text} class represents a text publication.
 * It extends the {@link Publication} class and implements the {@link Filtrable} interface.
 */
public class Text extends Publication implements Filtrable {
    private int characterAmount;
    private String font;
    private double size;
    private double zoom;

    /**
     * Constructs a new Text object with the specified properties.
     *
     * @param user            the user who created the text publication
     * @param uploadDate      the upload date of the text publication
     * @param likes           the number of likes on the text publication
     * @param publicationName the name of the text publication
     * @param hashtags        the list of hashtags associated with the text publication
     * @param comments        the list of comments on the text publication
     * @param characterAmount the amount of characters in the text
     * @param font            the font of the text
     * @param size            the size of the text
     */
    public Text(String user, Date uploadDate, int likes, String publicationName, ArrayList<String> hashtags, ArrayList<String> comments, int characterAmount, String font, double size) {
        super(user, uploadDate, likes, publicationName, hashtags, comments);
        this.characterAmount = characterAmount;
        this.font = font;
        this.size = size;
        this.zoom = 100;
    }

    /**
     * Returns a string representation of the Text object.
     *
     * @return a string representation of the Text object
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n     Type= Text" +
                "\n     characterAmount=" + characterAmount +
                "\n     font='" + font + '\'' +
                "\n     size=" + size +
                "\n     zoom=" + zoom +
                "\n     ---------------------";
    }

    /**
     * Applies a filter to the text publication.
     */
    @Override
    public void Filter() {
        System.out.println("Se aplico un filtro al Texto");
    }
}