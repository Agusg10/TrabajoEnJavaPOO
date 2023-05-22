package GUI;

import DomainClasses.InstagramProfile;

import java.util.Scanner;

public class AlbumMenu {
    private InstagramProfile profile;
    private Scanner scanner;

    public AlbumMenu(InstagramProfile profile){
        this.profile = profile;
        scanner = new Scanner(System.in);
    }

    public void displayMenu(){

        System.out.println("#################################");
        System.out.println("|                               |");
        System.out.println("|        MENU DE ALBUMES        |");
        System.out.println("|                               |");
        System.out.println("#################################");

        int opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar Album");
            System.out.println("2. Eliminar Album");
            System.out.println("3. Volver");
            System.out.println("4. Cerrar sesion");

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
                    ProfileMenu profilemenu = new ProfileMenu(profile);
                    profilemenu.displayMenu();
                    break;
                case 4:
                    System.out.println("Cerrando sesion...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 4);
        System.exit(0);
    }
}
