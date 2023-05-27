package DomainClasses;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Image extends Publication implements Filtrable{
    private int[] resolution = new int[2];
    private int length;
    private int height;

    //Constructors
    public Image(String user, Date uploadDate, int likes, String publicationName, ArrayList<String> hashtags, ArrayList<String> comments, int[] resolution, int length, int height) {
        super(user, uploadDate, likes, publicationName,hashtags,comments);
        this.resolution = resolution;
        this.length = length;
        this.height = height;
    }

    //Getters
    public int[] getResolution() {
        return resolution;
    }
    public int getLength() {
        return length;
    }
    public int getHeight() {
        return height;
    }

   @Override
   public void CharacterRange(Publication PublicationSize){
       Scanner sc=new Scanner(System.in);
       System.out.println("Ingrese un numero de caracteres para mostrar de la imagen");
       int CharacterNumbers=sc.nextInt();
       String text = PublicationSize.toString();
       String result = text.substring(0, CharacterNumbers);
       System.out.println(result);
   }
   @Override
   public void ChangeFont(Publication PublicationImage) throws InterruptedException {
       String ChosenFont;
       Scanner sc = new Scanner(System.in);
       System.out.println("Ingrese la fuente en la que quiere que se muestre la imagen(Arial,Calibri,Georgia,Impact,Times New Roman)");
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
       JFrame frame = new JFrame(PublicationImage.getPublicationName());
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(400, 300);

       // Crear un componente de texto con una fuente modificada
       JLabel label = new JLabel(PublicationImage.toString());
       label.setFont(Source);

       //Cambio de color
       label.setForeground(Color.orange);

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
       System.out.println(PublicationImage.toString()+"\n" +Source);
   }

    //toString
    public String toString() {
        return super.toString()+
                "\n     Type= Image" +
                "\n     resolution=" + Arrays.toString(resolution) +
                "\n     length=" + length +
                "\n     height=" + height +
                "\n     ---------------------";
    }
}
