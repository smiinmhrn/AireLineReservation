import java.util.ArrayList;
import java.util.List;
public class Flight {
    // this class is responsible for doing some actions in airline list
    private static final List<Flights> AIR_LINE_LIST = new ArrayList<>();
    // this function is for adding new airline
    public void addAirlines(Flights flights) { AIR_LINE_LIST.add(flights); }
    // this function is for removing new airline
    public void removeAirLine(int index){
        AIR_LINE_LIST.remove(index);
    }
    // this function is for searching flight id and return the index of its address and if it dost exist return -1
    public int searchByFlightId(String shouldSearch) {
        for (int i = 0; i < AIR_LINE_LIST.size(); i++) {
            if (AIR_LINE_LIST.get(i).getFlightId().equals(shouldSearch.toUpperCase())) return i;
        } return -1;
    }
    // this function and 4 next functions is searching origin , destination , date , time , price and seat
    // and return 1 if it exists and return 0 if it not
    public int searchByOrigin(String shouldSearch) {
        int result = 0;
        for (int i = 0; i < AIR_LINE_LIST.size(); i++) {
            if (AIR_LINE_LIST.get(i).getOrigin().equals(shouldSearch.substring(0,1).toUpperCase() +
                    shouldSearch.substring(1).toLowerCase())){
                printSingleAirLine(i);
                result = 1;
            }
        } return result;
    }
    public int searchByDestination(String shouldSearch) {
        int result = 0;
        for (int i = 0; i < AIR_LINE_LIST.size(); i++) {
            if (AIR_LINE_LIST.get(i).getDestination().equals(shouldSearch.substring(0,1).toUpperCase() +
                    shouldSearch.substring(1).toLowerCase())) {
                printSingleAirLine(i);
                result = 1;
            }
        } return result;
    }
    public int searchByDate(String shouldSearch) {
        int result = 0;
        for (int i = 0; i < AIR_LINE_LIST.size(); i++) {
            if (AIR_LINE_LIST.get(i).getDate().equals(shouldSearch)) {
                printSingleAirLine(i);
                result = 1;
            }
        } return result;
    }
    public int searchByTime(String shouldSearch) {
        int result = 0;
        for (int i = 0; i < AIR_LINE_LIST.size(); i++) {
            if (AIR_LINE_LIST.get(i).getTime().equals(shouldSearch)) {
                printSingleAirLine(i);
                result = 1;
            }
        } return result;
    }
    public int searchByPrice(int lower , int upper) {
        int result = 0;
        for (int i = 7; i < AIR_LINE_LIST.size(); i++) {
            if (upper<=Integer.parseInt(AIR_LINE_LIST.get(i).getPrice()) &&
                    Integer.parseInt(AIR_LINE_LIST.get(i).getPrice()) <= lower) {
                printSingleAirLine(i);
                result = 1;
            }
        } return result;
    }
    public int searchBySeats(String shouldSearch) {
        int result = 0;
        for (int i = 0; i < AIR_LINE_LIST.size(); i++) {
            if (AIR_LINE_LIST.get(i).getSeats().equals(shouldSearch)) {
                printSingleAirLine(i);
                result = 1;
            }
        } return result;
    }
    // getPrice and getSeats get the index of address and return the value of price and seat
    public String getPrice(int index){
        return AIR_LINE_LIST.get(index).getPrice();
    }
    public String getSeats(int index){
        return AIR_LINE_LIST.get(index).getSeats();
    }
    // these next 7 functions get a string which should replace and get an index of an address that should update
    public void updateFlightId(String toUpdate , int index){ AIR_LINE_LIST.get(index).setFlightId(toUpdate); }
    public void updateOrigin(String toUpdate , int index){
        AIR_LINE_LIST.get(index).setOrigin(toUpdate);
    }
    public void updateDestination(String toUpdate , int index){
        AIR_LINE_LIST.get(index).setDestination(toUpdate);
    }
    public void updateDate(String toUpdate , int index){
        AIR_LINE_LIST.get(index).setDate(toUpdate);
    }
    public void updateTime(String toUpdate , int index){
        AIR_LINE_LIST.get(index).setTime(toUpdate);
    }
    public void updatePrice(String toUpdate , int index){
        AIR_LINE_LIST.get(index).setPrice(toUpdate);
    }
    public void updateSeats(String toUpdate , int index){
        AIR_LINE_LIST.get(index).setSeats(toUpdate);
    }
    // this function is for print all airlines
    public void printSingleAirLine(int index) {
        System.out.printf("| %-12s | %-12s | %-12s | %-12s | %-12s | %-12s | %-12s ",
                AIR_LINE_LIST.get(index).getFlightId() , AIR_LINE_LIST.get(index).getOrigin() ,
                AIR_LINE_LIST.get(index).getDestination() , AIR_LINE_LIST.get(index).getDate() ,
                AIR_LINE_LIST.get(index).getTime() , AIR_LINE_LIST.get(index).getPrice() , AIR_LINE_LIST.get(index).getSeats());
        System.out.print("\n");
    }
    // this function is for print a single airline
    public void printAllAirLine(){
        for (int i = 0; i < AIR_LINE_LIST.size(); i++) printSingleAirLine(i);
    }
}
