public interface CanAdminActions {
    void addAirlines(Flights flights);
    void printAllAirLine();
    void printSingleAirLine(int index);
    int searchByFlightId(String shouldSearch);
    void updateFlightId(String toUpdate , int index);
    void updateOrigin(String toUpdate , int index);
    void updateDestination(String toUpdate , int index);
    void updateDate(String toUpdate , int index);
    void updateTime(String toUpdate , int index);
    void updatePrice(String toUpdate , int index);
    void updateSeats(String toUpdate , int index);
    void removeAirLine(int index);
}

