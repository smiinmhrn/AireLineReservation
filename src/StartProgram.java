// this class has responsible for newing needed classes in the first of the program
public class StartProgram {
    public void startProgram() {
        var newClass = new NewingClasses();
        var defaultFlights = new DefaultFlights(newClass);
        defaultFlights.addDefault();
        var startProgram = new MainMenu(new Templates(),newClass);
        startProgram.mainMenu();
    }
}
