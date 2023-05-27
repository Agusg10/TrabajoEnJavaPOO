package GUI;
import DomainClasses.InstagramProfile;
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
            System.out.println("1. Agregar Publicacion"); //de mas
            System.out.println("2. Filtrar Publicaciones");
            System.out.println("3. Mostrar Publicaciones");
            System.out.println("4. Volver");
            System.out.println("5. Cerrar sesion");

            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    //agrega publicacion
                    break;
                case 2:
                    //busca mediante filtros
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
