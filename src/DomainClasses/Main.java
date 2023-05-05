package DomainClasses;

import XML.ClassXML;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ClassXML test = new ClassXML();
        test.loadArch();

        Date date1 = new Date(20220810);
        Date date2 = new Date(20230602);

        ArrayList<String> hashtags_test1 = new ArrayList<>();
        hashtags_test1.add("Beach");
        hashtags_test1.add("Sunny");

        ArrayList<String> hashtags_test2 = new ArrayList<>();
        hashtags_test2.add("Photography");





        int[] resolucion = {1920,1080};


        InstagramProfile perfil1 = new InstagramProfile("aguslopez","Agustin","Lopez");
        Publication publi1 = new Video("aguslopez",date1,43,"Bom Dia",hashtags_test1,null,45,resolucion,1000,0);
        Publication publi2 = new Image("aguslopez",date2,43,"Guten Tag!",hashtags_test2,null,resolucion,1080,1080);

        perfil1.addPublication(publi1);
        perfil1.addPublication(publi2);


        System.out.println((perfil1.getPublications()).get(0).toString());
        System.out.println((perfil1.getPublications()).get(1).toString());

    }
}
