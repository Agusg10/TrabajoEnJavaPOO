package DomainClasses;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import static java.lang.Thread.sleep;

/**
 * Represents a Video publication.
 * Extends the Publication class and implements the Durable and Filtrable interfaces.
 */

public class Video extends Publication implements Durable,Filtrable{
    private float duration;
    private int[] resolution = new int[2];
    private int frameAmount;
    private int actualFrame;
    /**
     * Constructs a Video object with the specified attributes.
     *
     * @param user            the username of the user who uploaded the video
     * @param uploadDate      the upload date of the video
     * @param likes           the number of likes the video has
     * @param publicationName the name of the video publication
     * @param hashtags        the list of hashtags associated with the video
     * @param comments        the list of comments on the video
     * @param duration        the duration of the video
     * @param resolution      the resolution of the video as an array [width, height]
     * @param frameAmount     the total number of frames in the video
     */
    public Video(String user, Date uploadDate, int likes,String publicationName,ArrayList<String> hashtags, ArrayList<String> comments,float duration, int[] resolution, int frameAmount) {
        super(user, uploadDate, likes, publicationName,hashtags,comments);
        this.duration = duration;
        this.resolution = resolution;
        this.frameAmount = frameAmount;
    }

    /**
     * Returns the duration of the video.
     *
     * @return the duration of the video
     */
    public float getDuration() {
        return duration;
    }
    /**
     * Returns the resolution of the video as an array [width, height].
     *
     * @return the resolution of the video
     */
    public int[] getResolution() {
        return resolution;
    }
    /**
     * Returns the total number of frames in the video.
     *
     * @return the frame amount of the video
     */
    public int getFrameAmount() {
        return frameAmount;
    }
    /**
     * Returns the current frame of the video.
     *
     * @return the actual frame of the video
     */
    public int getActualFrame() {
        return actualFrame;
    }

    /**
     * Advances the video playback by the specified number of seconds.
     * If the video is not currently playing, a message indicating that the video is not in playback is displayed.
     *
     * @param second       the number of seconds to advance the video playback
     * @param playing      the current playback status of the video
     * @param publication  the publication object representing the video
     */
    @Override
    public void Foward(int second, boolean playing,Publication publication) {
        int playTime=0;
        if (playing) {
            playTime += second;
            System.out.println("Avanzando " + second + " segundos en " + publication.getPublicationName());
        } else {
            System.out.println("La publicacion no está en reproduccion");
        }
    }
    /**
     * Stops the video playback and resets the playTime counter to 0.
     * If the video is not currently playing, a message indicating that the video is not in playback is displayed.
     *
     * @param playTime     the current playTime of the video
     * @param playing      the current playback status of the video
     * @param publication  the publication object representing the video
     */
    @Override
    public void Stop(int playTime, boolean playing,Publication publication){
        if(playing==true){
            playing = false;
            playTime = 0;
            System.out.println("Deteniendo la reproduccion de: " + publication.getPublicationName());
        } else {
            System.out.println(publication.getPublicationName() + " NO está en reproduccion");
        }
    }
    /**
     * Starts playing the video.
     * If the video is already playing, a message indicating that the video is already in playback is displayed.
     *
     * @param playing      the current playback status of the video
     * @param end          the current end time of the video playback
     * @param publication  the publication object representing the video
     * @throws InterruptedException if the sleep operation is interrupted
     */
    @Override
    public void Play(boolean playing, int end,Publication publication)throws InterruptedException{
        if(!playing){
            playing = true;
            sleep(1000);
            System.out.println("Reproduciendo: " + publication.getPublicationName());
            while (end <duration){
                end++;
                sleep(1000);
                System.out.print(end + " ");
            }
            System.out.println();
            sleep(1000);
        } else {
            System.out.println(publication.getPublicationName() + "Ya está en reproduccion");
        }
    }
    /**
     * Returns a string representation of the Video object.
     *
     * @return a string representation of the Video object
     */
    public String toString() {
        return super.toString()+
                "\n     Type= Video" +
                "\n     duration=" + duration +
                "\n     resolution=" + Arrays.toString(resolution) +
                "\n     frameAmount=" + frameAmount +
                "\n     actualFrame=" + actualFrame +
                "\n     ---------------------";
    }
    /**
     * Applies a filter to the video.
     */
    @Override
    public void Filter() {
        System.out.println("Se aplico un filtro al Video");
    }
}


