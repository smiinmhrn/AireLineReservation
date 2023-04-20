import appearance.Appearance;
import java.util.Scanner;
// this class has responsible for showing register menu => sign in and sign up
public class RegisterMenu {
    private final NewingClasses NEWING_CLASSES;
    Scanner input = new Scanner(System.in);
    public RegisterMenu(NewingClasses newClasses) {
        this.NEWING_CLASSES = newClasses;
    }
    // this function use for showing admin sign in menu and register admin
    public void adminSighIn() {

        NEWING_CLASSES.getRegister().addAdminAccount(new Users("samin", "samin228", "0"));

        System.out.println(Appearance.BLUE + "[ ADMIN SIGN IN PANEL ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + "Enter your username :"  + Appearance.RESET_STYLE );
        String username = input.next();

        while (true) {
            if (NEWING_CLASSES.getRegister().searchAdminName(username) != null) {
                break;
            } else {
                System.out.println(Appearance.RED + "Wrong username! Try again :" + Appearance.RESET_COLOR);
                username = input.next();
            }
        }

        System.out.println(Appearance.TEXT_ITALIC + "Enter your password :"  + Appearance.RESET_STYLE );
        String password = input.next();

        while (true){
            if (NEWING_CLASSES.getRegister().searchAdminPassword(password , "samin")){
                var admin = new Admin(new Templates(), new AdminActions(NEWING_CLASSES.getFLIGHT()), NEWING_CLASSES);
                admin.adminMenu();
                break;
            } else {
                System.out.println(Appearance.RED + "Wrong password! Try again :"+ Appearance.RESET_COLOR);
                password = input.next();
            }
        }
    }
    // this function use for showing passenger sign in menu and register passenger
    public void passengerSighIn() {

        System.out.println(Appearance.BLUE + "[ PASSENGER SIGN IN PANEL ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + "Enter your username :");
        String username = input.next();

        while (true) {
            if (NEWING_CLASSES.getRegister().searchPassengerName(username) == null || username.equals("samin")) {
                System.out.println(Appearance.RED +
                        "This username isn't exist. Try another one :" + Appearance.RESET_COLOR);
                username = input.next();
            } else break;
        }

        System.out.println("Enter your password :");
        String password = input.next();

        while (true){
            if (NEWING_CLASSES.getRegister().searchPassengerPassword(password, username)){
                var passenger = new Passenger(username, new Templates(), new PassengerActions(
                        NEWING_CLASSES.getFLIGHT(), NEWING_CLASSES.getUSER(), NEWING_CLASSES.getTICKET())
                        ,NEWING_CLASSES);

                passenger.passengerMenu();
                break;
            }
            else {
                System.out.println(Appearance.RED +
                        "Wrong password! Try again" + Appearance.RESET_COLOR + Appearance.RESET_STYLE);
                password = input.next();
            }
        }
    }
    // this function use for showing passenger sign up menu and register passenger
    public void passengerSignUp() {

        System.out.println(Appearance.BLUE + "[ SIGN UP PANEL ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + "Enter your username :");
        String username = input.next();

        while (true) {
            if (NEWING_CLASSES.getRegister().searchPassengerName(username) != null || username.equals("samin")) {
                System.out.println(Appearance.RED +
                        "This username is already exist. Try another one :" + Appearance.RESET_COLOR);
                username = input.next();
            } else break;
        }

        System.out.println("Enter your password :" + Appearance.RESET_STYLE);
        String password = input.next();

        NEWING_CLASSES.getRegister().addPassengerAccount(new Users(username, password,"0"));

        var passenger = new Passenger(username, new Templates(), new PassengerActions(
                NEWING_CLASSES.getFLIGHT(), NEWING_CLASSES.getUSER(), NEWING_CLASSES.getTICKET()), NEWING_CLASSES);
        passenger.passengerMenu();
    }
}
