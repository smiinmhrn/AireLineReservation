import appearance.Appearance;
import java.util.Scanner;
public class RegisterMenu {
    private final NewingClasses newClasses;
    Scanner input = new Scanner(System.in);

    public RegisterMenu(NewingClasses newClasses) {
        this.newClasses = newClasses;
    }

    public void adminSighIn() {

        newClasses.getRegister().addAdminAccount(new Users("samin" , "samin228" , "0"));
        System.out.println(Appearance.BLUE + "[ ADMIN SIGN IN PANEL ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + "Enter your username :"  + Appearance.RESET_STYLE );
        String username = input.next();

        while (true) {
            if (newClasses.getRegister().searchAdminName(username) != null) {
                break;
            }else {
                System.out.println(Appearance.RED + "Wrong username! Try again :" + Appearance.RESET_COLOR);
                username = input.next();
            }
        }

        System.out.println(Appearance.TEXT_ITALIC + "Enter your password :"  + Appearance.RESET_STYLE );
        String password = input.next();
        while (true){
            if (newClasses.getRegister().searchAdminPassword(password , "samin")){
                var admin = new Admin(new Templates(),new AdminActions(newClasses.getFLIGHT()),newClasses);
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
            if (newClasses.getRegister().searchPassengerName(username) != null || username.equals("samin")) {
                System.out.println(Appearance.RED + "This username is already exist. Try another one :" + Appearance.RESET_COLOR);
                username = input.next();
            }else break;
        }
        System.out.println("Enter your password :" + Appearance.RESET_STYLE);
        String password = input.next();
        newClasses.getRegister().addPassengerAccount(new Users(username,password,"0"));
        var passenger = new Passenger(username,
                new Templates(),new PassengerActions(newClasses.getFLIGHT(),newClasses.getUSER(), newClasses.getTICKET()),newClasses);
        passenger.passengerMenu();
    }
    public void passengerSighIn() {

        System.out.println(Appearance.BLUE + "[ PASSENGER SIGN IN PANEL ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + "Enter your username :");
        String username = input.next();

        while (true) {
            if (newClasses.getRegister().searchPassengerName(username) == null || username.equals("samin")) {
                System.out.println(Appearance.RED + "This username isn't exist. Try another one :" + Appearance.RESET_COLOR);
                username = input.next();
            }else break;
        }

        System.out.println("Enter your password :");
        String password = input.next();
        while (true){
            if (newClasses.getRegister().searchPassengerPassword(password,username)){
                var passenger = new Passenger(username,
                        new Templates(),new PassengerActions(newClasses.getFLIGHT(),newClasses.getUSER(), newClasses.getTICKET()),newClasses);
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
