package DomainClasses;
import java.util.ArrayList;
public class InstagramProfile {
    private final String user;
    private final String name;
    private final String surname;
    ArrayList<Album> albums;
    // list<public> idPublicaciones = new ArrayList<publicacion>    UPCASTING (POLIMORFICO)
    ArrayList<Publication> publications;

    public InstagramProfile(String user, String name, String surname) {
        this.user = user;
        this.name = name;
        this.surname = surname;
    }

    public void addPublication(Publication publi){
        publications.add(publi);
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
}
