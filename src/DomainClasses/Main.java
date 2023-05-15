package DomainClasses;

import XML.ClassXML;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ClassXML test = new ClassXML();
        InstagramProfile prof = test.loadXML();
        prof.sortPublicationsAscending(prof.getPublications());
        System.out.println(prof.getPublications().toString());
    }
}
