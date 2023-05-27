package DomainClasses;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import static java.lang.Thread.sleep;


public class Video extends Publication implements Durable,Filtrable{
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

    @Override
    public void CharacterRange(Publication PublicationSize){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese un numero de caracteres para mostrar del Video");
        int CharacterNumbers=sc.nextInt();
        String text = PublicationSize.toString();
        String result = text.substring(0, CharacterNumbers);
        System.out.println(result);
    }
    @Override
    public void ChangeFont(Publication PublicationVideo){
        String ChosenFont;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la fuente en la que quiere que se muestre la/las publicacion(Arial,Calibri,Georgia,Impact,Times New Roman)");
        ChosenFont = sc.next();
        Font Source;
        if (ChosenFont.equalsIgnoreCase("Arial")) {
            Source = new Font("Arial", Font.PLAIN, 14);
        } else if (ChosenFont.equalsIgnoreCase("Calibri")) {
            Source = new Font("Calibri", Font.PLAIN, 18);
        } else if (ChosenFont.equalsIgnoreCase("Georgia")) {
            Source = new Font("Georgia", Font.PLAIN, 6);
        } else if (ChosenFont.equalsIgnoreCase("Impact")) {
            Source = new Font("Impact", Font.PLAIN, 20);
        } else {
            Source = new Font("Times New Roman", Font.BOLD, 12);
        }
        JTextField SourceChangedText=new JTextField(PublicationVideo.toString());
        SourceChangedText.setFont(Source);
        SourceChangedText.setForeground(Color.BLUE);
        System.out.println(SourceChangedText);
    }
    @Override
    public void Fontsize(Publication PublicationImage){
        Font Source=new Font("Arial",Font.PLAIN,50);
        System.out.println(PublicationImage.toString()+Source);
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


