package Reports;

import DomainClasses.Publication;

import java.io.FileWriter;
import java.util.ArrayList;

public class PublicationsReport {

    public static void showPublications(ArrayList<Publication> publi) {
        int publicationsAmount = publi.size();
        int likesAmount = 0;

        for (Publication publication : publi) {
            System.out.println(publication.toString());
            likesAmount += publication.getLikes();
        }

        double averageLikes = publicationsAmount > 0 ? (double) likesAmount / publicationsAmount : 0;

        System.out.println("Cantidad de Publicaciones: " + publicationsAmount);
        System.out.println("Promedio de Likes : " + averageLikes);
    }


    public static void GenerateReportFilePublication(String fileName, ArrayList<Publication> publications) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Reporte de Publicaciones:\n");
            writer.write("--------------------------\n");

            for (Publication publication : publications) {
                writer.write(publication.toString());
            }

            writer.close();
            System.out.println("Fichero Reporte ha sido generado: " + fileName);
        } catch (Exception e) {
            System.out.println("Error al generar el Fichero Reporte: " + e.getMessage());
        }
    }
}
