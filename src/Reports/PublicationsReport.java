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

        System.out.println("Publications Amount: " + publicationsAmount);
        System.out.println("Average Likes: " + averageLikes);
    }


    public static void GenerateReportFilePublication(String fileName, ArrayList<Publication> publications) {
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
}
