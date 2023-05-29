package GUI;

import DomainClasses.InstagramProfile;
import DomainClasses.Publication;
import DomainClasses.*;

import java.util.Scanner;

public class FiltersMenu {
    private InstagramProfile profile;
    private Scanner scanner;

    public FiltersMenu(InstagramProfile profile) {
        this.profile = profile;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() throws InterruptedException {

        System.out.println("#################################");
        System.out.println("|                               |");
        System.out.println("|        MENU DE FILTROS        |");
        System.out.println("|                               |");
        System.out.println("#################################");

        int opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Filtro de Texto");
            System.out.println("2. Filtro de Imagen");
            System.out.println("3. Filtro de Video");
            System.out.println("4. Volver");
            System.out.println("Opcion: ");
            opcion = scanner.nextInt();
            Publication publiToSearch;
            String namePubliToSearch;

            switch(opcion){
                case 1:
                    profile.showPublicationsText();
                    System.out.println("Ingrese nombre de Texto que quiere aplicar Filtro");
                    scanner = new Scanner(System.in);
                    namePubliToSearch = scanner.nextLine();
                    publiToSearch = profile.searchPubliByName(profile.getPublications(),namePubliToSearch);
                    if(publiToSearch != null){
                        if(publiToSearch instanceof Text){
                            ((Text) publiToSearch).Filter();
                        }else
                            System.out.println(publiToSearch.getPublicationName()+" No es de tipo Texto");
                    }else
                        System.out.println("La publicacion " + namePubliToSearch + " no existe");
                    break;
                case 2:
                    profile.showPublicationsImage();
                    System.out.println("Ingrese nombre de Imagen que quiere aplicar Filtro");
                    scanner = new Scanner(System.in);
                    namePubliToSearch = scanner.nextLine();
                    publiToSearch = profile.searchPubliByName(profile.getPublications(),namePubliToSearch);
                    if(publiToSearch != null){
                        if(publiToSearch instanceof Image){
                            ((Image) publiToSearch).Filter();
                        }else
                            System.out.println(publiToSearch.getPublicationName()+" No es de tipo Imagen");
                    }else
                        System.out.println("La publicacion " + namePubliToSearch + " no existe");
                    break;
                case 3:
                    profile.showPublicationsVideo();
                    System.out.println("Ingrese nombre de Video que quiere aplicar Filtro");
                    scanner = new Scanner(System.in);
                    namePubliToSearch = scanner.nextLine();
                    publiToSearch = profile.searchPubliByName(profile.getPublications(),namePubliToSearch);
                    if(publiToSearch != null){
                        if(publiToSearch instanceof Video){
                            ((Video) publiToSearch).Filter();
                        }else
                            System.out.println(publiToSearch.getPublicationName()+" No es de tipo Video");
                    }else
                        System.out.println("La publicacion " + namePubliToSearch + " no existe");
                    break;

                case 4:
                    PublicationMenu publicationMenu = new PublicationMenu(profile);
                    publicationMenu.displayMenu();
                    break;
            }
        } while (opcion != 4);
        System.exit(0);
    }
}
