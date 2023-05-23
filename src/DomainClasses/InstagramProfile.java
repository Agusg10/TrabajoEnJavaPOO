package DomainClasses;

import Comparator.PublicationLikesComparator;
import Comparator.PublicationNameComparator;

import java.io.FileWriter;
import java.io.IOException;
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

    public void sortPublicationDescending(ArrayList<Publication> publi){
        Collections.sort(publi, new PublicationLikesComparator().reversed());
    }

    public boolean userLogin(String user, String password){
        if (user == null || password == null) {
            return false;
        }
        else
            return this.user.equalsIgnoreCase(user) && this.password.equals(password);
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

    public void deleteAlbum(String albumName){
        Album albumEliminar = searchAlbumByName(this.albums,albumName);
        if (albumEliminar == null)
            System.out.println("Album doesnt exists");
        else{
            if (albumEliminar.getSubAlbums() != null) {
                albumEliminar.getSubAlbums().clear();
            }

            if (albumEliminar.getPublications() != null) {
                albumEliminar.getPublications().clear();
            }
            this.albums.remove(albumEliminar);
        }
    }

    public Album searchAlbumByName(ArrayList<Album> albums, String albumName){
        for(Album alb : albums){
            if (alb.getAlbumName().equals(albumName)){
                return alb;
            }
        }
        return null;
    }

    public Publication searchPubliByName(ArrayList<Publication> publications, String publiName){
        for(Publication pub : publications){
            if (pub.getPublicationName().equals(publiName)){
                return pub;
            }
        }
        return null;
    }

    public void addSubalbumToAlbum(String album, String subAlbum){
        Album albumAux = searchAlbumByName(this.albums,album);
        if(albumAux != null){
            Album subAlbumAux = searchAlbumByName(this.albums,subAlbum);
            if(subAlbumAux != null)
                albumAux.addSubAlbum(subAlbumAux);
            else
                System.out.println("SubAlbum doesnt Exists");
        }
        else
            System.out.println("Album doesnt Exists");
    }

    public void addPubliToAlbum(String albumName,String publiName){
        Album albumAux = searchAlbumByName(this.albums,albumName);
        if(albumAux != null){
            Publication publiAux = searchPubliByName(this.publications,publiName);
            if(publiAux != null)
                albumAux.addPubli(publiAux);
            else
                System.out.println("Publication doesnt Exists");
        }
        else
            System.out.println("Album doesnt Exists");
    }

    public void deletePubliFromAlbum(String albumName,String publiName){
        Album albumAux = searchAlbumByName(this.albums,albumName);
        if(albumAux != null){
            Publication publiAux = searchPubliByName(this.publications,publiName);
            if(publiAux != null){
                albumAux.deletePubli(publiAux);
            }
            else
                System.out.println("Publication doesnt Exists");
        }
        else
            System.out.println("Album doesnt Exists");
    }

    public void PubicationReport(ArrayList<Publication> publications){

        ArrayList<Publication> videoPublications = new ArrayList<>();
        ArrayList<Publication> imagePublications = new ArrayList<>();
        ArrayList<Publication> textPublications = new ArrayList<>();
        ArrayList<Publication> audioPublications = new ArrayList<>();

        for(Publication publi : publications){

            if (publi instanceof Video){
                videoPublications.add(publi);
            }
            if (publi instanceof Image){
                imagePublications.add(publi);
            }
            if (publi instanceof Text){
                textPublications.add(publi);
            }
            if (publi instanceof Audio){
                audioPublications.add(publi);
            }
        }

        sortPublicationDescending(videoPublications);
        sortPublicationDescending(imagePublications);
        sortPublicationDescending(textPublications);
        sortPublicationDescending(audioPublications);

        System.out.println("Publication Report by Type:");
        System.out.println("--------------------------------------------------------");
        System.out.println("Video:");
        showPublications(videoPublications);
        System.out.println("--------------------------------------------------------");
        System.out.println("Image:");
        showPublications(imagePublications);
        System.out.println("--------------------------------------------------------");
        System.out.println("Audio:");
        showPublications(audioPublications);
        System.out.println("--------------------------------------------------------");
        System.out.println("Text:");
        showPublications(textPublications);
        System.out.println("--------------------------------------------------------");

        GenerateReportFile("Video-Report.txt",videoPublications);
        GenerateReportFile("Image-Report.txt",imagePublications);
        GenerateReportFile("Audio-Report.txt",audioPublications);
        GenerateReportFile("Text-Report.txt",textPublications);
    }

    private static void showPublications(ArrayList<Publication> publi) {
        int publicationsAmount = publi.size();
        int likesAmount = 0;

        for (Publication publication : publi) {
            System.out.println(publication.toString());
            likesAmount += publication.getLikes();
        }

        double averageLikes = publicationsAmount > 0 ? likesAmount / publicationsAmount : 0;

        System.out.println("Publications Amount: " + publicationsAmount);
        System.out.println("Average Likes: " + averageLikes);
    }


    private static void GenerateReportFile(String fileName, ArrayList<Publication> publications) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Publications Report:\n");
            writer.write("--------------------------\n");

            for (Publication publication : publications) {
                writer.write(publication.toString());
            }

            writer.close();
            System.out.println("Report File has been generated: " + fileName);
        } catch (Exception e) {
            System.out.println("Error generating Report File: " + e.getMessage());
        }
    }



    //toString
    public String toString() {
        return "InstagramProfile" +
                "user='" + user + '\'' +
                " name='" + name + '\'' +
                " surname='" + surname + '\'' +
                " password="+ password +
                "      albums=" + albums +
                "      publications=" + publications;
    }

}
