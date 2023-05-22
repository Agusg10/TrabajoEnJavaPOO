package DomainClasses;

import GUI.ProfileMenu;
import XML.ClassXML;
import GUI.LogIn;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ClassXML test = new ClassXML();
        InstagramProfile prof = test.loadXML();
        prof.sortPublicationsAscending(prof.getPublications());

        /*prof.createAlbum("Album1");
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
    }
}
