package DomainClasses;

import GUI.LoginMenu;
import GUI.ProfileMenu;
import XML.ClassXML;

/**
 * The {@code Main} class represents the main entry point of the program.
 * It initializes and displays the login menu and profile menu.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Load Instagram profile from XML
        InstagramProfile prof = ClassXML.loadXML();

        // Display login menu
        LoginMenu login = new LoginMenu(prof);
        login.displayMenu();

        // Display profile menu
        ProfileMenu profilemenu = new ProfileMenu(prof);
        profilemenu.displayMenu();
    }
}
