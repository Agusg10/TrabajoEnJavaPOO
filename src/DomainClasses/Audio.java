package DomainClasses;

import java.util.ArrayList;
import java.util.Date;

public class Audio extends Publication{
    private float duration;
    private float bits;

    public Audio(String user, Date uploadDate, int likes, ArrayList<String> hashtags, ArrayList<String> comments, float duration, float bits) {
        super(user, uploadDate, likes);
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
