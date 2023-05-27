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
    public void Foward(int second, boolean playing,Publication publication) {
        int playTime=0;
        playTime += second;
        if (playing==true) {
            System.out.println("Se avanzo " + second + " segundos en " + publication.toString()+" y continua su repdroduccion");
        } else {
            System.out.println("Se avanzo "+ second + "segundos en "+ publication.toString()  + " y está pausada");
        }
    }
    @Override
    public void Stop(int playTime, boolean playing,Publication publication){
        if (playing==true) {
            playing = false;
            playTime = 0;
            System.out.println("Deteniendo la reproduccion de: " + publication.toString());
        } else {
            System.out.println(publication.toString() + "No está en reproduccion");
        }
    }
    @Override
    public void Play(boolean playing, int end,Publication publication)throws InterruptedException{
        if (!playing) {
            playing = true;
            sleep(1000);
            System.out.println("Reproduciendo: " + publication.toString());
            while (end <duration){
                end++;
                sleep(1000);
                System.out.print(end + " ");
            }
            System.out.println();
            sleep(1000);
        } else {
            System.out.println(publication.toString() + "Ya está en reproduccion");
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
