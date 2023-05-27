package DomainClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static java.lang.Thread.sleep;


public class Video extends Publication implements Durable{
    private float duration;
    private int[] resolution = new int[2];
    private int frameAmount;
    private int actualFrame;

    //Constructors
    public Video(String user, Date uploadDate, int likes,String publicationName,ArrayList<String> hashtags, ArrayList<String> comments,float duration, int[] resolution, int frameAmount) {
        super(user, uploadDate, likes, publicationName,hashtags,comments);
        this.duration = duration;
        this.resolution = resolution;
        this.frameAmount = frameAmount;
    }

    //Getters
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


    @Override
    public void Foward(int second, boolean playing, int playTime) {
        if (playing) {
            playTime += second;
            System.out.println("Avanzando " + second + " segundos en " + toString());
        } else {
            System.out.println("La publicacion no está en reproduccion");
        }
    }
    @Override
    public void Stop(int playTime, boolean playing){
        if(playing){
            playing = false;
            playTime = 0;
            System.out.println("Deteniendo la reproduccion de: " + toString());
        } else {
            System.out.println("La publicación no está en reproduccion");
        }
    }
    @Override
    public void Play(boolean playing, int end)throws InterruptedException{
        if(!playing){
            playing = true;
            sleep(1000);
            System.out.println("Reproduciendo: " + toString());
            while (end <duration){
                end++;
                sleep(1000);
                System.out.print(end + " ");
            }
            System.out.println();
            sleep(1000);
            Stop(end, playing);
        } else {
            System.out.println("La publicacion ya está en reproduccion");
        }
    }


    //toString
    public String toString() {
        return super.toString()+
                "\n     Type= Video" +
                "\n     duration=" + duration +
                "\n     resolution=" + Arrays.toString(resolution) +
                "\n     frameAmount=" + frameAmount +
                "\n     actualFrame=" + actualFrame +
                "\n     ---------------------";
    }
}


