// this class is for get filed of class and set them
public class Flights {
    private String flightId;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private String price;
    private String seats;
    public Flights(String flightId, String origin, String destination,
                          String date, String time, String price, String seats) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
        this.seats = seats;
    }
    public String getFlightId() {
        return flightId;
    }
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) { this.date = date; }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getSeats() {
        return seats;
    }
    public void setSeats(String seats) { this.seats = seats; }
}
