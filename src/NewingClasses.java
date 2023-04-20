// this class use for newing classes which we want to new them only once and pass objects
public class NewingClasses {
    private final Flight FLIGHT = new Flight();
    private final User USER = new User();
    private final Ticket TICKET = new Ticket();
    private final Register register = new Register(USER);
    public Register getRegister() {
        return register;
    }
    public Flight getFLIGHT() {
        return FLIGHT;
    }
    public User getUSER() {
        return USER;
    }
    public Ticket getTICKET() {
        return TICKET;
    }

}
