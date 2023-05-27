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
            System.out.println("1. Filtros Visuales y Reproduccion de videos y audios");
            System.out.println("2. Filtrar Publicaciones por atributos");
            System.out.println("3. Mostrar Publicaciones");
            System.out.println("4. Volver");
            System.out.println("5. Cerrar sesion");

            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Seleccione una opcion");
                    System.out.println("1. Filtro de caracteres");
                    System.out.println("2. Filtro de fuente");
                    System.out.println("3. Filtro de tamaño de fuente");
                    System.out.println("4. Reproduccion de videos y audios");
                    int opcion2 =scanner.nextInt();
                    List<Publication> Publications = profile.getPublications();
                    switch (opcion2) {
                        //Aplica filtro de caracteres(Funciona)
                        case 1:
                            for (Publication publicacion : Publications) {
                                if (publicacion instanceof Image) {
                                    ((Image) publicacion).CharacterRange(publicacion);
                                } else if (publicacion instanceof Video) {
                                    ((Video)publicacion).CharacterRange(publicacion);
                                }
                            }
                        break;
                        //Aplica filtro de fuente(no puede verse el cambio por consola, estaba tratando de hacerlo en una ventana)
                        case 2:
                            for (Publication publicacion : Publications) {
                                if (publicacion instanceof Image) {
                                ((Image) publicacion).ChangeFont(publicacion);
                                } else if (publicacion instanceof Video) {
                                    ((Video)publicacion).ChangeFont(publicacion);
                                }
                            }
                            break;
                        case 3:
                            // Mismo caso que el 2
                            for (Publication publicacion : Publications) {
                                if (publicacion instanceof Image) {
                                    ((Image) publicacion).Fontsize(publicacion);
                                } else if (publicacion instanceof Video) {
                                    ((Video)publicacion).Fontsize(publicacion);
                                }
                            }
                        break;
                        case 4:
                            boolean PlayButton=false;
                            for (Publication publication: Publications){
                                if (publication instanceof Video){
                                    System.out.println("Ingrese 0 si quiere que se reproduzca el video desde el principio o una cantidad de segundos para avanzar y reproducir desde allí");
                                    int Seconds= scanner.nextInt();
                                    if (Seconds>0 && Seconds<((Video) publication).getDuration()){
                                        ((Video) publication).Foward(Seconds, PlayButton, publication);
                                        ((Video) publication).Play(PlayButton, Seconds, publication);
                                        ((Video) publication).Stop(Seconds,PlayButton,publication);
                                    } else if (Seconds==0) {
                                        ((Video) publication).Play(PlayButton, Seconds, publication);
                                        ((Video) publication).Stop(Seconds, PlayButton, publication);
                                    }else
                                        System.out.println("Ingresó un valor invalido para la publicacion o un valor negativo");
                                }else if(publication instanceof Audio){
                                    System.out.println("Ingrese 0 si quiere que se reproduzca el video desde el principio o una cantidad de segundos para avanzar y reproducir desde allí");
                                    int Seconds= scanner.nextInt();
                                    if (Seconds!=0){
                                        ((Audio) publication).Foward(Seconds, PlayButton, publication);
                                        ((Audio) publication).Play(PlayButton, Seconds, publication);
                                    } else
                                        ((Audio) publication).Play(PlayButton,Seconds,publication);
                                    ((Audio) publication).Stop(Seconds,PlayButton,publication);
                                }
                            }
                        break;
                    }
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
                    ProfileMenu profilemenu = new ProfileMenu(profile);
                    profilemenu.displayMenu();
                    break;
                case 5:
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
