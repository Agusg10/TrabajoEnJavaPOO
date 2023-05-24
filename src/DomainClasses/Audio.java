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
                "\n     Type= Audio" +
                "\n     duration=" + duration +
                "\n     bits=" + bits +
                "\n     ---------------------";
    }
}
