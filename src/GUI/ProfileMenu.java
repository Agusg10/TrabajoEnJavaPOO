package GUI;
import DomainClasses.*;

import java.util.Scanner;

public class ProfileMenu{
    private InstagramProfile prof;
    private Scanner scanner;

    public ProfileMenu(InstagramProfile profile){
        this.prof = profile;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() throws InterruptedException {

        System.out.println("################################");
        System.out.println("|                              |");
        System.out.println("|    BIENVENIDO " + prof.getUser() + "      |");
        System.out.println("|                              |");
        System.out.println("################################");

        int opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ver Perfil");
            System.out.println("2. Abrir Menu Publicaciones");
            System.out.println("3. Abrir Menu Albumes");
            System.out.println("4. Mostrar Estadisticas");
            System.out.println("5. Generar Reportes");
            System.out.println("6. Cerrar Sesión");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Mostrando perfil...");
                    System.out.println(prof.toString());
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
                    System.out.println("Muestra Estadisticas...");
                    prof.MakeStatistics(prof.getPublications());
                    break;
                case 5:
                    System.out.println("Genera Reportes...");
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
        } while (opcion != 6);
        System.exit(0);
    }
}
