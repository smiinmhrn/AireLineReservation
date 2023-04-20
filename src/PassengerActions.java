public class PassengerActions {
    private final CanPassengerActions PASSENGER_ACTIONS;
    private final CanPassengerUser PASSENGER_USER;
    private final Ticket TICKET;
    public PassengerActions(CanPassengerActions passengerActions, CanPassengerUser canPassengerUser, Ticket ticket) {
        this.PASSENGER_ACTIONS = passengerActions;
        this.PASSENGER_USER = canPassengerUser;
        this.TICKET = ticket;
    }
    public void changPassword(String username, String newPassword) {
        PASSENGER_USER.changePass(username,newPassword);
    }
    public boolean searchByFlightId(String shouldSearch) {
        int index = PASSENGER_ACTIONS.searchByFlightId(shouldSearch);
        if (index != -1){
            printSingleLine(index);
            return true;
        }return false;
    }
    public boolean searchByOrigin(String shouldSearch) {
        int index = PASSENGER_ACTIONS.searchByOrigin(shouldSearch);
        return index == 0;
    }
    public boolean searchByDestination(String shouldSearch) {
        int index = PASSENGER_ACTIONS.searchByDestination(shouldSearch);
        return index == 0;
    }
    public boolean searchByDate(String shouldSearch) {
        int index = PASSENGER_ACTIONS.searchByDate(shouldSearch);
        return index == 0;
    }
    public boolean searchByTime(String shouldSearch) {
        int index = PASSENGER_ACTIONS.searchByTime(shouldSearch);
        return index == 0;
    }
    public boolean searchByPrice(int lower, int upper) {
        int index = PASSENGER_ACTIONS.searchByPrice(lower, upper);
        return index == 0;
    }
    public boolean searchBySeats(String shouldSearch) {
        int index = PASSENGER_ACTIONS.searchBySeats(shouldSearch);
        return index == 0;
    }
    public void printAllLines() {
        PASSENGER_ACTIONS.printAllAirLine();
    }
    public void printSingleLine(int index) {
        PASSENGER_ACTIONS.printSingleAirLine(index);
    }
    public int existFlightId(String shouldSearch) {
        return PASSENGER_ACTIONS.searchByFlightId(shouldSearch);
    }
    public int getIndexOfFlightId(String username, String ticketId){
        return existFlightId(TICKET.getFlightIdByHavingTicketId(username,ticketId));
    }
    private String getPrice(int index) {
        return PASSENGER_ACTIONS.getPrice(index);
    }
    public boolean isPriceEnough(String username, int index) {
        return PASSENGER_USER.isEnough(getPrice(index), username);
    }
    public String creatingTicketId(String username, String flightId) {
        return TICKET.creatTicketId(username,flightId);
    }
    public void addNewTicket(Tickets tickets) {
        TICKET.buyNewTicket(tickets);
    }
    public void printTickets(String username) {
        TICKET.printAllUserTickets(username);
    }
    public void ticketCancellation(String username, String ticketId) {
        TICKET.ticketCancellation(searchTicket(username,ticketId));
    }
    public Tickets searchTicket(String username, String ticketId) {
        return TICKET.searchTicketByHavingTicketId(username,ticketId);
    }
    public void addCharge(String username, String chargeAmount) {
        PASSENGER_USER.increaseCharge(username, chargeAmount);
    }
    public boolean availableSeat(int index) {
        return PASSENGER_ACTIONS.availableSeats(index);
    }
    private void increaseSeat(int index) {
        PASSENGER_ACTIONS.increaseSeats(index);
    }
    private void decreaseSeat(int index) {
        PASSENGER_ACTIONS.decreaseSeats(index);
    }
    private void decreaseCharges(String username , String chargeAmount) {
        PASSENGER_USER.decreaseCharge(username,chargeAmount);
    }
    public void booked(int index , String username) {
        decreaseSeat(index);
        String price = getPrice(index);
        decreaseCharges(username,price);
    }
    public void unBooked(int index, String username){
        increaseSeat(index);
        String price = getPrice(index);
        addCharge(username,price);
    }
    public String gettingCharge(String username){
        return PASSENGER_USER.getCharge(username);
    }
    public boolean EverBooked(String username) {
        return TICKET.haveEverBooked(username);
    }
}
