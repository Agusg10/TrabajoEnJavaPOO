package DomainClasses;
import Comparator.PublicationDescriptionComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class InstagramProfile {
    private String user;
    private String name;
    private String surname;
    private ArrayList<Album> albums;
    // list<public> idPublicaciones = new ArrayList<publicacion>    UPCASTING (POLIMORFICO)
    private ArrayList<Publication> publications;
    private String password;


    public InstagramProfile(String user, String name, String surname,String password) {
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void sortPublicationsAscending(List<Publication> publi){
        Collections.sort(publi, new PublicationDescriptionComparator());
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

    public void setPublications(ArrayList<Publication> publications) {
        this.publications = publications;
    }

    @Override
    public String toString() {
        return "InstagramProfile{" +
                "user='" + user + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +", password="+ password +
                ", albums=" + albums +
                ", publications=" + publications +
                '}';
    }
    public boolean userLogin(String user,String password){
        if(!this.user.equals(user)|| !this.password.equals(password))
            return false;
        else
            return true;
    }
}
