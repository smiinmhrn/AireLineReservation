public class AdminActions extends User {
    private CanAdminActions adminActions;
    public AdminActions(CanAdminActions adminActions) {
        this.adminActions = adminActions;
    }
    public void addNewAirline(Flights flights) {
        adminActions.addAirlines(flights);
    }
    public void removeAirline(int index) {
        adminActions.removeAirLine(index);
    }
    public void printAllAirlines() {
        adminActions.printAllAirLine();
    }
    public void printSingleAirline(int index) {
        adminActions.printSingleAirLine(index);
    }
    public int searchByFlightId(String shouldSearch) {
        return adminActions.searchByFlightId(shouldSearch);
    }
    public void updatingOrigin(String shouldUpdateWith , int index) {
        adminActions.updateOrigin(shouldUpdateWith , index);
    }
    public void updatingDestination(String shouldUpdateWith , int index) {
        adminActions.updateDestination(shouldUpdateWith , index);
    }
    public void updatingDate(String shouldUpdateWith , int index) {
        adminActions.updateDate(shouldUpdateWith , index);
    }
    public void updatingTime(String shouldUpdateWith , int index) {
        adminActions.updateTime(shouldUpdateWith , index);
    }
    public void updatingPrice(String shouldUpdateWith , int index) {
        adminActions.updatePrice(shouldUpdateWith , index);
    }
    public void updatingSeats(String shouldUpdateWith , int index) {
        adminActions.updateSeats(shouldUpdateWith , index);
    }
}
