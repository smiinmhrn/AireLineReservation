public class Main {
    public static void main(String[] args) {

        var newClass = new NewingClasses();
        var defaultFlights = new DefaultFlights(newClass);
        defaultFlights.addDefault();
        var startProgram = new MainMenu(new Templates(),newClass);
        startProgram.mainMenu();
    }
}