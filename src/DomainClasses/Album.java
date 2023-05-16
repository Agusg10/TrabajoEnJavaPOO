package DomainClasses;
import java.util.ArrayList;

public class Album {
    private String albumName;
    private ArrayList<Publication> publications; //add setters
    private ArrayList<Album> subAlbums; //add setters

    //Constructors
    public Album(String albumName) {
        this.albumName = albumName;
        this.publications = null;
        this.subAlbums = null;
    }

    //toString
    public String toString() {
        String aux = "";
        if(this.albumName!=null)
            aux = aux + albumName;
        if(this.publications!=null)
            aux = aux + publications;
        if(this.subAlbums!=null)
            aux = aux + subAlbums;
        return aux;
    }
}
