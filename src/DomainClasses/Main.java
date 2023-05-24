package DomainClasses;

import GUI.ProfileMenu;
import XML.ClassXML;
import GUI.LogIn;
import javax.swing.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ClassXML test = new ClassXML();
        InstagramProfile prof = test.loadXML();
        prof.sortPublicationsAscending(prof.getPublications());
        //prof.PubicationReport(prof.getPublications());

        prof.createAlbum("Album1");
        prof.createAlbum("Album2");
        prof.createAlbum("Album3");
        /*prof.addPubliToAlbum("Album1","Happy Birthday from Messi");
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

        //Creo una lista de string con los atributos que voy a usar para filtrar
        //También paso la lista de publicaciones original para filtrar
        List<Publication> publicacionesOriginales = prof.getPublications();
        List<String> atributos = List.of("CantidadMegusta", "Duracion", "FechaSubida", "Hashtags");
        Filtros filtros = new Filtros(atributos, publicacionesOriginales);

        // Ejemplo de filtrado por cantidad de me gusta mayor o igual a 100
        List<Publication> publicacionesFiltradas = filtros.filtrarPublicaciones("CantidadMegusta", "100");



        // Mostrar las publicaciones filtradas
        for (Publication publicacion : publicacionesFiltradas) {
            System.out.println(publicacion);
        }

        //Reproduccion de publicaciones de audio y video
        for (Publication publicacion: publicacionesOriginales){
            if (publicacion instanceof Video)
                ((Video) publicacion).Reproducir(false,0);
            if (publicacion instanceof Audio)
                ((Audio) publicacion).Reproducir(false,0);
        }



    }
}
