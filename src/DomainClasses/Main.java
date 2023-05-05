package DomainClasses;

import XML.ClassXML;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ClassXML test = new ClassXML();
        test.loadArch();

        Date date1 = new Date(20220810);
        Date date2 = new Date(20230602);

        int[] resolucion = {1920,1080};


        InstagramProfile perfil1 = new InstagramProfile("aguslopez","Agustin","Lopez");
        Publication publi1 = new Video("aguslopez",date1,43,"Bom Dia",null,null,45,resolucion,1000,0);
        Publication publi2 = new Image("aguslopez",date2,43,"Guten Tag!",null,null,resolucion,1080,1080);

        perfil1.addPublication(publi1);
        perfil1.addPublication(publi2);

        System.out.println((perfil1.getPublications()).get(0).toString());
        System.out.println((perfil1.getPublications()).get(1).toString());

    }
}
