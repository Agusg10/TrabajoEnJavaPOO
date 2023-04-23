package Instagram;
import java.util.ArrayList;

public class Album {
    ArrayList<Publication> publications; //add setters
    ArrayList<Album> subAlbums; //add setters

    public Album(ArrayList<Publication> publications, ArrayList<Album> subAlbums) {
        this.publications = publications;
        this.subAlbums = subAlbums;
    }


}
