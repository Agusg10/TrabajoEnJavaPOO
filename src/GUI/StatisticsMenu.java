package GUI;

import DomainClasses.InstagramProfile;

import java.util.Scanner;

public class StatisticsMenu {
    private InstagramProfile prof;
    private Scanner scanner;

    public StatisticsMenu(InstagramProfile prof) {
        this.prof = prof;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {

        System.out.println("#################################");
        System.out.println("|                               |");
        System.out.println("|      MENU DE ESTADISTICAS     |");
        System.out.println("|                               |");
        System.out.println("#################################");

        boolean back = false;
        do {
            System.out.println("Seleccione una opción de estadística:");
            System.out.println("1. Estadísticas de Likes");
            System.out.println("2. Estadísticas de Publicaciones");
            System.out.println("3. Volver");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    prof.showLikesStatistics(prof.getPublications());
                    break;
                case 2:
                    prof.showPublicationsStatistics(prof.getPublications());
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }while(!back);
    }
}

