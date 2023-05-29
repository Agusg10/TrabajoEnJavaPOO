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

/**
 * The {@code AlbumsReport} class provides methods for generating a report based on a list of albums.
 */
public class AlbumsReport {
    /**
     * Default constructor for the AlbumsReport class.
     */
    public AlbumsReport() {
    }

    /**
     * Requests a date from the user.
     *
     * @param menssage1 The message to display when requesting the date.
     * @return The entered date.
     */
    public static Date dateRequest(String menssage1) {
        Scanner scanner = new Scanner(System.in);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {

            System.out.println(menssage1);
            String datestr = scanner.nextLine();

            try {
                return dateFormat.parse(datestr);
            } catch (ParseException e) {
                System.out.println("Fecha incorrecta. Por favor, ingrese una fecha correcta");
            }
        }
    }

    /**
     * Filters albums based on the publication dates within a specified range.
     *
     * @param albums    The list of albums to filter.
     * @param enterdate The start date of the range.
     * @param enddate   The end date of the range.
     * @return The list of albums containing publications within the specified date range.
     */
    public static ArrayList<Album> filterAlbumsByDate(ArrayList<Album> albums, Date enterdate, Date enddate) {
        ArrayList<Album> albumsinrange = new ArrayList<>();
        for (Album album : albums) {
            ArrayList<Publication> publicationsInRange = new ArrayList<>();
            if (album.getPublications() != null) {
                for (Publication publication : album.getPublications()) {
                    Date publicationDate = publication.getUploadDate();
                    if (publicationDate.equals(enterdate) || publicationDate.after(enterdate) && publicationDate.before(enddate) || publicationDate.equals(enddate)) {//para que no incluya las fechas determinadas sacr equals
                        publicationsInRange.add(publication);
                    }
                }
                if (!publicationsInRange.isEmpty()) { //encontre al menos una publicacion dentro de las fechas en el album actual
                    Album albuminrange = new Album(album.getAlbumName());//creo el album
                    albuminrange.setPublications(publicationsInRange);//lo setteo con las publicaciones dentro del rango
                    albumsinrange.add(albuminrange);//agrego el album a la lista de albums en rango
                }
            }
        }
        return albumsinrange;
    }

    /**
     * Counts the total number of comments in a list of publications.
     *
     * @param publications The list of publications.
     * @return The total number of comments.
     */
    public static int accountcomments(ArrayList<Publication> publications) {
        int commentsAmount = 0;
        for (Publication publication : publications) {
            commentsAmount += publication.getComments().size();
        }
        return commentsAmount;
    }

    /**
     * Generates a report file with album information, including the album name, number of publications, and number of comments.
     *
     * @param filename The name of the report file to be generated.
     * @param albums   The list of albums.
     */
    public static void GenerateReportFileAlbum(String filename, ArrayList<Album> albums) {

        try {

            FileWriter writer = new FileWriter(filename);
            writer.write("Reporte de Albums\n");
            writer.write("-------------------\n");

            for (Album album : albums) {
                writer.write("Nombre del Album: " + album.getAlbumName() + "\n");
                writer.write("Cantidad de Publicaciones: " + album.getPublications().size() + "\n");
                writer.write("Cantidad de Comentarios: " + accountcomments(album.getPublications()) + "\n");
                writer.write("------------------------------------\n");
            }
            writer.close();

            System.out.println("Fichero Reporte ha sido generado: " + filename);

        } catch (Exception e) {
            System.out.println("Error al generar el Fichero Reporte: " + e.getMessage());
        }
    }
}
