public class AdminActions extends User{
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
    public int searchByFlightID(String shouldSearch) {
        return adminActions.searchByFlightId(shouldSearch);
    }
    public void updatingOrigin(String shouldUpdateWit , int index) {
        adminActions.updateOrigin(shouldUpdateWit , index);
    }
    public void updatingDestination(String shouldUpdateWit , int index) {
        adminActions.updateDestination(shouldUpdateWit , index);
    }
    public void updatingDate(String shouldUpdateWit , int index) {
        adminActions.updateDate(shouldUpdateWit , index);
    }
    public void updatingTime(String shouldUpdateWit , int index) {
        adminActions.updateTime(shouldUpdateWit , index);
    }
    public void updatingPrice(String shouldUpdateWit , int index) {
        adminActions.updatePrice(shouldUpdateWit , index);
    }
    public void updatingSeats(String shouldUpdateWit , int index) {
        adminActions.updateSeats(shouldUpdateWit , index);
    }
}
