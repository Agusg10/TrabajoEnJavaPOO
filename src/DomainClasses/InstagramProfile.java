package DomainClasses;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class InstagramProfile {
    private final String user;
    private final String name;
    private final String surname;
    private ArrayList<Album> albums;
    // list<public> idPublicaciones = new ArrayList<publicacion>    UPCASTING (POLIMORFICO)
    private ArrayList<Publication> publications;

    public InstagramProfile(String user, String name, String surname) {
        this.user = user;
        this.name = name;
        this.surname = surname;
    }

    public void addPublication(Publication publi){ // agregar ordenado por nombre
        if(publications == null){
            publications = new ArrayList<Publication>();
        }
        publications.add(publi);
    }

    public void sortPublicationsAscending(List<Publication> publi){
        //Collections.sort(publi);
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }
}
