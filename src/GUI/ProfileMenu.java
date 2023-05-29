package GUI;
import DomainClasses.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**

 The ProfileMenu class represents the user interface for the profile menu of an Instagram profile.
 It allows users to interact with various profile-related features and options.
 */

public class ProfileMenu{
    private InstagramProfile prof;
    private Scanner scanner;
    /**
     * Constructs a ProfileMenu object with the specified InstagramProfile.
     * @param profile the InstagramProfile object associated with the menu
     */
    public ProfileMenu(InstagramProfile profile) {
        this.prof = profile;
        scanner = new Scanner(System.in);
    }
    /**
     * Displays the profile menu and handles user input and interaction.
     */
    public void displayMenu() {
        System.out.println("################################");
        System.out.println("|                              |");
        System.out.println("|    BIENVENIDO " + prof.getUser() + "      |");
        System.out.println("|                              |");
        System.out.println("################################");

        prof.sortPublicationsAscending(prof.getPublications());
        int opcion;
        do {
            try {
                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Ver Perfil");
                System.out.println("2. Abrir Menú Publicaciones");
                System.out.println("3. Abrir Menú Álbumes");
                System.out.println("4. Mostrar Estadísticas");
                System.out.println("5. Generar Reportes");
                System.out.println("6. Cerrar Sesión");
                System.out.print("Opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Mostrando perfil...");
                        System.out.println(prof.toString());
                        System.out.println(" ");
                        prof.showPublications();
                        System.out.println(" ");
                        prof.showAlbumsAndSubAlbums();
                        break;
                    case 2:
                        PublicationMenu publimenu = new PublicationMenu(prof);
                        publimenu.displayMenu();
                        break;
                    case 3:
                        AlbumMenu albumenu = new AlbumMenu(prof);
                        albumenu.displayMenu();
                        break;
                    case 4:
                        System.out.println("Mostrando Estadísticas...");
                        // prof.makeStatistics(prof.getPublications());
                        StatisticsMenu statisticsMenu = new StatisticsMenu(prof);
                        statisticsMenu.displayMenu();
                        break;
                    case 5:
                        System.out.println("Generando Reportes...");
                        prof.PubicationReport(prof.getPublications());
                        System.out.println("\n");
                        prof.AlbumsReport(prof.getAlbums());
                        break;
                    case 6:
                        System.out.println("Cerrando sesión...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar el búfer del escáner
                opcion = 0; // Establecer una opción inválida para continuar el bucle
            } catch (InterruptedException e) {
                System.out.println("Se produjo un error al realizar una operación. Por favor, intente nuevamente.");
                opcion = 0; // Establecer una opción inválida para continuar el bucle
            }
        } while (opcion != 6);
        System.exit(0);
    }
}
