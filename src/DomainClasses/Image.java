package DomainClasses;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Image extends Publication implements Filtrable{
    private int[] resolution = new int[2];
    private int length;
    private int height;

    /**
     * Constructs an Image object with the specified attributes.
     *
     * @param user            the username of the user who uploaded the image
     * @param uploadDate      the upload date of the image
     * @param likes           the number of likes the image has
     * @param publicationName the name of the image publication
     * @param hashtags        the list of hashtags associated with the image
     * @param comments        the list of comments on the image
     * @param resolution      the resolution of the image as an array [width, height]
     * @param length          the length of the image
     * @param height          the height of the image
     */
    public Image(String user, Date uploadDate, int likes, String publicationName, ArrayList<String> hashtags, ArrayList<String> comments, int[] resolution, int length, int height) {
        super(user, uploadDate, likes, publicationName,hashtags,comments);
        this.resolution = resolution;
        this.length = length;
        this.height = height;
    }

    /**
     * Returns the resolution of the image as an array [width, height].
     *
     * @return the resolution of the image
     */
    public int[] getResolution() {
        return resolution;
    }
    /**
     * Returns the length of the image.
     *
     * @return the length of the image
     */
    public int getLength() {
        return length;
    }
    /**
     * Returns the height of the image.
     *
     * @return the height of the image
     */
    public int getHeight() {
        return height;
    }


    /**
     * Returns a string representation of the Image object.
     *
     * @return a string representation of the Image object
     */
    public String toString() {
        return super.toString()+
                "\n     Type= Image" +
                "\n     resolution=" + Arrays.toString(resolution) +
                "\n     length=" + length +
                "\n     height=" + height +
                "\n     ---------------------";
    }
    /**
     * Applies a filter to the image.
     */
    @Override
    public void Filter() {
        System.out.println("Se aplico un filtro a la Imagen");
    }
}
