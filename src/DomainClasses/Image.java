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

    //Constructors
    public Image(String user, Date uploadDate, int likes, String publicationName, ArrayList<String> hashtags, ArrayList<String> comments, int[] resolution, int length, int height) {
        super(user, uploadDate, likes, publicationName,hashtags,comments);
        this.resolution = resolution;
        this.length = length;
        this.height = height;
    }

    //Getters
    public int[] getResolution() {
        return resolution;
    }
    public int getLength() {
        return length;
    }
    public int getHeight() {
        return height;
    }


    //toString
    public String toString() {
        return super.toString()+
                "\n     Type= Image" +
                "\n     resolution=" + Arrays.toString(resolution) +
                "\n     length=" + length +
                "\n     height=" + height +
                "\n     ---------------------";
    }

    @Override
    public void Filter() {
        System.out.println("Se aplico un filtro a la Imagen");
    }
}
