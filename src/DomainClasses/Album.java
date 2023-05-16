package DomainClasses;
import java.util.ArrayList;

public class Album {
    private String albumName;
    private ArrayList<Publication> publications; //add setters
    private ArrayList<Album> subAlbums; //add setters

    public Album() {
    }

    public Album(String albumName) {
        this.albumName = albumName;
        this.publications = null;
        this.subAlbums = null;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumName='" + albumName + '\'' +
                ", publications=" + publications +
                ", subAlbums=" + subAlbums +
                '}';
    }
}
