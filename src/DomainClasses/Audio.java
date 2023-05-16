package DomainClasses;

import java.util.ArrayList;
import java.util.Date;

public class Audio extends Publication{
    private float duration;
    private float bits;

    //Constructors
    public Audio(String user, Date uploadDate, int likes,String publicationName, ArrayList<String> hashtags, ArrayList<String> comments, float duration, float bits) {
        super(user, uploadDate, likes,publicationName,hashtags,comments);
        this.duration = duration;
        this.bits = bits;
    }

    //Getters
    public float getDuration() {
        return duration;
    }
    public float getBits() {
        return bits;
    }

    //toString
    public String toString() {
        return super.toString()+"Audio{" +
                "duration=" + duration +
                ", bits=" + bits +
                '}';
    }
}
