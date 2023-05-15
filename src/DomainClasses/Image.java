package DomainClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Image extends Publication{
    private int[] resolution = new int[2];
    private int length;
    private int height;

    public Image(String user, Date uploadDate, int likes,String description, ArrayList<String> hashtags, ArrayList<String> comments, int[] resolution, int length, int height) {
        super(user, uploadDate, likes,description,hashtags,comments);
        this.resolution = resolution;
        this.length = length;
        this.height = height;
    }

    public int[] getResolution() {
        return resolution;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return super.toString()+"Image{" +
                "resolution=" + Arrays.toString(resolution) +
                ", length=" + length +
                ", height=" + height +
                '}';
    }
}
