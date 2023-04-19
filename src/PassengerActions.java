public class PassengerActions extends User{
    private CanPassengerActions passengerActions;
    private Ticket ticket;
    public PassengerActions(CanPassengerActions passengerActions, Ticket ticket) {
        this.passengerActions = passengerActions;
        this.ticket = ticket;
    }
    public void changPassword(String username, String newPassword) {
        changePass(username,newPassword);
    }
    public void searchByFlightId(String shouldSearch) {
        int index = passengerActions.searchByFlightId(shouldSearch);
        if (index != -1) passengerActions.printSingleAirLine(index);
    }
    public void searchByOrigin(String shouldSearch) {
        int index = passengerActions.searchByOrigin(shouldSearch);
        if (index != -1) passengerActions.printSingleAirLine(index);
    }
    public void searchByDestination(String shouldSearch) {
        int index = passengerActions.searchByDestination(shouldSearch);
        if (index != -1) passengerActions.printSingleAirLine(index);
    }
    public void searchByDate(String shouldSearch) {
        int index = passengerActions.searchByDate(shouldSearch);
        if (index != -1) passengerActions.printSingleAirLine(index);
    }
    public void searchByTime(String shouldSearch) {
        int index = passengerActions.searchByTime(shouldSearch);
        if (index != -1) passengerActions.printSingleAirLine(index);
    }
    public void searchByPrice(int lower, int upper) {
        int index = passengerActions.searchByPrice(lower, upper);
        if (index != -1) passengerActions.printSingleAirLine(index);
    }
    public void searchBySeats(String shouldSearch) {
        int index = passengerActions.searchBySeats(shouldSearch);
        if (index != -1) passengerActions.printSingleAirLine(index);
    }
    public void printAllLines() {
        passengerActions.printAllAirLine();
    }
    public void printSingleLine(int index) {
        passengerActions.printSingleAirLine(index);
    }
    public int existFlightId(String shouldSearch) {
        return passengerActions.searchByFlightId(shouldSearch);
    }
    public String getPrice(int index) {
        return passengerActions.getPrice(index);
    }
    public boolean isPriceEnough(String username, int index) {
        return isEnough(getPrice(index), username);
    }
    public String creatingTicketId(String username, String flightId) {
        return ticket.creatTicketId(username,flightId);
    }
    public void addNewTicket(Tickets tickets) {
        ticket.buyNewTicket(tickets);
    }
    public void printTickets(String username) {
        ticket.printAllUserTickets(username);
    }
    public void ticketCancellation(String username, String ticketId) {
        ticket.ticketCancellation(ticket.searchTicketByHavingTicketId(username,ticketId));
    }
    public void addCharge(String username, String chargeAmount) {
        increaseCharge(username, chargeAmount);
    }
    public boolean availableSeat(int index) {
        return passengerActions.availableSeats(index);
    }
    public void increaseSeat(int index) {
        passengerActions.increaseSeats(index);
    }
    public void decreaseSeat(int index) {
        passengerActions.decreaseSeats(index);
    }
}
