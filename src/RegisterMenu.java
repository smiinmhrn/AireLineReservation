import appearance.Appearance;
import java.util.Scanner;
public class RegisterMenu {
    private final Register REGISTER;
    Scanner input = new Scanner(System.in);
    public RegisterMenu(Register register) {
        this.REGISTER = register;
    }
    public void adminSighIn() {

        REGISTER.addAdminAccount(new Users("samin" , "samin228" , "0"));
        System.out.println(Appearance.BLUE + "[ ADMIN SIGN IN PANEL ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + "Enter your username :"  + Appearance.RESET_STYLE );
        String username = input.next();

        while (true) {
            if (REGISTER.searchAdminName(username) != null) {
                break;
            }else {
                System.out.println(Appearance.RED + "Wrong username! Try again :" + Appearance.RESET_COLOR);
                username = input.next();
            }
        }

        System.out.println(Appearance.TEXT_ITALIC + "Enter your password :"  + Appearance.RESET_STYLE );
        String password = input.next();
        while (true){
            if (REGISTER.searchAdminPassword(password , "samin")){
                var admin = new Admin(new Template(),new AdminActions(new Flight()));
                admin.adminMenu();
                break;
            }else {
                System.out.println(Appearance.RED + "Wrong password! Try again :"+ Appearance.RESET_COLOR);
                password = input.next();
            }
        }
    }
    public void passengerSignUp() {

        System.out.println(Appearance.BLUE + "[ SIGN UP PANEL ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + "Enter your username :");
        String username = input.next();

        while (true) {
            if (REGISTER.searchPassengerName(username) != null || username.equals("samin")) {
                System.out.println(Appearance.RED + "This username is already exist. Try another one :" + Appearance.RESET_COLOR);
                username = input.next();
            }else break;
        }
        System.out.println("Enter your password :" + Appearance.RESET_STYLE);
        String password = input.next();
        REGISTER.addPassengerAccount(new Users(username,password,"0"));
        var passenger = new Passenger(username,password,
                new Template(),new PassengerActions(new Flight(),new User(),new Ticket()));
        passenger.passengerMenu();
    }
    public void passengerSighIn() {

        System.out.println(Appearance.BLUE + "[ PASSENGER SIGN IN PANEL ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + "Enter your username :");
        String username = input.next();

        while (true) {
            if (REGISTER.searchPassengerName(username) == null || username.equals("samin")) {
                System.out.println(Appearance.RED + "This username isn't exist. Try another one :" + Appearance.RESET_COLOR);
                username = input.next();
            }else break;
        }

        System.out.println("Enter your password :");
        String password = input.next();
        while (true){
            if (REGISTER.searchPassengerPassword(password,username)){
                var passenger = new Passenger(username,password,
                        new Template(),new PassengerActions(new Flight(),new User(),new Ticket()));
                passenger.passengerMenu();
                break;
            }
            else {
                System.out.println(Appearance.RED + "Wrong password! Try again" + Appearance.RESET_COLOR + Appearance.RESET_STYLE);
                password = input.next();
            }
        }
    }
}
