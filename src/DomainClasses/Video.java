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
    public void Avanzar(int segundos,boolean reproduciendo,int tiempoReproduccion) {
        if (reproduciendo) {
            tiempoReproduccion += segundos;
            System.out.println("Avanzando " + segundos + " segundos en " + toString());
        } else {
            System.out.println("La publicacion no está en reproduccion");
        }
    }
    @Override
    public void Detener(int tiempoReproduccion,boolean reproduciendo){
        if (reproduciendo) {
            reproduciendo = false;
            tiempoReproduccion = 0;
            System.out.println("Deteniendo la reproduccion de: " + toString());
        } else {
            System.out.println("La publicación no está en reproduccion");
        }
    }
    @Override
    public void Reproducir(boolean reproduciendo,int tope)throws InterruptedException{
        if (!reproduciendo) {
            reproduciendo = true;
            sleep(1000);
            System.out.println("Reproduciendo: " + toString());
            while (tope<duration){
                tope++;
                sleep(1000);
                System.out.print(tope + " ");
            }
            System.out.println();
            sleep(1000);
            Detener(tope,reproduciendo);
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


