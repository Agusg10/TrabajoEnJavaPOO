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

    //Getters
    public String getAlbumName() {
        return albumName;
    }

    //Methods
    public void addPubli(Publication publi){
        if(this.publications == null){
            ArrayList<Publication> newPublicationList = new ArrayList<>();
            newPublicationList.add(publi);
            this.publications = newPublicationList;
        }
        else{
            this.publications.add(publi);
        }
    }

    public void deletePubli(Publication publi){
        this.publications.remove(publi);
    }
    public void addSubAlbum(Album subAlb){
        if(this.subAlbums == null){
            ArrayList<Album> newSubAlbumList = new ArrayList<>();
            newSubAlbumList.add(subAlb);
            this.subAlbums = newSubAlbumList;
        }
        else{
            this.subAlbums.add(subAlb);
        }
    }

    //toString
    public String toString() {
        String aux = "";
        if(this.albumName!=null)
            aux = aux + albumName;
        if(this.publications!=null)
            aux = aux +" \nPublications: "+ publications;
        if(this.subAlbums!=null)
            aux = aux +" \nSubAlbums: " +subAlbums;
        return aux+"\n";
    }
}
