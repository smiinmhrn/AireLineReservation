public class Tickets {
    private String username;
    private String flightId;
    private String ticketId;
    public Tickets(String username, String flightId, String ticketId) {
        this.username = username;
        this.flightId = flightId;
        this.ticketId = ticketId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFlightId() {
        return flightId;
    }
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
    public String getTicketId() {
        return ticketId;
    }
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
