public class PassengerActions {
    private CanPassengerActions passengerActions;
    private CanPassengerUser canPassengerUser;
    private Ticket ticket;
    public PassengerActions(CanPassengerActions passengerActions, CanPassengerUser canPassengerUser, Ticket ticket) {
        this.passengerActions = passengerActions;
        this.canPassengerUser = canPassengerUser;
        this.ticket = ticket;
    }
    public void changPassword(String username, String newPassword) {
        canPassengerUser.changePass(username,newPassword);
    }
    public boolean searchByFlightId(String shouldSearch) {
        int index = passengerActions.searchByFlightId(shouldSearch);
        if (index != -1){
            printSingleLine(index);
            return true;
        }return false;
    }
    public boolean searchByOrigin(String shouldSearch) {
        int index = passengerActions.searchByOrigin(shouldSearch);
        return index != -1;
    }
    public boolean searchByDestination(String shouldSearch) {
        int index = passengerActions.searchByDestination(shouldSearch);
        return index != -1;
    }
    public boolean searchByDate(String shouldSearch) {
        int index = passengerActions.searchByDate(shouldSearch);
        return index != -1;
    }
    public boolean searchByTime(String shouldSearch) {
        int index = passengerActions.searchByTime(shouldSearch);
        return index != -1;
    }
    public boolean searchByPrice(int lower, int upper) {
        int index = passengerActions.searchByPrice(lower, upper);
        return index != -1;
    }
    public boolean searchBySeats(String shouldSearch) {
        int index = passengerActions.searchBySeats(shouldSearch);
        return index != -1;
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
    public int getIndexOfFlightId(String username, String ticketId){
        return existFlightId(ticket.getFlightIdByHavingTicketId(username,ticketId));
    }
    public String getPrice(int index) {
        return passengerActions.getPrice(index);
    }
    public boolean isPriceEnough(String username, int index) {
        return canPassengerUser.isEnough(getPrice(index), username);
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
        ticket.ticketCancellation(searchTicket(username,ticketId));
    }
    public Tickets searchTicket(String username, String ticketId) {
        return ticket.searchTicketByHavingTicketId(username,ticketId);
    }
    public void addCharge(String username, String chargeAmount) {
        canPassengerUser.increaseCharge(username, chargeAmount);
    }
    public boolean availableSeat(int index) {
        return passengerActions.availableSeats(index);
    }
    private void increaseSeat(int index) {
        passengerActions.increaseSeats(index);
    }
    private void decreaseSeat(int index) {
        passengerActions.decreaseSeats(index);
    }
    private void decreaseCharges(String username , String chargeAmount) {
        canPassengerUser.decreaseCharge(username,chargeAmount);
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
        return canPassengerUser.getCharge(username);
    }
    public boolean EverBooked(String username) {
        return ticket.haveEverBooked(username);
    }
}
