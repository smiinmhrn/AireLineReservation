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
                    changePass();
                    break label;
                case "2":
                    search();
                    break label;
                case "3":
                    bookingTicket();
                    break label;
                case "4":
                    ticketCancellation();
                    break label;
                case "5":
                    bookedTickets(1);
                    break label;
                case "6":
                    addCharge(1);
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
    private void changePass (){

        System.out.println(Appearance.BLUE + "[ CHANGE PASSWORD PANEL ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + "Enter your new password :" + Appearance.TEXT_ITALIC);
        String password = input.next();

        passengerActions.changPassword(username,password);
        System.out.println(Appearance.GREEN + "Password change successfully" + Appearance.RESET_COLOR);
        if (TEMPLATE.backToMenu("Passenger" , "Changing").equals("1")) passengerMenu();
        else changePass();
    }
    private void search() {

        passengerActions.printAllLines();
        System.out.println(Appearance.BLUE + "[ SEARCHING PANEL ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + "With which statement you want to search :");
        System.out.println("1. FlightId   2. Origin   3. Distinction   4. Date   5. Time   6. Price   7. Seats");
        String choice = input.next();

        label :
        while (true) {
            switch (choice) {
                case "1" :
                    System.out.println(Appearance.TEXT_ITALIC + "Type the Flight id :" + Appearance.TEXT_ITALIC);
                    if (!passengerActions.searchByFlightId(input.next()))
                        System.out.println(Appearance.GREEN + "Search without results !" + Appearance.RESET_COLOR);
                    break label;

                case "2" :
                    System.out.println(Appearance.TEXT_ITALIC + "Type the Origin :" + Appearance.TEXT_ITALIC);
                    if (passengerActions.searchByOrigin(input.next()))
                        System.out.println(Appearance.GREEN + "Search without results !" + Appearance.RESET_COLOR);
                    break label;
                case "3" :
                    System.out.println(Appearance.TEXT_ITALIC + "Type the Distinction :" + Appearance.TEXT_ITALIC);
                    if (passengerActions.searchByDestination(input.next()))
                        System.out.println(Appearance.GREEN + "Search without results !" + Appearance.RESET_COLOR);
                    break label;
                case "4" :
                    System.out.println(Appearance.TEXT_ITALIC + "Type the Date :" + Appearance.TEXT_ITALIC);
                    if (passengerActions.searchByDate(TEMPLATE.dateTemplate()))
                        System.out.println(Appearance.GREEN + "Search without results !" + Appearance.RESET_COLOR);
                    break label;
                case "5" :
                    System.out.println(Appearance.TEXT_ITALIC + "Type the Time :" + Appearance.TEXT_ITALIC);
                    if (passengerActions.searchByTime(TEMPLATE.timeTemplate()))
                        System.out.println(Appearance.GREEN + "Search without results !" + Appearance.RESET_COLOR);
                    break label;
                case "6" :
                    searchByPrice();
                    break label;
                case "7" :
                    System.out.println(Appearance.TEXT_ITALIC + "Type the Seats :" + Appearance.TEXT_ITALIC);
                    if (passengerActions.searchBySeats(input.next()))
                        System.out.println(Appearance.GREEN + "Search without results !" + Appearance.RESET_COLOR);
                    break label;
                default:
                    System.out.println(Appearance.RED + "Wrong command! Try again :" + Appearance.RED);
                    choice = input.next();
            }
        }
        if (TEMPLATE.backToMenu("Passenger" , "Searching").equals("1")) passengerMenu();
        else search();
    }
    private void searchByPrice() {

        System.out.println(Appearance.TEXT_ITALIC + "Type the price should lower than :");
        int lower = Integer.parseInt(TEMPLATE.availableInput(input.next()));
        System.out.println("Type the price should upper than :");
        int upper = Integer.parseInt(TEMPLATE.availableInput(input.next()));

        if (!passengerActions.searchByPrice(lower,upper))
            System.out.println(Appearance.GREEN + "Search without results !" + Appearance.RESET_COLOR);

        if (TEMPLATE.backToMenu("Passenger" , "Searching").equals("1")) passengerMenu();
        else search();
    }
    private void bookingTicket() {

        passengerActions.printAllLines();

        System.out.println(Appearance.BLUE + "[ BOOKING TICKET PANEL ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + "Enter the Flight id which you want to buy :");
        String flightId = input.next();

        int result;
        while (true) {
            result = passengerActions.existFlightId(flightId);
            if (result != -1) break;
            else {
                System.out.println(Appearance.RED + "This Flight id dos not exist! Try again :" + Appearance.RESET_COLOR);
                flightId = input.next();
            }
        }
        int prosses = 1 ;

        if (passengerActions.availableSeat(result)){
            prosses = 0 ;
            System.out.println("This airline is full ! try again with another airline");
        }

        if (prosses !=0) {
            while (true){
                if (passengerActions.isPriceEnough(username,result)) break;
                else {
                    System.out.println(Appearance.RED + "Not enough money for buying! Charge your account" + Appearance.RESET_COLOR);
                    addCharge(0);
                }
            }

            String ticketId = passengerActions.creatingTicketId(username,flightId);

            passengerActions.addNewTicket(new Tickets(username,flightId,ticketId));
            passengerActions.booked(result,username);

            System.out.println(Appearance.GREEN + "Booking ticket done successfully! Your ticket id is : " + ticketId
                    + Appearance.RESET_STYLE + Appearance.RESET_COLOR);
            System.out.println("Your ticket information is :");
            passengerActions.printSingleLine(result);
        }

        if (TEMPLATE.backToMenu("passenger" , "booking").equals("1")) passengerMenu();
        else bookingTicket();
    }
    private void addCharge(int nextStep) {

        System.out.println(Appearance.BLUE + "[ ADD CHARGE PANEL ]" + Appearance.RESET_COLOR);
        System.out.println("Your total charge is : " + passengerActions.gettingCharge(username));
        System.out.println(Appearance.TEXT_ITALIC + "How much do you want to charge :" + Appearance.RESET_STYLE);
        String chargeAmount = TEMPLATE.availableInput(input.next());
        passengerActions.addCharge(username,chargeAmount);

        if (nextStep == 1){
            if(TEMPLATE.backToMenu("Passenger" , "Charging").equals("1")) passengerMenu();
            else addCharge(nextStep);
        }
    }
    private boolean bookedTickets(int nextStep) {

        if (nextStep == 1) System.out.println(Appearance.BLUE + "[ BOOKED TICKETS PANEL ]" + Appearance.RESET_COLOR);

        if (passengerActions.EverBooked(username)) {
            System.out.println(Appearance.TEXT_ITALIC + "Your Tickets are :");
            passengerActions.printTickets(username);
            if (nextStep == 1){
                if(TEMPLATE.backToMenu("Passenger" , "Showing ticket library").equals("1")) passengerMenu();
                else addCharge(nextStep);
            }
            return true;
        }
        else System.out.println("You have not purchased any tickets yet !" + Appearance.RESET_STYLE);
        if (nextStep == 1){
            if(TEMPLATE.backToMenu("Passenger" , "Showing ticket library").equals("1")) passengerMenu();
            else addCharge(nextStep);
        }
        return false;
    }
    private void ticketCancellation() {

        System.out.println(Appearance.BLUE + "[ TICKET CANCELLATION PANEL ]" + Appearance.RESET_COLOR);
        if (bookedTickets(0)) {

            System.out.println(Appearance.TEXT_ITALIC + "Enter the Ticket Id to cancel :" + Appearance.RESET_STYLE);
            String ticketId = input.next();

            while (true){
                if (passengerActions.searchTicket(username,ticketId) == null){
                    System.out.println(Appearance.RED + "This Ticket id dos not exist! Try again :" + Appearance.RESET_COLOR);
                    ticketId = input.next();
                }else break;
            }
            passengerActions.ticketCancellation(username,ticketId);
            passengerActions.unBooked(passengerActions.getIndexOfFlightId(username,ticketId),username);
            System.out.println(Appearance.GREEN + "Ticket cancel successfully !" + Appearance.RESET_COLOR);
        }

        if (TEMPLATE.backToMenu("Passenger" , "Cancelling").equals("1")) passengerMenu();
        else ticketCancellation();
    }
}
