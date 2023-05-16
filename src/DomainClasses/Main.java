package DomainClasses;

import XML.ClassXML;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String user, pass;
        user = "aguslopez";
        pass = "pass";
        ClassXML test = new ClassXML();
        InstagramProfile prof = test.loadXML();
        prof.sortPublicationsAscending(prof.getPublications());
        if (!prof.userLogin(user,pass)) {
            System.out.println("Incorrect User or Password");
        } else {
            System.out.println(prof.getPublications().toString());
        }
        prof.createAlbum("Album1");
        prof.createAlbum("Album2");
        System.out.println(prof.getAlbums());
    }
}
