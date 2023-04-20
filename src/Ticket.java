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
            if (tickets.getUSERNAME().equals(username)) {
                if (tickets.getTICKET_ID().equals(ticketId)) return tickets;
            }
        }
        return null;
    }
    public boolean searchFlightId(String flightId) {
        for (Tickets tickets : TICKETS_LIST)
            if (tickets.getFLIGHT_ID().equals(flightId)) return true;
        return false;
    }
    public String getFlightIdByHavingTicketId(String username , String ticketId){
        return searchTicketByHavingTicketId(username,ticketId).getFLIGHT_ID();
    }
    private boolean existTicketId(String username , String ticketId) {
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
            if (tickets.getUSERNAME().equals(username)) {
                System.out.println(tickets.getTICKET_ID());
            }
        }
    }
    public boolean haveEverBooked(String username) {
        for (Tickets tickets : TICKETS_LIST)
            if (tickets.getUSERNAME().equals(username)) return true;
        return false;
    }
}
