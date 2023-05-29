package DomainClasses;

import java.util.ArrayList;
import java.util.Date;
import java.lang.InterruptedException;

import static java.lang.Thread.sleep;

/**
 * The {@code Audio} class represents an audio publication.
 * It extends the {@link Publication} class and implements the {@link Durable} interface.
 */
public class Audio extends Publication implements Durable {
    private float duration;
    private float bits;

    /**
     * Constructs an audio publication with the specified user, upload date, number of likes, publication name,
     * hashtags, comments, duration, and bits.
     *
     * @param user           the user who uploaded the audio
     * @param uploadDate     the date of upload
     * @param likes          the number of likes
     * @param publicationName the name of the publication
     * @param hashtags       the list of hashtags
     * @param comments       the list of comments
     * @param duration       the duration of the audio
     * @param bits           the number of bits
     */
    public Audio(String user, Date uploadDate, int likes, String publicationName, ArrayList<String> hashtags,
                 ArrayList<String> comments, float duration, float bits) {
        super(user, uploadDate, likes, publicationName, hashtags, comments);
        this.duration = duration;
        this.bits = bits;
    }

    /**
     * Returns the duration of the audio.
     *
     * @return the duration of the audio
     */
    public float getDuration() {
        return duration;
    }

    /**
     * Returns the number of bits of the audio.
     *
     * @return the number of bits of the audio
     */
    public float getBits() {
        return bits;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void Foward(int second, boolean playing, Publication publication) {
        int playTime = 0;
        playTime += second;
        if (playing == true) {
            System.out.println("Avanzando " + second + " segundos en " + publication.getPublicationName() +
                    " y continua su reproducción");
        } else {
            System.out.println("Avanzando " + second + " segundos en " + publication.getPublicationName());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void Stop(int playTime, boolean playing, Publication publication) {
        if (playing == true) {
            playing = false;
            playTime = 0;
            System.out.println("Deteniendo la reproducción de: " + publication.getPublicationName());
        } else {
            System.out.println(publication.getPublicationName() + " NO está en reproducción");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void Play(boolean playing, int end, Publication publication) throws InterruptedException {
        if (!playing) {
            playing = true;
            sleep(1000);
            System.out.println("Reproduciendo: " + publication.getPublicationName());
            while (end < duration) {
                end++;
                sleep(1000);
                System.out.print(end + " ");
            }
            System.out.println();
            sleep(1000);
        } else {
            System.out.println(publication.getPublicationName() + "Ya está en reproducción");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n     Type= Audio" +
                "\n     duration=" + duration +
                "\n     bits=" + bits +
                "\n     ---------------------";
    }
}