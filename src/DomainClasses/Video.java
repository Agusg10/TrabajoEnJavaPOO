package DomainClasses;

import java.util.ArrayList;
import java.util.Date;

public class Video extends Publication{
    private float duration;
    private int[] resolution = new int[2];
    private int frameAmount;
    private int actualFrame;

    public Video(String user, Date uploadDate, int likes,String description,ArrayList<String> hashtags, ArrayList<String> comments,float duration, int[] resolution, int frameAmount, int actualFrame) {
        super(user, uploadDate, likes, description,hashtags,comments);
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

