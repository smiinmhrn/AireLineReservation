// this class is responsible for adding 10 default airlines
public class DefaultFlights {
    private final NewingClasses NEWING_CLASSES;
    public DefaultFlights(NewingClasses newClasses) {
        this.NEWING_CLASSES = newClasses;
    }
    public void addDefault(){

        NEWING_CLASSES.getFLIGHT().addAirlines(
                new Flights("FlightId", "Origin", "Destination", "Date",
                        "Time", "Price", "Seats")
        );
        NEWING_CLASSES.getFLIGHT().addAirlines(
                new Flights("WX-12", "Yazd", "Tehran", "1401-12-10",
                        "12:30", "700000", "51")
        );
        NEWING_CLASSES.getFLIGHT().addAirlines(
                new Flights("WX-15", "Mashhad", "Ahvaz", "1401-12-11",
                        "08:00" , "900000" , "245")
        );
        NEWING_CLASSES.getFLIGHT().addAirlines(
                new Flights("WX-22", "Mashhad", "Shiraz", "1401-10-11",
                        "08:00", "500000", "45")
        );
        NEWING_CLASSES.getFLIGHT().addAirlines(
                new Flights("BG-22", "Shiraz", "Tabriz", "1401-12-12",
                        "22:30", "1100000", "12")
        );
        NEWING_CLASSES.getFLIGHT().addAirlines(
                new Flights("AX-22", "Shiraz", "Tehran", "1401-12-22",
                        "08:00", "500000", "15")
        );
        NEWING_CLASSES.getFLIGHT().addAirlines(
                new Flights("AX-21", "Shiraz", "Hamedan", "1401-09-22",
                        "08:30", "500000", "55")
        );
        NEWING_CLASSES.getFLIGHT().addAirlines(
                new Flights("QX-22", "Tehran", "Mashhad", "1401-12-22",
                        "09:00", "600000", "115")
        );
        NEWING_CLASSES.getFLIGHT().addAirlines(
                new Flights("AS-22", "Tehran", "Esfahan", "1402-02-22",
                        "22:00", "500000", "8")
        );
        NEWING_CLASSES.getFLIGHT().addAirlines(
                new Flights("AA-22", "Esfahan", "Tehran", "1402-01-02",
                        "13:30", "500000", "10")
        );
        NEWING_CLASSES.getFLIGHT().addAirlines(
                new Flights("PX-12", "Esfahan", "Shiraz", "1402-10-22",
                        "18:30", "1000000", "100")
        );
    }
}
