public class AdminActions {
    private final CanAdminActions CAN_ADMIN_ACTIONS;
    public AdminActions(CanAdminActions adminActions) {
        this.CAN_ADMIN_ACTIONS = adminActions;
    }
    public void addNewAirline(Flights flights) {
        CAN_ADMIN_ACTIONS.addAirlines(flights);
    }
    public void removeAirline(int index) {
        CAN_ADMIN_ACTIONS.removeAirLine(index);
    }
    public void printAllAirlines() {
        CAN_ADMIN_ACTIONS.printAllAirLine();
    }
    public void printSingleAirline(int index) {
        CAN_ADMIN_ACTIONS.printSingleAirLine(index);
    }
    public int searchByFlightId(String shouldSearch) {
        return CAN_ADMIN_ACTIONS.searchByFlightId(shouldSearch);
    }
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
