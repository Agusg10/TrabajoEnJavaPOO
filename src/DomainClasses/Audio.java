package DomainClasses;

import java.util.ArrayList;

public class Audio extends Publication{
    private float duration;
    private float bits;

    public Audio(String user, String uploadDate, int likes, ArrayList<String> hashtags, ArrayList<String> comments, float duration, float bits) {
        super(user, uploadDate, likes, hashtags, comments);
        this.duration = duration;
        this.bits = bits;
    }

    public float getDuration() {
        return duration;
    }

    public float getBits() {
        return bits;
    }
}
