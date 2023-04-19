import java.util.Scanner;
import appearance.Appearance;
public class MainMenu {
    Scanner input = new Scanner(System.in);
    private final Template TEMPLATE;
    public MainMenu(Template TEMPLATE) {
        this.TEMPLATE = TEMPLATE;
    }
    public void mainMenu() {

        System.out.println(Appearance.BLUE + "[ WELCOME TO AIRLINE RESERVATION SYSTEM ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + """
            1. Sign in
            2. Sign up
            Choose : \s""" + Appearance.RESET_STYLE);

        String choice = input.next();
        label :
        while (true){
            switch (TEMPLATE.availableInput(choice)) {
                case "1" :
                    signInAs();
                    break label;
                case "2" :
                    var register = new RegisterMenu(new Register());
                    register.passengerSignUp();
                    break label;
                default:
                    System.out.println(Appearance.RED + "Wrong command! Try again :" + Appearance.RESET_COLOR);
                    choice = input.next();
            }
        }
    }
    // a menu which give yo to option => sign in as admin or sign in as passenger
    private void signInAs() {
        System.out.println(Appearance.BLUE + "[ SIGN IN PANEL ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + """
            1. Sign in as Admin
            2. Sign in as Passenger
            Choose :\s""" );

        String choice = input.next();
        var register = new RegisterMenu(new Register());
        label :
        while (true){
            switch (TEMPLATE.availableInput(choice)){
                case "1":
                    register.adminSighIn();
                    break label;
                case "2":
                    register.passengerSighIn();
                    break label;
                default:
                    System.out.println(Appearance.RED + "Wrong command! Try again :" + Appearance.RESET_STYLE + Appearance.RESET_COLOR);
                    choice = input.next();
            }
        }
    }
}
