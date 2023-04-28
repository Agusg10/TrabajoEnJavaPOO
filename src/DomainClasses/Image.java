package DomainClasses;

import java.util.ArrayList;
import java.util.Date;

public class Image extends Publication{
    private int[] resolution = new int[2];
    private int width;
    private int height;

    public Image(String user, Date uploadDate, int likes, ArrayList<String> hashtags, ArrayList<String> comments, int[] resolution, int width, int height) {
        super(user, uploadDate, likes);
        this.resolution = resolution;
        this.width = width;
        this.height = height;
    }

    public int[] getResolution() {
        return resolution;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
