// this class is for get filed of class and creat getter for them
public class Tickets {
    private final String USERNAME;
    private final String FLIGHT_ID;
    private final String TICKET_ID;
    public Tickets(String username, String flightId, String ticketId) {
        this.USERNAME = username;
        this.FLIGHT_ID = flightId;
        this.TICKET_ID = ticketId;
    }
    public String getUSERNAME() {
        return USERNAME;
    }
    public String getFLIGHT_ID() {
        return FLIGHT_ID;
    }
    public String getTICKET_ID() {
        return TICKET_ID;
    }
}
