import appearance.Appearance;
import java.util.Scanner;
public class Admin {
    Scanner input = new Scanner(System.in);
    private final Template TEMPLATE;
    private final AdminActions ADMIN_ACTIONS;
    public Admin(Template TEMPLATE, AdminActions ADMIN_ACTIONS) {
        this.TEMPLATE = TEMPLATE;
        this.ADMIN_ACTIONS = ADMIN_ACTIONS;
    }
    // this function is for handling admin menu
    public void adminMenu() {
        System.out.println(Appearance.BLUE + "[ ADMIN MENU OPTIONS ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC +  """
            1. Add
            2. Update
            3. Remove
            4. Flight schedules
            0. Sign out
            Choose :\s""" +  Appearance.RESET_STYLE);

        String choice = input.next();
        label :
        while (true) {
            switch (TEMPLATE.availableInput(choice)) {
                case "1" :
                    add();
                    break label;
                case "2" :
                    break label;
                case "3" :
                    remove();
                    break label;
                case "4" :
                    break label;
                case "0" :
                    break label;
                default :
                    System.out.println(Appearance.RED + "Wrong command! Try again :" + Appearance.RESET_COLOR);
                    choice = input.next();
            }
        }
    }
    // this function is for adding new airline
    private void add() {

        System.out.println(Appearance.BLUE + "[ ADDING PANEL ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + "Enter Flight id :");
        String flightId = input.next().toUpperCase();

        System.out.println("Enter Origin :");
        String origin = TEMPLATE.templateStringStyle(input.next());

        System.out.println("Enter Destination :");
        String destination = TEMPLATE.templateStringStyle(input.next());

        System.out.println("Date :");
        String date = TEMPLATE.dateTemplate();

        System.out.println("Time :");
        String time = TEMPLATE.timeTemplate();

        System.out.println("Enter Price :");
        String price = TEMPLATE.availableInput(input.next());

        System.out.println("Enter Seats :" + Appearance.RESET_STYLE);
        String seats = TEMPLATE.availableInput(input.next());

        ADMIN_ACTIONS.addNewAirline(new Flights(flightId , origin , destination , date , time , price , seats));
        System.out.println(Appearance.GREEN + "Adding new airline successfully !" + Appearance.RESET_COLOR);

//        if (MAIN_MENU.backToMenu("Admin" , "Adding").equals("1")) adminMenu();
//        else add();
    }
    // this function is for removing a single airline
    private void remove() {

        System.out.println(Appearance.BLUE + "[ REMOVE PANEL ]" + Appearance.RESET_COLOR);
        ADMIN_ACTIONS.printAllAirlines();

        System.out.println(Appearance.TEXT_ITALIC + "Type the Flight Id that you want to remove :" + Appearance.RESET_STYLE);

        ADMIN_ACTIONS.removeAirline(ADMIN_ACTIONS.searchByFlightId(existsFlightId(input.next())));
        System.out.println(Appearance.GREEN + "Removing airline successfully !" + Appearance.RESET_COLOR);

//        if (MAIN_MENU.backToMenu("Admin" , "Removing").equals("1")) adminMenu();
//        else remove();
    }
    /**
     * @param id => this function is for checking if the id is exists in airline or not
     * @return => and return an available id
     */
    private String existsFlightId(String id) {
        while (true) {
            if (ADMIN_ACTIONS.searchByFlightId(id) == -1) {
                System.out.println(Appearance.RED + "This Flight id dos not exist! Try again :" + Appearance.RESET_COLOR);
                id = input.next();
            } else break;
        } return id;
    }
}
