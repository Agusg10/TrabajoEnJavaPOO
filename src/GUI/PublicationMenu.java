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
    public void displayMenu(){

        System.out.println("#################################");
        System.out.println("|                               |");
        System.out.println("|     MENU DE PUBLICACIONES     |");
        System.out.println("|                               |");
        System.out.println("#################################");

        int opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Filtro Visual");
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
                    int opcion2 =scanner.nextInt();
                    List<Publication> Publicaciones = profile.getPublications();
                    switch (opcion2) {
                        //Aplica filtro de caracteres(Funciona)
                        case 1:
                            for (Publication publicacion : Publicaciones) {
                                if (publicacion instanceof Image) {
                                    ((Image) publicacion).CharacterRange(publicacion);
                                } else if (publicacion instanceof Video) {
                                    ((Video)publicacion).CharacterRange(publicacion);
                                }
                            }
                        break;
                        //Aplica filtro de fuente(no puede verse el cambio por consola, estaba tratando de hacerlo en una ventana)
                        case 2:
                            for (Publication publicacion : Publicaciones) {
                                if (publicacion instanceof Image) {
                                ((Image) publicacion).ChangeFont(publicacion);
                                } else if (publicacion instanceof Video) {
                                    ((Video)publicacion).ChangeFont(publicacion);
                                }
                            }
                            break;
                        case 3:
                            // Mismo caso que el 2
                            for (Publication publicacion : Publicaciones) {
                                if (publicacion instanceof Image) {
                                    ((Image) publicacion).Fontsize(publicacion);
                                } else if (publicacion instanceof Video) {
                                    ((Video)publicacion).Fontsize(publicacion);
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
                    Scanner sc=new Scanner(System.in);
                    String FilterName=sc.next();
                    List<Publication> filterPublications;
                    switch (FilterName){
                        case "Likes":filterPublications = filters.filterPublications("Likes", "100");
                        break;
                        case "Duration":filterPublications = filters.filterPublications("Duration", "20");
                        break;
                        case "uploadDate":filterPublications = filters.filterPublications("uploadDate", "28/7/2023");// es el unico filtro que no funciona, creo que es por como se almacena el tipo date
                        break;
                        case "Hashtags":filterPublications = filters.filterPublications("Hashtags", "Music");
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
