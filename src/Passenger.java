import appearance.Appearance;
import java.util.Scanner;
public class Passenger {
    Scanner input = new Scanner(System.in);
    private String username;
    private String password;
    private final Template TEMPLATE;
    private final PassengerActions passengerActions;
    public Passenger(String username, String password, Template TEMPLATE, PassengerActions passengerActions) {
        this.username = username;
        this.password = password;
        this.TEMPLATE = TEMPLATE;
        this.passengerActions = passengerActions;
    }
    public void passengerMenu() {

        System.out.println(Appearance.BLUE + "[ PASSENGER MENU OPTIONS ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + """
            1. Change password
            2. Search flight ticket
            3. Booking ticket
            4. ticket cancellation
            5. Booked ticket
            6. Add Charge
            0. Sign out
            Choose :\s""" + Appearance.RESET_STYLE);

        String choice = input.next();
        label :
        while (true) {
            switch (TEMPLATE.availableInput(choice)) {
                case "1":
                    break label;
                case "2":
                    break label;
                case "3":
                    break label;
                case "4":
                    break label;
                case "5":
                    break label;
                case "6":
                    break label;
                case "0":
                    var mainMenu = new MainMenu(new Template());
                    mainMenu.mainMenu();
                    break label;
                default:
                    System.out.println(Appearance.RED + "Wrong command! Try again :" + Appearance.RESET_COLOR);
                    choice = input.next();
            }
        }
    }
}
