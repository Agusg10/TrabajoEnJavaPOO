package GUI;
import DomainClasses.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The PublicationMenu class represents a menu for handling operations related to publications in an Instagram profile.
 */
public class PublicationMenu {

    private InstagramProfile profile;
    private Scanner scanner;

    /**
     * Constructs a PublicationMenu object with the specified InstagramProfile.
     *
     * @param profile the InstagramProfile object for which the publication menu is created
     */
    public PublicationMenu(InstagramProfile profile){
        this.profile = profile;
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the publication menu and handles user input.
     *
     * @throws InterruptedException if the thread is interrupted
     */
    public void displayMenu() throws InterruptedException {

        System.out.println("#################################");
        System.out.println("|                               |");
        System.out.println("|     MENU DE PUBLICACIONES     |");
        System.out.println("|                               |");
        System.out.println("#################################");

        int opcion;
        do {
            try{
                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Filtros Visuales");
                System.out.println("2. Filtrar Publicaciones por atributos");
                System.out.println("3. Mostrar Publicaciones");
                System.out.println("4. Reproduccion de videos y audios");
                System.out.println("5. Volver");
                System.out.println("6. Cerrar sesion");

                System.out.print("Opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        FiltersMenu filtersMenu = new FiltersMenu(profile);
                        filtersMenu.displayMenu();
                        break;
                    case 2:
                        // busca mediante filtros
                        System.out.println("Ingrese el filtro de búsqueda (likes, duration, uploaddate, hashtags):");
                        String filter = scanner.next();
                        List<Publication> filterPublications = new ArrayList<>();
                        switch (filter) {

                            case "likes":
                                System.out.println("Ingrese la cantidad mínima de likes:");
                                int minLikes = scanner.nextInt();
                                filterPublications = Filters.filterByLikes(profile.getPublications(), minLikes);
                                break;

                            case "duration":
                                System.out.println("Ingrese la duración máxima en segundos:");
                                int maxDuration = scanner.nextInt();
                                filterPublications = Filters.filterByDuration(profile.getPublications(), maxDuration);
                                break;

                            case "uploaddate":
                                System.out.println("Ingrese una fecha inicial(dd/MM/yyyy):");
                                String dateStringMin = scanner.next();
                                Date uploadDateMin;
                                try {
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                    uploadDateMin = dateFormat.parse(dateStringMin);
                                } catch (ParseException e) {
                                    System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
                                    break;
                                }


                                System.out.println("Ingrese una fecha final(dd/MM/yyyy):");
                                String dateStringMax = scanner.next();
                                Date uploadDateMax;
                                try {
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                    uploadDateMax = dateFormat.parse(dateStringMax);
                                } catch (ParseException e) {
                                    System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
                                    break;
                                }

                                filterPublications = Filters.filterByUploadDate(profile.getPublications(), uploadDateMin, uploadDateMax);
                                break;

                            case "hashtags":
                                System.out.println("Ingrese el hashtag:");
                                String hashtag = scanner.next();
                                filterPublications = Filters.filterByHashtag(profile.getPublications(), hashtag);
                                if(filterPublications.isEmpty())
                                    System.out.println("No existe publicaciones con ese hashtag");
                                break;

                            default:
                                System.out.println("Filtro de búsqueda inválido.");
                                filterPublications = profile.getPublications();
                                break;
                        }
                        for (Publication publication : filterPublications){
                            System.out.println(publication.getPublicationName());
                        }
                        break;

                    case 3:
                        System.out.println(profile.getPublications().toString());
                        break;
                    case 4:
                        Publication publiToSearch;
                        String namePubliToSearch;
                        profile.showPublicationsAudio();
                        profile.showPublicationsVideo();
                        System.out.println("Ingrese nombre de Publicacion que quiere reproducir (SOLO AUDIO/VIDEO)");
                        scanner = new Scanner(System.in);
                        namePubliToSearch = scanner.nextLine();
                        publiToSearch = profile.searchPubliByName(profile.getPublications(),namePubliToSearch);

                        if(publiToSearch != null) {

                            boolean PlayButton = false;

                            if (publiToSearch instanceof Video) {

                                System.out.println("Ingrese 0 si quiere que se reproduzca el video desde el principio o una cantidad de segundos para avanzar y reproducir desde allí");
                                int Seconds = scanner.nextInt();
                                if(Seconds < 0)
                                    System.out.println("Ingresó un valor invalido para la publicacion");
                                else {
                                    if (Seconds > 0 && (Seconds < ((Video) publiToSearch).getDuration())) {
                                        ((Video) publiToSearch).Foward(Seconds, PlayButton, publiToSearch);
                                        ((Video) publiToSearch).Play(PlayButton, Seconds, publiToSearch);
                                    } else if (Seconds == 0)
                                        ((Video) publiToSearch).Play(PlayButton, Seconds, publiToSearch);
                                    ((Video) publiToSearch).Stop(Seconds, PlayButton, publiToSearch);
                                }

                            } else if (publiToSearch instanceof Audio) {

                                System.out.println("Ingrese 0 si quiere que se reproduzca el video desde el principio o una cantidad de segundos para avanzar y reproducir desde allí");
                                int Seconds = scanner.nextInt();
                                if(Seconds < 0)
                                    System.out.println("Ingresó un valor invalido para la publicacion");
                                else{
                                    if (Seconds > 0 && (Seconds < ((Audio) publiToSearch).getDuration())) {
                                        ((Audio) publiToSearch).Foward(Seconds, PlayButton, publiToSearch);
                                        ((Audio) publiToSearch).Play(PlayButton, Seconds, publiToSearch);
                                    } else if (Seconds == 0)
                                        ((Audio) publiToSearch).Play(PlayButton, Seconds, publiToSearch);
                                    ((Audio) publiToSearch).Stop(Seconds, PlayButton, publiToSearch);
                                }

                            }else

                                System.out.println("La publicacion no es Audio/Video");

                        } else

                            System.out.println("La publicacion no existe");
                        break;
                    case 5:
                        ProfileMenu profilemenu = new ProfileMenu(profile);
                        profilemenu.displayMenu();
                        break;
                    case 6:
                        System.out.println("Cerrando sesion...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor numérico válido para la opción.");
                scanner.nextLine();
                opcion = 0;
            } catch (Exception e) {
                System.out.println("Error: Ha ocurrido una excepción.");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 6);

        scanner.close();
        System.exit(0);
    }
}
