package GUI;
import DomainClasses.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class PublicationMenu {
    private InstagramProfile profile;
    private Scanner scanner;
    public PublicationMenu(InstagramProfile profile){
        this.profile = profile;
        scanner = new Scanner(System.in);
    }
    public void displayMenu() throws InterruptedException {

        System.out.println("#################################");
        System.out.println("|                               |");
        System.out.println("|     MENU DE PUBLICACIONES     |");
        System.out.println("|                               |");
        System.out.println("#################################");

        int opcion;
        do {
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
                    //busca mediante filtros
                    List<Publication> originalPublications = profile.getPublications();
                    List<String> attributes = List.of("Likes", "Duration", "uploadDate", "Hashtags");
                    Filters filters = new Filters(attributes, originalPublications);
                    System.out.println("Ingrese por cual de estos 4 atributos quiere filtrar, Likes, Duration, uploadDate, Hashtags");
                    String FilterName=scanner.next();
                    List<Publication> filterPublications;
                    switch (FilterName){
                        case "Likes":
                            System.out.println("Ingrese una cantidad de likes y se mostrarán las publicaciones que superen ese número");
                            String LikesNumber=scanner.next();
                            filterPublications = filters.filterPublications("Likes", LikesNumber);
                        break;
                        case "Duration":
                            System.out.println("Ingrese una Duracion en segundos y se mostrarán las publicaciones que superen ese número");
                            String Seconds=scanner.next();
                            filterPublications = filters.filterPublications("Duration", Seconds);
                        break;
                        case "uploadDate":
                            System.out.println("Ingrese una fecha y se mostrarám las publicaciones correspondientes a esa fecha");
                            String FilterDate=scanner.next();
                            filterPublications = filters.filterPublications("uploadDate", "28/7/2023");// es el unico filtro que no funciona, creo que es por como se almacena el tipo date
                        break;
                        case "Hashtags":
                            System.out.println("Ingrese un Hashtag y se mostrarán las publicaciones que tengan dicho Hashtag");
                            String HashtagFilter=scanner.next();
                            filterPublications = filters.filterPublications("Hashtags", HashtagFilter);
                        break;
                        default:filterPublications=originalPublications;
                    }
                    for (Publication publication : filterPublications) {
                        System.out.println(publication);
                    }
                    break;
                case 3:
                    System.out.println(profile.getPublications().toString());
                    break;
                case 4:
                    Publication publiToSearch;
                    String namePubliToSearch;
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
        } while (opcion != 5);
        System.exit(0);
    }
}
