package DomainClasses;

import java.util.ArrayList;
import java.util.Date;
import java.lang.InterruptedException;

import static java.lang.Thread.sleep;

public class Audio extends Publication implements Durable{
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
        if (playing) {
            playing = false;
            playTime = 0;
            System.out.println("Deteniendo la reproduccion de: " + toString());
        } else {
            System.out.println("La publicación no está en reproduccion");
        }
    }
    @Override
    public void Play(boolean playing, int end)throws InterruptedException{
        if (!playing) {
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
                "\n     Type= Audio" +
                "\n     duration=" + duration +
                "\n     bits=" + bits +
                "\n     ---------------------";
    }
}
