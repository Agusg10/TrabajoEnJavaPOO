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
    public void Foward(int second, boolean playing,Publication publication) {
        int playTime=0;
        if (playing) {
            playTime += second;
            System.out.println("Avanzando " + second + " segundos en " + publication.toString());
        } else {
            System.out.println("La publicacion no está en reproduccion");
        }
    }
    @Override
    public void Stop(int playTime, boolean playing,Publication publication){
        if(playing==true){
            playing = false;
            playTime = 0;
            System.out.println("Deteniendo la reproduccion de: " + publication.toString());
        } else {
            System.out.println(publication.toString() + "No está en reproduccion");
        }
    }
    @Override
    public void Play(boolean playing, int end,Publication publication)throws InterruptedException{
        if(!playing){
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
    public void ChangeFont(Publication PublicationVideo) throws InterruptedException {
        String ChosenFont;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la fuente en la que quiere que se muestre el video(Arial,Calibri,Georgia,Impact,Times New Roman)");
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
        // Crear una ventana
        JFrame frame = new JFrame(PublicationVideo.getPublicationName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear un componente de texto con una fuente modificada
        JLabel label = new JLabel(PublicationVideo.toString());
        Font font = new Font("Arial", Font.BOLD, 20);
        label.setFont(Source);

        // Cambio de color de texto
        label.setBackground(Color.black);

        // Agregar el componente de texto a la ventana
        frame.getContentPane().add(label, BorderLayout.CENTER);

        // Mostrar la ventana
        frame.setVisible(true);
        sleep(10000);
        frame.setVisible(false);
    }
    @Override
    public void Fontsize(Publication PublicationImage){
        Font Source=new Font("Arial",Font.PLAIN,50);
        System.out.println(PublicationImage.toString()+"\n"+Source);
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


