package DomainClasses;

import GUI.LoginMenu;
import GUI.ProfileMenu;
import XML.ClassXML;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ClassXML test = new ClassXML();
        InstagramProfile prof = test.loadXML();
        prof.sortPublicationsAscending(prof.getPublications());

        prof.createAlbum("Album 1");
        prof.createAlbum("Album 2");
        prof.createAlbum("Album 3");

        prof.addPubliToAlbum("Album 2","Visiting the Beach");
        prof.addSubalbumToAlbum("Album 2","SubAlbum2");
        prof.addSubalbumToAlbum("Album 1","Album 2");
        prof.addPubliToAlbum("Album 1", "Football with friends");

        LoginMenu login = new LoginMenu(prof);
        login.displayMenu();
        ProfileMenu profilemenu = new ProfileMenu(prof);
        profilemenu.displayMenu();

    }
}
