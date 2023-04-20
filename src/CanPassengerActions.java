public interface CanPassengerActions {
    void printAllAirLine();
    void printSingleAirLine(int index);
    int searchByFlightId(String shouldSearch);
    int searchByOrigin(String shouldSearch);
    int searchByDestination(String shouldSearch);
    int searchByDate(String shouldSearch);
    int searchByTime(String shouldSearch);
    int searchByPrice(int lower, int upper);
    int searchBySeats(String shouldSearch);
    String getPrice(int index);
    boolean availableSeats(int index);
    void increaseSeats(int index);
    void decreaseSeats(int index);

}
