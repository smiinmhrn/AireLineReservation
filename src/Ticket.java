import java.util.ArrayList;
import java.util.List;
public class Ticket {
    private static final List<Tickets> TICKETS_LIST = new ArrayList<>();
    public void buyNewTicket(Tickets tickets) {
        TICKETS_LIST.add(tickets);
    }
    public void ticketCancellation(Tickets tickets){
        TICKETS_LIST.remove(tickets);
    }
    public Tickets searchTicketByHavingTicketId(String username , String ticketId){
        for (Tickets tickets : TICKETS_LIST) {
            if (tickets.getUsername().equals(username)) {
                if (tickets.getTicketId().equals(ticketId)) return tickets;
            }
        }
        return null;
    }
    public String getFlightIdByHavingTicketId(String username , String ticketId){
        return searchTicketByHavingTicketId(username,ticketId).getFlightId();
    }
    public boolean existTicketId(String username , String ticketId) {
        return searchTicketByHavingTicketId(username, ticketId) != null;
    }
    public String creatTicketId(String username , String flightId) {
        String ticketId = username + flightId;
        while (true){
            if (existTicketId(username , ticketId)){
                ticketId = ticketId + "#";
            } else break;
        } return ticketId;
    }
    public void printAllUserTickets(String username) {
        for (Tickets tickets : TICKETS_LIST) {
            if (tickets.getUsername().equals(username)) {
                System.out.println(tickets.getTicketId());
            }
        }
    }
    public boolean haveEverBooked(String username) {
        for (Tickets tickets : TICKETS_LIST)
            if (tickets.getUsername().equals(username)) return true;
        return false;
    }
}
