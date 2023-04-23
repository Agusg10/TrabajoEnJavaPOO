package Instagram;

import java.util.ArrayList;

public class Image extends Publication{
    private int[] resolution = new int[2];
    private int lenght;
    private int height;

    public Image(String user, String uploadDate, int likes, ArrayList<String> hashtags, ArrayList<String> comments, int[] resolution, int lenght, int height) {
        super(user, uploadDate, likes, hashtags, comments);
        this.resolution = resolution;
        this.lenght = lenght;
        this.height = height;
    }

    public int[] getResolution() {
        return resolution;
    }

    public int getLenght() {
        return lenght;
    }

    public int getHeight() {
        return height;
    }
}
