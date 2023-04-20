// this class has all admin actions methods that Admin class use these methods from this class
// also this class use some Flight class methods by using an implement of Flight class
public class AdminActions {
    private final CanAdminActions CAN_ADMIN_ACTIONS;
    public AdminActions(CanAdminActions adminActions) {
        this.CAN_ADMIN_ACTIONS = adminActions;
    }
    // this function use for add new airline
    public void addNewAirline(Flights flights) {
        CAN_ADMIN_ACTIONS.addAirlines(flights);
    }
    // this function use for remove an exists airline
    public void removeAirline(int index) {
        CAN_ADMIN_ACTIONS.removeAirLine(index);
    }
    // this function use for print all airline list
    public void printAllAirlines() {
        CAN_ADMIN_ACTIONS.printAllAirLine();
    }
    // this function use for print single airline
    public void printSingleAirline(int index) {
        CAN_ADMIN_ACTIONS.printSingleAirLine(index);
    }
    // this function use for searching in airline list with flight id and return the index of the flight address
    // having that flight id
    public int searchByFlightId(String shouldSearch) {
        return CAN_ADMIN_ACTIONS.searchByFlightId(shouldSearch);
    }
    // this function and 6 next functions use for updating flight id, origin, destination, date, time, price and seat
    public void updatingFLightId(String shouldUpdateWith, int index) {
        CAN_ADMIN_ACTIONS.updateFlightId(shouldUpdateWith, index);
    }
    public void updatingOrigin(String shouldUpdateWith, int index) {
        CAN_ADMIN_ACTIONS.updateOrigin(shouldUpdateWith, index);
    }
    public void updatingDestination(String shouldUpdateWith, int index) {
        CAN_ADMIN_ACTIONS.updateDestination(shouldUpdateWith, index);
    }
    public void updatingDate(String shouldUpdateWith, int index) {
        CAN_ADMIN_ACTIONS.updateDate(shouldUpdateWith, index);
    }
    public void updatingTime(String shouldUpdateWith, int index) {
        CAN_ADMIN_ACTIONS.updateTime(shouldUpdateWith, index);
    }
    public void updatingPrice(String shouldUpdateWith, int index) {
        CAN_ADMIN_ACTIONS.updatePrice(shouldUpdateWith, index);
    }
    public void updatingSeats(String shouldUpdateWith, int index) {
        CAN_ADMIN_ACTIONS.updateSeats(shouldUpdateWith, index);
    }
}
