package DomainClasses;

import Comparator.AlbumNameComparator;
import Comparator.PublicationLikesComparator;
import Comparator.PublicationNameComparator;

import java.util.*;
import java.util.List;

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
        this.albums = albums;
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

    public void sortAlbumsAscending(ArrayList<Album> albums){
        Collections.sort(albums, new AlbumNameComparator());
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
        Album albumDelete = searchAlbumByName(this.albums,albumName);
        if (albumDelete == null)
            System.out.println("Album no Existe");
        else{
            if (albumDelete.getSubAlbums() != null) {
                albumDelete.getSubAlbums().clear();
            }

            if (albumDelete.getPublications() != null) {
                albumDelete.getPublications().clear();
            }
            this.albums.remove(albumDelete);
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

    public Album searchSubAlbumByName(Album fatherAlbum, String subAlbumName){
        for(Album subAlb : fatherAlbum.getSubAlbums()){
            if(subAlb.getAlbumName().equals(subAlbumName))
                return subAlb;
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
            if(subAlbumAux != null){
                albumAux.addSubAlbum(subAlbumAux); //si ya existe, lo agrega
                System.out.println("SubAlbum Agregado con exito.");
            }
            else{
                Album newSubAlbum = new Album(subAlbum);
                albumAux.addSubAlbum(newSubAlbum);
                System.out.println("SubAlbum Creado con exito.");
            }
        }
        else
            System.out.println("Album no Existe");
    }

    public void addPubliToAlbum(String albumName,String publiName){
        Album albumAux = searchAlbumByName(this.albums,albumName);
        if(albumAux != null){
            Publication publiAux = searchPubliByName(this.publications,publiName);
            if(publiAux != null)
                albumAux.addPubli(publiAux);
            else
                System.out.println("Publicacion no Existe");
        }
        else
            System.out.println("Album no Existe");
    }

    public void addPubliToSubAlbum(String albumName, String subAlbumName, String publiName){
        Publication publiAux = searchPubliByName(this.publications,publiName);
        if(publiAux != null){
            Album albumAux = searchAlbumByName(this.albums,albumName);
            if(albumAux != null){
                Album subAlbumAux = searchSubAlbumByName(albumAux,subAlbumName);
                if(subAlbumAux != null) {
                    subAlbumAux.addPubli(publiAux);
                }
                else
                    System.out.println("SubAlbum no Existe");
            }
        }
        else
            System.out.println("Publicacion no Existe");
    }

    public void deletePubliFromAlbum(String albumName,String publiName){
        Album albumAux = searchAlbumByName(this.albums,albumName);
        if(albumAux != null){
            Publication publiAux = searchPubliByName(this.publications,publiName);
            if(publiAux != null){
                albumAux.deletePubli(publiAux);
            }
            else
                System.out.println("Publication no Existe");
        }
        else
            System.out.println("Album no Existe");
    }

    public void showLikesStatistics(ArrayList<Publication> publications){
        int likesAudio = 0;
        int likesImage = 0;
        int likesText = 0;
        int likesVideo = 0;

        for (Publication publication : publications){
            if (publication instanceof Image){
                likesImage += publication.getLikes();
            }
            if (publication instanceof Video){
                likesVideo += publication.getLikes();
            }
            if (publication instanceof Text){
                likesText += publication.getLikes();
            }
            if (publication instanceof Audio){
                likesAudio += publication.getLikes();
            }

        }
        Statistics.PublicationsStatistics.BarChart(likesAudio,likesVideo,likesText,likesImage,"Me Gusta","Cantidad de Me Gusta","Estadisticas de likes por tipos");

    }
    public void showPublicationsStatistics(ArrayList<Publication> publications){

        int publiVideo = 0;
        int publiImage = 0;
        int publiText = 0;
        int publiAudio = 0;

        for (Publication publication : publications){
            if (publication instanceof Image){
                publiImage++;
            }
            if (publication instanceof Video){
                publiVideo++;
            }
            if (publication instanceof Text){
                publiText++;
            }
            if (publication instanceof Audio){
                publiAudio++;
            }

        }
        Statistics.PublicationsStatistics.PieChart(publiAudio,publiVideo,publiText,publiImage);

    }



    public void PubicationReport(ArrayList<Publication> publications){
        if (publications != null) {
            ArrayList<Publication> videoPublications = new ArrayList<>();
            ArrayList<Publication> imagePublications = new ArrayList<>();
            ArrayList<Publication> textPublications = new ArrayList<>();
            ArrayList<Publication> audioPublications = new ArrayList<>();

            for (Publication publi : publications) {

                if (publi instanceof Video) {
                    videoPublications.add(publi);
                }
                if (publi instanceof Image) {
                    imagePublications.add(publi);
                }
                if (publi instanceof Text) {
                    textPublications.add(publi);
                }
                if (publi instanceof Audio) {
                    audioPublications.add(publi);
                }
            }

            sortPublicationDescending(videoPublications);
            sortPublicationDescending(imagePublications);
            sortPublicationDescending(textPublications);
            sortPublicationDescending(audioPublications);

            System.out.println("Reporte de Publicaciones por Tipo:");
            System.out.println("--------------------------------------------------------");
            System.out.println("Video:");
            Reports.PublicationsReport.GenerateReportByType("Video-Report.txt", videoPublications);
            System.out.println("--------------------------------------------------------");
            System.out.println("Imagen:");
            Reports.PublicationsReport.GenerateReportByType("Image-Report.txt", imagePublications);
            System.out.println("--------------------------------------------------------");
            System.out.println("Audio:");
            Reports.PublicationsReport.GenerateReportByType("Audio-Report.txt", audioPublications);
            System.out.println("--------------------------------------------------------");
            System.out.println("Texto:");
            Reports.PublicationsReport.GenerateReportByType("Text-Report.txt", textPublications);
            System.out.println("--------------------------------------------------------");


        }else{
            System.out.println("No existen Publicaciones");
        }
    }

    public void AlbumsReport(ArrayList<Album> albums){

        Date startdate = Reports.AlbumsReport.dateRequest("Ingresar Fecha de Inicio(dd/mm/yyyy): ");
        Date enddate = Reports.AlbumsReport.dateRequest("Ingresar Fecha de Fin(dd/mm/yyyy): ");

        if (albums != null) {
            ArrayList<Album> albumsinrange = Reports.AlbumsReport.filterAlbumsByDate(albums, startdate, enddate);
            sortAlbumsAscending(albumsinrange);
            System.out.println("\n");
            System.out.println("Reporte de Albums " + startdate + " -- " + enddate + "\n");
            System.out.println("---------------------------------------------\n");
            for (Album album : albumsinrange) {
                int publicationsAmount = album.getPublications().size();
                int commentsAmount = Reports.AlbumsReport.accountcomments(album.getPublications());

                System.out.println("Nombre del Album: " + album.getAlbumName());
                System.out.println("Cantidad de Publicaciones: " + publicationsAmount);
                System.out.println("Cantidad de Comentarios: " + commentsAmount);
                System.out.println("------------------------------------");
            }

            Reports.AlbumsReport.GenerateReportFileAlbum("Albums-Report.txt", albumsinrange);
        }else{
            System.out.println("No existen Albums");
        }
    }

    public void showAlbums(){
        if (albums == null || albums.isEmpty()) {
            System.out.println("No existen álbumes disponibles.");
        } else {
            System.out.println("Álbumes disponibles:");
            for (Album album : albums) {
                System.out.println("- " + album.getAlbumName());
            }
        }
    }
    public void showAlbumsAndSubAlbums() {
        if (albums == null || albums.isEmpty()) {
            System.out.println("No existen álbumes disponibles.");
        } else {
            System.out.println("Álbumes disponibles:");
            for (Album album : albums) {
                System.out.println("- " + album.getAlbumName());
                album.showPublicationsAlbum();
                showSubAlbums(album,"-");
                System.out.println(" ");
            }
        }
    }

    public void showSubAlbums(Album album, String indent) {
        if (album.getSubAlbums() != null) {
            for (Album subAlbum : album.getSubAlbums()) {
                System.out.println(indent + "- " + subAlbum.getAlbumName());
                subAlbum.showPublicationsAlbum();
            }
        }
    }


    //toString
    public String toString() {
        return "\nInstagramProfile" +
                "\n    user='" + user + '\'' +
                " \n    name='" + name + '\'' +
                " \n    surname='" + surname + '\'' +
                " \n    password="+ password +
                "      \n    albums=\n" + albums +
                "      \n   publications=\n" + publications;
    }

}
