public class AdminActions {
    private final CanAdminActions ADMIN_ACTIONS;
    public AdminActions(CanAdminActions adminActions) {
        this.ADMIN_ACTIONS = adminActions;
    }
    public void addNewAirline(Flights flights) {
        ADMIN_ACTIONS.addAirlines(flights);
    }
    public void removeAirline(int index) {
        ADMIN_ACTIONS.removeAirLine(index);
    }
    public void printAllAirlines() {
        ADMIN_ACTIONS.printAllAirLine();
    }
    public void printSingleAirline(int index) {
        ADMIN_ACTIONS.printSingleAirLine(index);
    }
    public int searchByFlightId(String shouldSearch) {
        return ADMIN_ACTIONS.searchByFlightId(shouldSearch);
    }
    public void updatingFLightId(String shouldUpdateWith , int index) {
        ADMIN_ACTIONS.updateFlightId(shouldUpdateWith , index);
    }
    public void updatingOrigin(String shouldUpdateWith , int index) {
        ADMIN_ACTIONS.updateOrigin(shouldUpdateWith , index);
    }
    public void updatingDestination(String shouldUpdateWith , int index) {
        ADMIN_ACTIONS.updateDestination(shouldUpdateWith , index);
    }
    public void updatingDate(String shouldUpdateWith , int index) {
        ADMIN_ACTIONS.updateDate(shouldUpdateWith , index);
    }
    public void updatingTime(String shouldUpdateWith , int index) {
        ADMIN_ACTIONS.updateTime(shouldUpdateWith , index);
    }
    public void updatingPrice(String shouldUpdateWith , int index) {
        ADMIN_ACTIONS.updatePrice(shouldUpdateWith , index);
    }
    public void updatingSeats(String shouldUpdateWith , int index) {
        ADMIN_ACTIONS.updateSeats(shouldUpdateWith , index);
    }
}
