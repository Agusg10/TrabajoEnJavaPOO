package GUI;
import DomainClasses.*;
import java.util.*;

public class LoginMenu {
    private InstagramProfile profile;
    private Scanner scanner;
    private String user;
    private String pass;
    public LoginMenu(InstagramProfile profile){
        this.profile = profile;
        scanner = new Scanner(System.in);
    }

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
