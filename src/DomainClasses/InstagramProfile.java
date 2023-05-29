package DomainClasses;

import Comparator.AlbumNameComparator;
import Comparator.PublicationLikesComparator;
import Comparator.PublicationNameComparator;

import java.util.*;
import java.util.List;
    /**
     * Represents an Instagram profile.
     */
public class InstagramProfile {
    private String user;
    private String name;
    private String surname;
    private ArrayList<Album> albums;
    private ArrayList<Publication> publications;
    private String password;

        /**
         * Constructs an InstagramProfile object with the specified user, name, surname, and password.
         *
         * @param user     the username of the profile
         * @param name     the name of the profile owner
         * @param surname  the surname of the profile owner
         * @param password the password of the profile
         */

    public InstagramProfile(String user, String name, String surname,String password) {
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.albums = null;
    }

        /**
         * Sets the user name of the profile.
         *
         * @param user the user name to set
         */
    public void setUser(String user) {
        this.user = user;
    }

        /**
         * Sets the name of the profile owner.
         *
         * @param name the name to set
         */

    public void setName(String name) {
        this.name = name;
    }

        /**
         * Sets the surname of the profile owner.
         *
         * @param surname the surname to set
         */

    public void setSurname(String surname) {
        this.surname = surname;
    }

        /**
         * Sets the list of publications for the profile.
         *
         * @param publications the list of publications to set
         */

    public void setPublications(ArrayList<Publication> publications) {
        this.publications = publications;
    }

        /**
         * Sets the list of albums for the profile.
         *
         * @param albums the list of albums to set
         */

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

        /**
         * Returns the password of the profile.
         *
         * @return the password of the profile
         */

    public String getPassword() {
        return password;
    }

        /**
         * Returns the user name of the profile.
         *
         * @return the user name of the profile
         */

    public String getUser() {
        return user;
    }

        /**
         * Returns the name of the profile owner.
         *
         * @return the name of the profile owner
         */

    public String getName() {
        return name;
    }

        /**
         * Returns the surname of the profile owner.
         *
         * @return the surname of the profile owner
         */

    public String getSurname() {
        return surname;
    }

        /**
         * Returns the list of publications for the profile.
         *
         * @return the list of publications for the profile
         */

    public ArrayList<Publication> getPublications() {
        return publications;
    }

        /**
         * Returns the list of albums for the profile.
         *
         * @return the list of albums for the profile
         */

    public ArrayList<Album> getAlbums() {
        return albums;
    }

        /**
         * Sorts the list of publications in ascending order based on their names.
         *
         * @param publi the list of publications to be sorted
         */

    public void sortPublicationsAscending(List<Publication> publi){
        Collections.sort(publi, new PublicationNameComparator());
    }

        /**
         * Sorts the list of publications in descending order based on their likes.
         *
         * @param publi the list of publications to be sorted
         */

    public void sortPublicationDescending(ArrayList<Publication> publi){
        Collections.sort(publi, new PublicationLikesComparator().reversed());
    }

        /**
         * Sorts the list of albums in ascending order based on their names.
         *
         * @param albums the list of albums to be sorted
         */

    public void sortAlbumsAscending(ArrayList<Album> albums){
        Collections.sort(albums, new AlbumNameComparator());
    }

        /**
         * Creates a new album with the given name and adds it to the profile's list of albums.
         *
         * @param albumName the name of the new album
         */

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

        /**
         * Deletes the album with the given name from the profile's list of albums.
         *
         * @param albumName the name of the album to be deleted
         */

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

        /**
         * Searches for an album with the given name in the list of albums.
         *
         * @param albums     the list of albums to search in
         * @param albumName  the name of the album to search for
         * @return the found album or null if not found
         */

    public Album searchAlbumByName(ArrayList<Album> albums, String albumName){
        for(Album alb : albums){
            if (alb.getAlbumName().equals(albumName)){
                return alb;
            }
        }
        return null;
    }

        /**
         * Searches for a sub-album with the given name in the specified album.
         *
         * @param fatherAlbum   the album to search within
         * @param subAlbumName  the name of the sub-album to search for
         * @return the found sub-album or null if not found
         */

    public Album searchSubAlbumByName(Album fatherAlbum, String subAlbumName){
        for(Album subAlb : fatherAlbum.getSubAlbums()){
            if(subAlb.getAlbumName().equals(subAlbumName))
                return subAlb;
        }
        return null;
    }

        /**
         * Searches for a publication with the given name in the specified list of publications.
         *
         * @param publications the list of publications to search in
         * @param publiName    the name of the publication to search for
         * @return the found publication or null if not found
         */

    public Publication searchPubliByName(ArrayList<Publication> publications, String publiName){
        for(Publication pub : publications){
            if (pub.getPublicationName().equals(publiName)){
                return pub;
            }
        }
        return null;
    }

        /**
         * Adds a sub-album to an existing album in the profile.
         * If the sub-album already exists, it is added to the album.
         * If the sub-album doesn't exist, a new sub-album is created and added to the album.
         *
         * @param album    the name of the album to add the sub-album to
         * @param subAlbum the name of the sub-album to be added
         */

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

        /**
         * Adds a publication to an existing album in the profile.
         *
         * @param albumName  the name of the album to add the publication to
         * @param publiName  the name of the publication to be added
         */

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

        /**
         * Adds a publication to a sub-album of an existing album in the profile.
         *
         * @param albumName     the name of the album that contains the sub-album
         * @param subAlbumName  the name of the sub-album to add the publication to
         * @param publiName     the name of the publication to be added
         */

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

        /**
         * Deletes a publication from an existing album in the profile.
         *
         * @param albumName  the name of the album to delete the publication from
         * @param publiName  the name of the publication to be deleted
         */

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

        /**
         * Displays the statistics of likes for the given list of publications.
         *
         * @param publications the list of publications to display the statistics for
         */

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

        // Count the number of publications for each type
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

        // Generate a pie chart based on the publication type counts
        Statistics.PublicationsStatistics.PieChart(publiAudio,publiVideo,publiText,publiImage);

    }


        /**
         * Generates a publication report based on the provided ArrayList of publications.
         * The report includes separate reports for each publication type (video, image, text, audio).
         *
         * @param publications The ArrayList of publications to generate the report from.
         */
    public void PubicationReport(ArrayList<Publication> publications){
        if (publications != null) {

            // Initialize separate ArrayLists for each publication type
            ArrayList<Publication> videoPublications = new ArrayList<>();
            ArrayList<Publication> imagePublications = new ArrayList<>();
            ArrayList<Publication> textPublications = new ArrayList<>();
            ArrayList<Publication> audioPublications = new ArrayList<>();

            // Iterate over publications and categorize them into respective ArrayLists
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

            // Sort publications in descending order
            sortPublicationDescending(videoPublications);
            sortPublicationDescending(imagePublications);
            sortPublicationDescending(textPublications);
            sortPublicationDescending(audioPublications);

            // Print separate reports for each publication type
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


        /**
         * Generates an albums report based on the provided ArrayList of albums.
         * The report includes album details such as name, publication count, and comment count within a specified date range.
         *
         * @param albums The ArrayList of albums to generate the report from.
         */
    public void AlbumsReport(ArrayList<Album> albums){

        // Request start and end dates for the report
        Date startdate = Reports.AlbumsReport.dateRequest("Ingresar Fecha de Inicio(dd/mm/yyyy): ");
        Date enddate = Reports.AlbumsReport.dateRequest("Ingresar Fecha de Fin(dd/mm/yyyy): ");

        if (albums != null) {

            // Filter albums based on the specified date range
            ArrayList<Album> albumsinrange = Reports.AlbumsReport.filterAlbumsByDate(albums, startdate, enddate);

            // Sort albums in ascending order
            sortAlbumsAscending(albumsinrange);

            // Print report header
            System.out.println("\n");
            System.out.println("Reporte de Albums " + startdate + " -- " + enddate + "\n");
            System.out.println("---------------------------------------------\n");

            // Iterate over filtered albums and display details
            for (Album album : albumsinrange) {
                int publicationsAmount = album.getPublications().size();
                int commentsAmount = Reports.AlbumsReport.accountcomments(album.getPublications());

                System.out.println("Nombre del Album: " + album.getAlbumName());
                System.out.println("Cantidad de Publicaciones: " + publicationsAmount);
                System.out.println("Cantidad de Comentarios: " + commentsAmount);
                System.out.println("------------------------------------");
            }

            // Generate report file
            Reports.AlbumsReport.GenerateReportFileAlbum("Albums-Report.txt", albumsinrange);
        }else{
            System.out.println("No existen Albums");
        }
    }


        /**
         * Displays the available albums of the Instagram profile.
         * If there are no albums available, it prints a message indicating so.
         */
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


        /**
         * Displays the albums and their sub-albums, along with their respective publications, of the Instagram profile.
         * If there are no albums available, it prints a message indicating so.
         */
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


        /**
         * Displays the sub-albums and their publications of a given album.
         *
         * @param album  The album to show the sub-albums for.
         * @param indent The indentation string to format the output.
         */

        public void showSubAlbums(Album album, String indent) {
        if (album.getSubAlbums() != null) {
            for (Album subAlbum : album.getSubAlbums()) {
                System.out.println(indent + "- " + subAlbum.getAlbumName());
                subAlbum.showPublicationsAlbum();
            }
        }else
            System.out.println("El album "+album.getAlbumName()+" no tiene subalbums");
    }


        /**
         * Displays all the publications of the Instagram profile.
         * If there are no publications available, it prints a message indicating so.
         */
    public void showPublications() {
        int i=0;
        if (publications == null || publications.isEmpty()) {
            System.out.println("No existen publicaciones disponibles.");
        } else {
            System.out.println("Publicaciones disponibles:");
            for (Publication publication : publications) {
                i++;
                System.out.println(i+"- " + publication.getPublicationName());
            }
        }
    }


        /**
         * Displays the audio publications of the Instagram profile.
         * If there are no audio publications available, it prints a message indicating so.
         */
    public void showPublicationsAudio(){
        if (publications == null || publications.isEmpty()){
            System.out.println("No existen publicaciones disponibles.");
        } else {
            System.out.println("Publicaciones de Audio:");
            for (Publication publication : publications){
                if(publication instanceof Audio)
                    System.out.println(publication.getPublicationName());
            }
        }
    }


        /**
         * Displays the image publications of the Instagram profile.
         * If there are no image publications available, it prints a message indicating so.
         */
    public void showPublicationsImage(){
        if (publications == null || publications.isEmpty()){
            System.out.println("No existen publicaciones disponibles.");
        } else {
            System.out.println("Publicaciones de Imagen:");
            for (Publication publication : publications){
                if(publication instanceof Image)
                    System.out.println("- "+publication.getPublicationName());
            }
        }
    }


        /**
         * Displays the text publications of the Instagram profile.
         * If there are no text publications available, it prints a message indicating so.
         */
    public void showPublicationsText(){
        if (publications == null || publications.isEmpty()){
            System.out.println("No existen publicaciones disponibles.");
        } else {
            System.out.println("Publicaciones de Texto:");
            for (Publication publication : publications){
                if(publication instanceof Text)
                    System.out.println("- "+publication.getPublicationName());
            }
        }
    }

        /**
         * Displays the video publications of the Instagram profile.
         * If there are no video publications available, it prints a message indicating so.
         */
    public void showPublicationsVideo(){
        if (publications == null || publications.isEmpty()){
            System.out.println("No existen publicaciones disponibles.");
        } else {
            System.out.println("Publicaciones de Video:");
            for (Publication publication : publications){
                if(publication instanceof Video)
                    System.out.println("- "+publication.getPublicationName());
            }
        }
    }

    //toString
        /**
         * Returns a string representation of the InstagramProfile object.
         *
         * @return A string containing the profile information, including user, name, surname,
         * password, albums, and publications.
         */
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
