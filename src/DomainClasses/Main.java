package DomainClasses;

import GUI.ProfileMenu;
import XML.ClassXML;
import GUI.LogIn;
import javax.swing.*;

import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ClassXML test = new ClassXML();
        InstagramProfile prof = test.loadXML();
        prof.sortPublicationsAscending(prof.getPublications());
        //prof.PubicationReport(prof.getPublications());

        prof.createAlbum("Travels");
        prof.createAlbum("Notes");
        prof.createAlbum("Album 3");

        prof.addPubliToAlbum("Travels","Visiting the Beach");
        prof.addPubliToAlbum("Travels","A night in the forest");
        prof.addPubliToAlbum("Notes","Happy Birthday from Messi");


        /*//prof.sortAlbumsAscending(prof.getAlbums());
        //prof.addSubalbumToAlbum("Notes","Travels");
        //System.out.println("\n");
        //System.out.println(prof.getAlbums());


        System.out.println("\n");
        prof.AlbumsReport(prof.getAlbums());
        */




/*
        prof.createAlbum("Album1");
        prof.createAlbum("Album2");
        prof.createAlbum("Album3");
        prof.addPubliToAlbum("Album1","Happy Birthday from Messi");
        prof.addPubliToAlbum("Album2","Visiting the Beach");
        prof.addPubliToAlbum("Album2","Happy Birthday from Messi");
        System.out.println(prof.getAlbums());
        System.out.println(" ");
        prof.deletePubliFromAlbum("Album2","Happy Birthday from Messi");
        System.out.println(prof.getAlbums());
        System.out.println(" ");
        prof.deletePubliFromAlbum("Album1","Happy Birthday from Messi");
        System.out.println(prof.getAlbums());
        prof.addSubalbumToAlbum("Album2","Album3");
        System.out.println(prof.getAlbums());*/



        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                LogIn dialog = new LogIn(frame, prof);
                dialog.setVisible(true);

                if (dialog.isLoginSuccessful()) {
                    ProfileMenu profilemenu = new ProfileMenu(prof);
                    profilemenu.displayMenu();
                }

                System.exit(0);
            }
        });
        /*
        //Creo una lista de string con los atributos que voy a usar para filtrar
        //También paso la lista de publicaciones original para filtrar
        List<Publication> originalPublications = prof.getPublications();
        List<String> attributes = List.of("Likes", "Duration", "uploadDate", "Hashtags");
        Filters filters = new Filters(attributes, originalPublications);

        // Ejemplo de filtrado por cantidad de me gusta mayor o igual a 100
        List<Publication> filterPublications = filters.filterPublications("Likes", "100");



        // Mostrar las publicaciones filtradas
        for (Publication publi : filterPublications) {
            System.out.println(publi);
        }2

        //Reproduccion de publicaciones de audio y video
        for (Publication publi: originalPublications){
            if (publi instanceof Video)
                ((Video) publi).Play(false,0);
            if (publi instanceof Audio)
                ((Audio) publi).Play(false,0);
        }
         */

        //Filtro de imagen para la fuente2
      /*  List<Publication> Publicaciones=prof.getPublications();
        for (Publication publicacion:Publicaciones){
            if ( publicacion instanceof Image)
                ((Image) publicacion).ChangeFont(publicacion);
        }
       */
    }
}
