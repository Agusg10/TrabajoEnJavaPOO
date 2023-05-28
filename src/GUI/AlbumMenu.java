package GUI;

import DomainClasses.Album;
import DomainClasses.InstagramProfile;

import java.util.Scanner;

public class AlbumMenu {
    private InstagramProfile profile;
    private Scanner scanner;

    public AlbumMenu(InstagramProfile profile){
        this.profile = profile;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() throws InterruptedException {

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
            String albumName;
            String subAlbumName;

            switch (opcion) {
                case 1:
                    int opcionalbum;
                    profile.showAlbums();
                    System.out.println("\nSeleccione lo que desea agregar:");
                    System.out.println("1. Album");
                    System.out.println("2. Subalbum");
                    System.out.println("3. Volver");
                    System.out.print("Opción: ");
                    opcionalbum = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcionalbum) {
                        case 1:
                            System.out.print("Ingrese el nombre del álbum: ");
                            albumName = scanner.nextLine();
                            profile.createAlbum(albumName);
                            System.out.println("Álbum agregado con éxito.");
                            break;
                        case 2: //AGREGA SUBALBUM
                            System.out.println("Albumes disponibles:");
                            profile.showAlbums();
                            System.out.print("Ingrese el nombre del álbum al que quiere agregar: ");
                            albumName = scanner.nextLine();
                            System.out.print("Ingrese el nombre del SubAlbum que quiere agregar: ");
                            subAlbumName = scanner.nextLine();
                            profile.addSubalbumToAlbum(albumName,subAlbumName);
                            break;
                        case 3: break;
                    }
                    break;
                case 2:
                    profile.showAlbums();
                    System.out.println("Ingrese el nombre del album a eliminar: ");
                    scanner.nextLine();
                    albumName = scanner.nextLine();
                    profile.deleteAlbum(albumName);
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
