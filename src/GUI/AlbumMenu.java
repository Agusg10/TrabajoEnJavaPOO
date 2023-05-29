package GUI;

import DomainClasses.Album;
import DomainClasses.InstagramProfile;
import DomainClasses.Publication;

import java.util.Scanner;

/**

 The AlbumMenu class represents the user interface for the album menu of an Instagram profile.
 It allows users to manage albums and add/remove publications from albums.
 */

public class AlbumMenu {
    private InstagramProfile profile;
    private Scanner scanner;
    /**
     * Constructs an AlbumMenu object with the specified InstagramProfile.
     * @param profile the InstagramProfile object associated with the menu
     */
    public AlbumMenu(InstagramProfile profile){
        this.profile = profile;
        scanner = new Scanner(System.in);
    }
    /**
     * Displays the album menu and handles the album management process.
     * @throws InterruptedException if an interrupted exception occurs
     */
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
            System.out.println("3. Agregar Publicacion a Album");
            System.out.println("4. Eliminar Publicacion del Album");
            System.out.println("5. Volver");
            System.out.println("6. Cerrar sesion");

            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            String albumName;
            String subAlbumName;
            int opcionalbum;

            switch (opcion) {
                case 1:
                    profile.showAlbumsAndSubAlbums();
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
                            profile.showAlbumsAndSubAlbums();
                            System.out.print("Ingrese el nombre del álbum al que quiere agregar: ");
                            albumName = scanner.nextLine();
                            if(profile.searchAlbumByName(profile.getAlbums(), albumName) == null){
                                System.out.println("Album no existe");
                            } else{
                                System.out.print("Ingrese el nombre del SubAlbum que quiere agregar: ");
                                subAlbumName = scanner.nextLine();
                                profile.addSubalbumToAlbum(albumName,subAlbumName);
                            }
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 2:
                    profile.showAlbumsAndSubAlbums();
                    System.out.println("Ingrese el nombre del album a eliminar: ");
                    scanner.nextLine();
                    albumName = scanner.nextLine();
                    profile.deleteAlbum(albumName);
                    break;
                case 3:
                    try {
                        profile.showPublications();
                        System.out.print("Ingrese el número de la publicación que desea agregar a los álbumes: ");
                        int publicationNumber = scanner.nextInt();
                        scanner.nextLine();

                        Publication selectedPublication = profile.getPublications().get(publicationNumber - 1);

                        profile.showAlbums();
                        System.out.print("Ingrese el nombre del álbum al que desea agregar la publicación: ");
                        albumName = scanner.nextLine();

                        Album selectedAlbum = profile.searchAlbumByName(profile.getAlbums(), albumName);

                        if (selectedAlbum != null) {
                            profile.showSubAlbums(selectedAlbum, "-");

                            System.out.print("Ingrese el nombre del subálbum al que desea agregar la publicación (deje vacío para agregar al álbum principal): ");
                            subAlbumName = scanner.nextLine();

                            Album targetAlbum;
                            if (subAlbumName.isEmpty()) {
                                targetAlbum = selectedAlbum;
                            } else {
                                Album subAlbum = profile.searchAlbumByName(selectedAlbum.getSubAlbums(), subAlbumName);

                                if (subAlbum != null) {
                                    targetAlbum = subAlbum;
                                } else {
                                    System.out.println("El subálbum no existe.");
                                    break;
                                }
                            }
                            targetAlbum.addPubli(selectedPublication);

                            System.out.println("La publicación se ha agregado con éxito al álbum.");
                        } else {
                            System.out.println("El álbum no existe.");
                        }
                    } catch (Exception e) {
                        System.out.println("Se produjo un error al procesar la opción. Por favor, intentelo nuevamente.");
                        scanner.nextLine(); // Limpiar el búfer del escáner
                    }
                    break;
                case 4:
                    try {
                        profile.showAlbums();
                        System.out.print("Ingrese el nombre del álbum: ");
                        String clean = scanner.nextLine();
                        albumName = scanner.nextLine();

                        // Buscar el álbum principal y sus subálbumes
                        Album selectedAlbum = profile.searchAlbumByName(profile.getAlbums(), albumName);

                        if (selectedAlbum != null) {

                            System.out.println("¿Desea sacar la publicación del álbum principal o de uno de sus subálbumes?");
                            System.out.println("1. Álbum principal");
                            System.out.println("2. Subálbum");
                            System.out.print("Opción: ");
                            int option = Integer.parseInt(scanner.nextLine());

                            if (option == 1) {

                                selectedAlbum.showPublicationsAlbum();
                                System.out.print("Ingrese el nombre de la publicación que desea sacar del álbum: ");
                                String publicationName = scanner.nextLine();
                                Publication selectedPublication = profile.searchPubliByName(selectedAlbum.getPublications(), publicationName);

                                if (selectedPublication != null) {
                                    selectedAlbum.deletePubli(selectedPublication);
                                    System.out.println("La publicación se ha sacado del álbum principal exitosamente.");
                                } else {
                                    System.out.println("La publicación no existe en el álbum principal.");
                                }
                            } else if (option == 2) {

                                System.out.println("Subálbumes disponibles:");
                                profile.showSubAlbums(selectedAlbum, "- ");
                                System.out.print("Ingrese el nombre del subálbum: ");
                                subAlbumName = scanner.nextLine();
                                Album selectedSubAlbum = profile.searchAlbumByName(selectedAlbum.getSubAlbums(), subAlbumName);

                                if (selectedSubAlbum != null) {
                                    if (selectedSubAlbum.getPublications() != null && !selectedSubAlbum.getPublications().isEmpty()) {
                                        selectedSubAlbum.showPublicationsAlbum();
                                        System.out.print("Ingrese el nombre de la publicación que desea sacar del subálbum: ");
                                        String publicationName = scanner.nextLine();
                                        Publication selectedPublication = profile.searchPubliByName(selectedSubAlbum.getPublications(), publicationName);

                                        if (selectedPublication != null) {
                                            selectedSubAlbum.deletePubli(selectedPublication);
                                            System.out.println("La publicación se ha sacado del subálbum exitosamente.");
                                        } else {
                                            System.out.println("La publicación no existe en el subálbum.");
                                        }
                                    } else {
                                        System.out.println("El subálbum está vacío. No se pueden eliminar publicaciones.");
                                    }
                                } else {
                                    System.out.println("El subálbum no existe en el álbum principal.");
                                }
                            } else {
                                System.out.println("Opción inválida.");
                            }
                        } else {
                            System.out.println("El álbum no existe.");
                        }
                    } catch (Exception e) {
                        System.out.println("Se produjo un error al procesar la opción. Por favor, inténtelo nuevamente.");
                        scanner.nextLine(); // Limpiar el búfer del escáner
                    }
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
        } while (opcion != 6);
        System.exit(0);
    }
}
