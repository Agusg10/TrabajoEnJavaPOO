package Instagram;

import java.util.ArrayList;

public class Video extends Publication{
    private float duration;
    private int[] resolution = new int[2];
    private int frameAmount;
    private int actualFrame;

    public Video(String user, String uploadDate, int likes, ArrayList<String> hashtags, ArrayList<String> comments, float duration, int[] resolution, int frameAmount, int actualFrame) {
        super(user, uploadDate, likes, hashtags, comments);
        this.duration = duration;
        this.resolution = resolution;
        this.frameAmount = frameAmount;
        this.actualFrame = actualFrame;
    }

    public float getDuration() {
        return duration;
    }

    public int[] getResolution() {
        return resolution;
    }

    public int getFrameAmount() {
        return frameAmount;
    }

    public int getActualFrame() {
        return actualFrame;
    }
}

