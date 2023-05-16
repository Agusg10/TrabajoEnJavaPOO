package DomainClasses;
import Comparator.PublicationNameComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class InstagramProfile {
    private String user;
    private String name;
    private String surname;
    private ArrayList<Album> albums;
    private ArrayList<Publication> publications;
    private String password;

    //Constructors
    public InstagramProfile(String user, String name, String surname,String password) {
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.albums = null;
    }

    //Setters
    public void setUser(String user) {
        this.user = user;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPublications(ArrayList<Publication> publications) {
        this.publications = publications;
    }
    public void setAlbums(ArrayList<Album> albums) {
        ArrayList<Album> newAlbumList = new ArrayList<>();
    }

    //Getters
    public String getPassword() {
        return password;
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
    public ArrayList<Album> getAlbums() {
        return albums;
    }

    //Methods
    public void sortPublicationsAscending(List<Publication> publi){
        Collections.sort(publi, new PublicationNameComparator());
    }
    public boolean userLogin(String user,String password){
        if(!this.user.equals(user)|| !this.password.equals(password))
            return false;
        else
            return true;
    }
    public void createAlbum(String albumName){
        Album newAlbum = new Album(albumName);
        if(this.albums == null){
            ArrayList<Album> newAlbumList = new ArrayList<>();
            newAlbumList.add(newAlbum);
            this.albums = newAlbumList;
        }
        else
            this.albums.add(newAlbum);
    }
    //toString
    public String toString() {
        return "InstagramProfile{" +
                "user='" + user + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +", password="+ password +
                ", albums=" + albums +
                ", publications=" + publications +
                '}';
    }
}
