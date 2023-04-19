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
                    update();
                    break label;
                case "3" :
                    remove();
                    break label;
                case "4" :
                    showingFlightSchedules();
                    break label;
                case "0" :
                    var mainMenu = new MainMenu(new Template());
                    mainMenu.mainMenu();
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

        if (TEMPLATE.backToMenu("Adding" , "Admin").equals("1")) adminMenu();
        else add();
    }
    // this function is for removing a single airline
    private void remove() {

        System.out.println(Appearance.BLUE + "[ REMOVE PANEL ]" + Appearance.RESET_COLOR);
        ADMIN_ACTIONS.printAllAirlines();

        System.out.println(Appearance.TEXT_ITALIC + "Type the Flight Id that you want to remove :" + Appearance.RESET_STYLE);

        ADMIN_ACTIONS.removeAirline(ADMIN_ACTIONS.searchByFlightId(existsFlightId(input.next())));
        System.out.println(Appearance.GREEN + "Removing airline successfully !" + Appearance.RESET_COLOR);

        if (TEMPLATE.backToMenu("Removing" , "Admin").equals("1")) adminMenu();
        else remove();
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
    // this function and next function are for updating an airline
    private void update() {

        System.out.println(Appearance.BLUE + "[ UPDATING PANEL ]" + Appearance.RESET_COLOR);
        ADMIN_ACTIONS.printAllAirlines();

        System.out.println(Appearance.TEXT_ITALIC + "Type the Flight id you want to update :" + Appearance.RESET_STYLE);

        String flight = existsFlightId(input.next());
        updateInProgress(ADMIN_ACTIONS.searchByFlightId(flight));

        if (TEMPLATE.backToMenu("Updating" , "Admin").equals("1")) adminMenu();
        else update();
    }
    /**
     * @param result => in previous function admin search for a flight id which he/she wanted to update and search
     *               for this id and save the index of it . this function use this index to show that single airline
     *               and update that special airline
     */
    private void updateInProgress(int result) {

        ADMIN_ACTIONS.printSingleAirline(result);

        System.out.println(Appearance.TEXT_ITALIC + """
            Which statement you want to change :
            1. FlightId   2. Origin   3. Distinction   4. Date   5. Time   6. Price   7. Seats\s""" );

        String choice = input.next();
        label :
        while (true) {
            switch (TEMPLATE.availableInput(choice)) {

                case "1" :
                    System.out.println("Enter your new Flight Id :");
                    String id = input.next().toUpperCase();
                    while (true) {
                        if (ADMIN_ACTIONS.searchByFlightId(id) != -1) {
                            System.out.println(Appearance.RED + "This Flight id dos exist! Try again :" + Appearance.RESET_COLOR);
                            id = input.next().toUpperCase();
                        } else break;
                    }
                    ADMIN_ACTIONS.updatingFLightId(id, result);
                    break label;

                case "2" :
                    System.out.println("Enter your new Origin :");
                    String origin = TEMPLATE.templateStringStyle(input.next());

                    ADMIN_ACTIONS.updatingOrigin(origin , result);
                    break label;

                case "3" :
                    System.out.println("Enter your new Destination :");
                    String destination = TEMPLATE.templateStringStyle(input.next());
                    ADMIN_ACTIONS.updatingDestination(destination , result);
                    break label;

                case "4" :
                    ADMIN_ACTIONS.updatingDate(TEMPLATE.dateTemplate() , result);
                    break label;

                case "5" :
                    ADMIN_ACTIONS.updatingTime(TEMPLATE.timeTemplate() , result);
                    break label;

                case "6" :
                    System.out.println("Enter your new Price :");
                    ADMIN_ACTIONS.updatingPrice(TEMPLATE.availableInput(input.next()) , result);
                    break label;

                case "7" :
                    System.out.println("Enter your new Seats :");
                    ADMIN_ACTIONS.updatingSeats(TEMPLATE.availableInput(input.next()) , result);
                    break label;

                default :
                    System.out.println(Appearance.RED + "Wrong command! Try again :" + Appearance.RESET_COLOR);
                    choice = input.next();
            }
        }
        System.out.println(Appearance.GREEN + "Updating airline successfully !" + Appearance.RESET_COLOR);
        System.out.println("""
            1. Keep updating this airline
            2. Skip\s""" );

        String secondChoice = input.next();
        label :
        while (true) {
            switch (TEMPLATE.availableInput(secondChoice)) {
                case "1":
                    updateInProgress(result);
                    break label ;
                case "2" :
                    break label;
                default :
                    System.out.println(Appearance.RED + "Wrong command! Try again :"+ Appearance.RESET_COLOR + Appearance.RESET_STYLE);
                    secondChoice = input.next();
            }
        }
    }
    // this function is for showing all airlines
    private void showingFlightSchedules() {
        System.out.println(Appearance.BLUE + " [ AIRLINE SCHEDULES ] " + Appearance.RESET_COLOR);
        ADMIN_ACTIONS.printAllAirlines();
        if (TEMPLATE.backToMenu("Showing airline list" , "Admin").equals("1")) adminMenu();
        else showingFlightSchedules();
    }
//    public void adminSighIn() {
//
//        ADMIN_ACTIONS.addAdminAccount(new Users("samin" , "samin228" , "0"));
//        System.out.println(Appearance.BLUE + "[ ADMIN SIGN IN PANEL ]" + Appearance.RESET_COLOR);
//        System.out.println(Appearance.TEXT_ITALIC + "Enter your username :"  + Appearance.RESET_STYLE );
//        String username = input.next();
//
//        while (true) {
//            if (ADMIN_ACTIONS.searchAdminName(username) != null) {
//                break;
//            }else {
//                System.out.println(Appearance.RED + "Wrong username! Try again :" + Appearance.RESET_COLOR);
//                username = input.next();
//            }
//        }
//
//        System.out.println(Appearance.TEXT_ITALIC + "Enter your password :"  + Appearance.RESET_STYLE );
//        String password = input.next();
//        while (true){
//            if (ADMIN_ACTIONS.searchAdminPassword(password , "samin")){
//                adminMenu();
//                break;
//            }else {
//                System.out.println(Appearance.RED + "Wrong password! Try again :"+ Appearance.RESET_COLOR);
//                password = input.next();
//            }
//        }
//    }
    /**
     * this function is for when you want to back to first menu
     * @param action => and your action in others functions
     * @return => has two options, and you can choose one of them and your choice will return to be considered
     */

}
