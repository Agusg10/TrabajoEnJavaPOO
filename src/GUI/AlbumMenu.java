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

            switch (opcion) {
                case 1:
                    int opcionalbum;
                    profile.showAlbums();
                    System.out.println("\nSeleccione lo que desea agregar:");
                    System.out.println("1. Album");
                    System.out.println("2. Subalbum");

                    System.out.print("Opción: ");
                    opcionalbum = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcionalbum) {
                        case 1:
                            System.out.print("Ingrese el nombre del álbum: ");
                            String albumName = scanner.nextLine();
                            profile.createAlbum(albumName);
                            System.out.println("Álbum agregado con éxito.");
                            break;
                        case 2: //AGREGA SUBALBUM
                            profile.showAlbums();

                            // Solicitar el nombre del álbum padre
                            System.out.print("Ingrese el nombre del álbum padre: ");
                            String parentAlbumName = scanner.nextLine();

                            // Buscar el álbum padre en la lista de álbumes
                            Album parentAlbum = profile.searchAlbumByName(profile.getAlbums(), parentAlbumName);
                            if (parentAlbum != null) {
                                // Mostrar los subálbumes disponibles del álbum padre
                                System.out.println("Subálbumes disponibles de " + parentAlbum.getAlbumName() + ":");
                                profile.showSubAlbums(parentAlbum, "- ");

                                // Solicitar el nombre del subálbum en el que se agregará el álbum
                                System.out.print("Ingrese el nombre del subálbum (deje vacío para crear uno nuevo): ");
                                String subAlbumName = scanner.nextLine();

                                Album subAlbum;
                                if (subAlbumName.isEmpty()) {
                                    // Si no se ingresa un nombre de subálbum, crear uno nuevo
                                    System.out.print("Ingrese el nombre del nuevo subálbum: ");
                                    subAlbumName = scanner.nextLine();

                                    subAlbum = new Album(subAlbumName);
                                    parentAlbum.addSubAlbum(subAlbum);
                                    System.out.println("Subálbum agregado con éxito.");
                                } else {
                                    // Buscar el subálbum en el álbum padre
                                    subAlbum = profile.searchAlbumByName(parentAlbum.getSubAlbums(), subAlbumName);
                                    if (subAlbum != null) {
                                        // Solicitar el nombre del álbum a agregar
                                        System.out.print("Ingrese el nombre del álbum: ");
                                        String albumName1 = scanner.nextLine();

                                        // Crear el álbum y agregarlo al subálbum
                                        Album album = new Album(albumName1);
                                        subAlbum.addSubAlbum(album);
                                        System.out.println("Álbum agregado con éxito.");
                                    } else {
                                        System.out.println("El subálbum no existe.");
                                    }
                                }
                            } else {
                                System.out.println("El álbum padre no existe.");
                            }
                    }
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
