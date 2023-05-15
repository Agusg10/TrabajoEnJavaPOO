package DomainClasses;
import java.util.ArrayList;

public class Album {
    private String albumName;
    private ArrayList<Publication> publications; //add setters
    private ArrayList<Album> subAlbums; //add setters

    @Override
    public String toString() {
        return "Album{" +
                "albumName='" + albumName + '\'' +
                ", publications=" + publications +
                ", subAlbums=" + subAlbums +
                '}';
    }
}
