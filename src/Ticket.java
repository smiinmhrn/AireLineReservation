import java.util.ArrayList;
import java.util.List;
// this class has responsible for does everything about ticket
public class Ticket {
    private final List<Tickets> TICKETS_LIST = new ArrayList<>();
    // this function use for adding new ticket
    public void buyNewTicket(Tickets tickets) {
        TICKETS_LIST.add(tickets);
    }
    // this function use for removing exists ticket
    public void ticketCancellation(Tickets tickets){
        TICKETS_LIST.remove(tickets);
    }
    // this function use for searching ticket by having ticket id
    // return address of ticket if it exists or return null if it doesn't
    public Tickets searchTicketByHavingTicketId(String username, String ticketId){
        for (Tickets tickets : TICKETS_LIST) {
            if (tickets.getUSERNAME().equals(username))
                if (tickets.getTICKET_ID().equals(ticketId)) return tickets;
        }
        return null;
    }
    // this function use for searching flight id
    // return true if it exists or return false if it doesn't
    public boolean searchFlightId(String flightId) {
        for (Tickets tickets : TICKETS_LIST)
            if (tickets.getFLIGHT_ID().equals(flightId)) return true;
        return false;
    }
    // this function use for getting flight id by having ticket id
    public String getFlightIdByHavingTicketId(String username, String ticketId){
        return searchTicketByHavingTicketId(username, ticketId).getFLIGHT_ID();
    }
    // this function use for showing if ticket id exist or not
    private boolean existTicketId(String username, String ticketId) {
        return searchTicketByHavingTicketId(username, ticketId) != null;
    }
    // this function use for crating uniq ticket id
    public String creatTicketId(String username, String flightId) {
        String ticketId = username + flightId;

        while (true){
            if (existTicketId(username, ticketId)) ticketId = ticketId + "#";
            else break;
        } return ticketId;
    }
    // this function use for print all user ticket id
    public void printAllUserTickets(String username) {
        for (Tickets tickets : TICKETS_LIST)
            if (tickets.getUSERNAME().equals(username)) System.out.println(tickets.getTICKET_ID());
    }
    // this function use for showing if user ever booked ticket or not
    // return true if user have or return false if user haven't
    public boolean haveEverBooked(String username) {
        for (Tickets tickets : TICKETS_LIST)
            if (tickets.getUSERNAME().equals(username)) return true;
        return false;
    }
}
