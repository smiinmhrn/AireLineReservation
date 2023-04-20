// this class has all passenger actions methods that Passenger class use these methods from this class
// also this class use some Flight class methods by using an implement of Flight class
public class PassengerActions {
    private final CanPassengerActions CAN_PASSENGER_ACTIONS;
    private final CanPassengerUser CAN_PASSENGER_USER;
    private final Ticket TICKET;
    public PassengerActions(CanPassengerActions passengerActions, CanPassengerUser canPassengerUser, Ticket ticket) {
        this.CAN_PASSENGER_ACTIONS = passengerActions;
        this.CAN_PASSENGER_USER = canPassengerUser;
        this.TICKET = ticket;
    }
    // this function has the method for changing password
    public void changPassword(String username, String newPassword) {
        CAN_PASSENGER_USER.changePass(username,newPassword);
    }
    // this function use for searching flight id and return true if it exists and return false id if it is not exists
    public boolean searchByFlightId(String shouldSearch) {
        int index = CAN_PASSENGER_ACTIONS.searchByFlightId(shouldSearch);
        if (index != -1){
            printSingleLine(index);
            return true;
        }return false;
    }
    // this function and 5 next functions have the method for searching origin, destination, date, time
    // price and seat and return 0 if it is not exists and return 1 if it exists
    public boolean searchByOrigin(String shouldSearch) {
        return CAN_PASSENGER_ACTIONS.searchByOrigin(shouldSearch) == 0;
    }
    public boolean searchByDestination(String shouldSearch) {
        return CAN_PASSENGER_ACTIONS.searchByDestination(shouldSearch) == 0;
    }
    public boolean searchByDate(String shouldSearch) {
        return CAN_PASSENGER_ACTIONS.searchByDate(shouldSearch) == 0;
    }
    public boolean searchByTime(String shouldSearch) {
        return CAN_PASSENGER_ACTIONS.searchByTime(shouldSearch) == 0;
    }
    public boolean searchByPrice(int lower, int upper) {
        return CAN_PASSENGER_ACTIONS.searchByPrice(lower, upper) == 0;
    }
    public boolean searchBySeats(String shouldSearch) {
        return CAN_PASSENGER_ACTIONS.searchBySeats(shouldSearch) == 0;
    }
    // this function has the method for print all airlines
    public void printAllLines() {
        CAN_PASSENGER_ACTIONS.printAllAirLine();
    }
    // this function has the method for print single airline
    public void printSingleLine(int index) {
        CAN_PASSENGER_ACTIONS.printSingleAirLine(index);
    }
    // this function has the method for showing if the flight id exists or not and
    // return index of it if it exists and return -1 if it doesn't
    public int existFlightId(String shouldSearch) {
        return CAN_PASSENGER_ACTIONS.searchByFlightId(shouldSearch);
    }
    // this function use for get index of flight id by having ticket id
    public int getIndexOfFlightId(String username, String ticketId){
        return existFlightId(TICKET.getFlightIdByHavingTicketId(username, ticketId));
    }
    // this function use for getting price
    private String getPrice(int index) {
        return CAN_PASSENGER_ACTIONS.getPrice(index);
    }
    // this function use for showing if user has enough money for buying specific airline
    public boolean isPriceEnough(String username, int index) {
        return CAN_PASSENGER_USER.isEnough(getPrice(index), username);
    }
    // this function has the method for crating uniq ticket id
    public String creatingTicketId(String username, String flightId) {
        return TICKET.creatTicketId(username, flightId);
    }
    // this function has the method for adding new ticket
    public void addNewTicket(Tickets tickets) {
        TICKET.buyNewTicket(tickets);
    }
    // this function has the method for cancelling tickets
    public void ticketCancellation(String username, String ticketId) {
        TICKET.ticketCancellation(searchTicket(username, ticketId));
    }
    // this function has the method for printing all user ticket id
    public void printTickets(String username) {
        TICKET.printAllUserTickets(username);
    }
    // this function has the method for searching ticket
    public Tickets searchTicket(String username, String ticketId) {
        return TICKET.searchTicketByHavingTicketId(username, ticketId);
    }
    // this function has the method for increasing charge use in add charge and cancelling tickets
    public void addCharge(String username, String chargeAmount) {
        CAN_PASSENGER_USER.increaseCharge(username, chargeAmount);
    }
    // this function has the method for getting amount of charge
    public String gettingCharge(String username){
        return CAN_PASSENGER_USER.getCharge(username);
    }
    // this function has the method for showing if an airline has available seats for buying
    public boolean availableSeat(int index) {
        return CAN_PASSENGER_ACTIONS.availableSeats(index);
    }
    // this function has the method for increasing the number of seats
    private void increaseSeat(int index) {
        CAN_PASSENGER_ACTIONS.increaseSeats(index);
    }
    // this function has the method for decreasing the number of seats
    private void decreaseSeat(int index) {
        CAN_PASSENGER_ACTIONS.decreaseSeats(index);
    }
    // this function has the method for decreasing the amount of charge when user buy an airline
    private void decreaseCharges(String username, String chargeAmount) {
        CAN_PASSENGER_USER.decreaseCharge(username, chargeAmount);
    }
    // this function does the process of booking => decreasing number of seats and charge
    public void booked(int index, String username) {
        decreaseSeat(index);
        String price = getPrice(index);
        decreaseCharges(username, price);
    }
    // this function does the process of cancelling => increasing number of seats and charge
    public void unBooked(int index, String username){
        increaseSeat(index);
        String price = getPrice(index);
        addCharge(username, price);
    }
    // this function has the method for showing if user have ever bought ticket or not
    public boolean EverBooked(String username) {
        return TICKET.haveEverBooked(username);
    }
}
