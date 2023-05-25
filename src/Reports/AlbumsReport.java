package Reports;

import DomainClasses.Album;
import DomainClasses.Publication;

import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AlbumsReport {
    public AlbumsReport() {
    }

    public static Date dateRequest(String menssage1) {
        Scanner scanner = new Scanner(System.in);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        while (true) {

            System.out.println(menssage1);
            String datestr = scanner.nextLine();

            try {
                return dateFormat.parse(datestr);
            } catch (ParseException e) {
                System.out.println("Invalid date. Please, enter a valid date.");
            }
        }
    }

    public static ArrayList<Album> filterAlbumsByDate(ArrayList<Album> albums, Date enterdate, Date enddate) {
        ArrayList<Album> albumsinrange = new ArrayList<>();
        for (Album album : albums) {
            ArrayList<Publication> publicationsInRange = new ArrayList<>();
            for (Publication publication : album.getPublications()) {
                Date publicationDate = publication.getUploadDate();
                if (publicationDate.equals(enterdate) || publicationDate.after(enterdate) && publicationDate.before(enddate) || publicationDate.equals(enddate)) {//para que no incluya las fechas determinates sacr equals
                    publicationsInRange.add(publication);
                }
            }
            if (!publicationsInRange.isEmpty()) { //encontre al menos una publicacion dentro de las fechas en el album actual
                Album albuminrange = new Album(album.getAlbumName());//creo el album
                albuminrange.setPublications(publicationsInRange);//lo setteo con las publicaciones dentro del rango
                albumsinrange.add(albuminrange);//agrego el album a la lista de albums en rango
            }
        }
        return albumsinrange;
    }



    public static int accountcomments(ArrayList<Publication> publications) {
        int commentsAmount = 0;
        for (Publication publication : publications) {
            commentsAmount += publication.getComments().size();
        }
        return commentsAmount;
    }

    public static void GenerateReportFileAlbum(String filename, ArrayList<Album> albums){

        try{

            FileWriter writer = new FileWriter(filename);
            writer.write("Albums Report\n");
            writer.write("-------------------\n");

            for (Album album : albums){
                writer.write("Álbum Name: " + album.getAlbumName() + "\n");
                writer.write("Publications Amount: " + album.getPublications().size() + "\n");
                writer.write("Comment Amount: " + accountcomments(album.getPublications()) + "\n");
                writer.write("------------------------------------\n");
            }
            writer.close();

            System.out.println("Report File has been generated: " + filename);

        }catch (Exception e){
            System.out.println("Error generating Report File: " + e.getMessage());
        }
    }
}
