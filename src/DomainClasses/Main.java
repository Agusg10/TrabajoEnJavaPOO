package DomainClasses;

import GUI.LoginMenu;
import GUI.ProfileMenu;
import XML.ClassXML;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        InstagramProfile prof = ClassXML.loadXML();
        LoginMenu login = new LoginMenu(prof);
        login.displayMenu();
        ProfileMenu profilemenu = new ProfileMenu(prof);
        profilemenu.displayMenu();

    }
}
