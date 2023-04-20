import java.util.ArrayList;
import java.util.List;
public class Flight implements CanAdminActions , CanPassengerActions {
    // this class is responsible for doing some actions in airline list
    private final List<Flights> FLIGHTS_LIST = new ArrayList<>();
    // this function is for adding new airline
    @Override
    public void addAirlines(Flights flights) { FLIGHTS_LIST.add(flights); }
    // this function is for removing new airline
    @Override
    public void removeAirLine(int index){
        FLIGHTS_LIST.remove(index);
    }
    // this function is for searching flight id and return the index of its address and if it dost exist return -1
    @Override
    public int searchByFlightId(String shouldSearch) {
        for (int i = 1; i < FLIGHTS_LIST.size(); i++) {
            if (FLIGHTS_LIST.get(i).getFlightId().equals(shouldSearch.toUpperCase())) return i;
        } return -1;
    }
    // this function and 4 next functions is searching origin , destination , date , time , price and seat
    // and return 1 if it exists and return 0 if it not
    @Override
    public int searchByOrigin(String shouldSearch) {
        int result = 0;
        for (int i = 1; i < FLIGHTS_LIST.size(); i++) {
            if (FLIGHTS_LIST.get(i).getOrigin().equals(shouldSearch.substring(0,1).toUpperCase() +
                    shouldSearch.substring(1).toLowerCase())){
                printSingleAirLine(i);
                result = 1;
            }
        } return result;
    }
    @Override
    public int searchByDestination(String shouldSearch) {
        int result = 0;
        for (int i = 1; i < FLIGHTS_LIST.size(); i++) {
            if (FLIGHTS_LIST.get(i).getDestination().equals(shouldSearch.substring(0,1).toUpperCase() +
                    shouldSearch.substring(1).toLowerCase())) {
                printSingleAirLine(i);
                result = 1;
            }
        } return result;
    }
    @Override
    public int searchByDate(String shouldSearch) {
        int result = 0;
        for (int i = 1; i < FLIGHTS_LIST.size(); i++) {
            if (FLIGHTS_LIST.get(i).getDate().equals(shouldSearch)) {
                printSingleAirLine(i);
                result = 1;
            }
        } return result;
    }
    @Override
    public int searchByTime(String shouldSearch) {
        int result = 0;
        for (int i = 1; i < FLIGHTS_LIST.size(); i++) {
            if (FLIGHTS_LIST.get(i).getTime().equals(shouldSearch)) {
                printSingleAirLine(i);
                result = 1;
            }
        } return result;
    }
    @Override
    public int searchByPrice(int lower, int upper) {
        int result = 0;
        for (int i = 1; i < FLIGHTS_LIST.size(); i++) {
            if (upper<=Long.parseLong(FLIGHTS_LIST.get(i).getPrice()) &&
                    Long.parseLong(FLIGHTS_LIST.get(i).getPrice()) <= lower) {
                printSingleAirLine(i);
                result = 1;
            }
        } return result;
    }
    @Override
    public int searchBySeats(String shouldSearch) {
        int result = 0;
        for (int i = 1; i < FLIGHTS_LIST.size(); i++) {
            if (FLIGHTS_LIST.get(i).getSeats().equals(shouldSearch)) {
                printSingleAirLine(i);
                result = 1;
            }
        } return result;
    }
    // getPrice and getSeats get the index of address and return the value of price and seat
    @Override
    public String getPrice(int index){
        return FLIGHTS_LIST.get(index).getPrice();
    }
    // these next 7 functions get a string which should replace and get an index of an address that should update
    @Override
    public void updateFlightId(String toUpdate, int index){ FLIGHTS_LIST.get(index).setFlightId(toUpdate); }
    @Override
    public void updateOrigin(String toUpdate, int index){
        FLIGHTS_LIST.get(index).setOrigin(toUpdate);
    }
    @Override
    public void updateDestination(String toUpdate, int index){
        FLIGHTS_LIST.get(index).setDestination(toUpdate);
    }
    @Override
    public void updateDate(String toUpdate, int index){
        FLIGHTS_LIST.get(index).setDate(toUpdate);
    }
    @Override
    public void updateTime(String toUpdate, int index){
        FLIGHTS_LIST.get(index).setTime(toUpdate);
    }
    @Override
    public void updatePrice(String toUpdate, int index){
        FLIGHTS_LIST.get(index).setPrice(toUpdate);
    }
    @Override
    public void updateSeats(String toUpdate, int index){
        FLIGHTS_LIST.get(index).setSeats(toUpdate);
    }
    // this function is for print all airlines
    @Override
    public void printSingleAirLine(int index) {
        System.out.printf("| %-12s | %-12s | %-12s | %-12s | %-12s | %-12s | %-12s ",
                FLIGHTS_LIST.get(index).getFlightId() , FLIGHTS_LIST.get(index).getOrigin() ,
                FLIGHTS_LIST.get(index).getDestination() , FLIGHTS_LIST.get(index).getDate() ,
                FLIGHTS_LIST.get(index).getTime() , FLIGHTS_LIST.get(index).getPrice() , FLIGHTS_LIST.get(index).getSeats());
        System.out.print("\n");
    }
    // this function is for print a single airline
    @Override
    public void printAllAirLine(){
        for (int i = 0; i < FLIGHTS_LIST.size(); i++) printSingleAirLine(i);
    }
    @Override
    public boolean availableSeats(int index) {
        return FLIGHTS_LIST.get(index).getSeats().equals("0");
    }
    @Override
    public void increaseSeats(int index) {
        int newSeat = Integer.parseInt(FLIGHTS_LIST.get(index).getSeats()) + 1;
        FLIGHTS_LIST.get(index).setSeats(String.valueOf(newSeat));
    }
    @Override
    public void decreaseSeats(int index) {
        int newSeat = Integer.parseInt(FLIGHTS_LIST.get(index).getSeats()) - 1;
        FLIGHTS_LIST.get(index).setSeats(String.valueOf(newSeat));
    }
}
