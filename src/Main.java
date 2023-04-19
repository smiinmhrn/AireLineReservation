public class Main {
    public static void main(String[] args) {
        var defaultFlights = new DefaultFlights();
        defaultFlights.addDefault();

        var startProgram = new MainMenu(new Template());
        startProgram.mainMenu();
    }
}