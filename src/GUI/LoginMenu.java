package GUI;
import DomainClasses.*;
import java.util.*;

/**

 The LoginMenu class represents the user interface for the login menu of an Instagram profile.
 It allows users to log in by entering their username and password.
 */

public class LoginMenu {
    private InstagramProfile profile;
    private Scanner scanner;
    private String user;
    private String pass;
    /**
     * Constructs a LoginMenu object with the specified InstagramProfile.
     * @param profile the InstagramProfile object associated with the menu
     */
    public LoginMenu(InstagramProfile profile){
        this.profile = profile;
        scanner = new Scanner(System.in);
    }
    /**
     * Displays the login menu and handles the user login process.
     * @throws InterruptedException if an interrupted exception occurs
     */
    public void displayMenu() throws InterruptedException{
        System.out.println("#################################");
        System.out.println("|                               |");
        System.out.println("|             LOGIN             |");
        System.out.println("|                               |");
        System.out.println("#################################");
        System.out.println("Ingrese Usuario: ");
        user = scanner.nextLine();
        while(!user.equals(profile.getUser())){
            System.out.println("Usuario Incorrecto, intente nuevamente: ");
            user = scanner.nextLine();
        }
        System.out.println("Ingrese Contraseña: ");
        pass = scanner.nextLine();
        while(!pass.equals(profile.getPassword())){
            System.out.println("Contraseña Incorrecta, intente nuevamente: ");
            pass = scanner.nextLine();
        }
        System.out.println("LOGEADO...");
    }
}
