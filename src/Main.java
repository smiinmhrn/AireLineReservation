public class Main {
    public static void main(String[] args) {
        var defaultFlights = new DefaultFlights();
        defaultFlights.addDefault();

        var startProgram = new MainMenu(new Templates());
        startProgram.mainMenu();
//        var passenger = new Passenger(new Template(),new PassengerActions(new Flight(),new Ticket()));
//        passenger.signUp();
    }
}