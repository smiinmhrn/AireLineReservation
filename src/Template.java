import java.util.Scanner;

public class Template {
    Scanner input = new Scanner(System.in);
    // check if inputs are numbers not anything else
    public String availableInput(String choice){

        while (true){
            try {
                Long.parseLong(choice);
                break;
            } catch (Exception e) {
                System.out.println( Appearance.RED + "Pleas enter a available \"number\" :" + Appearance.RESET_COLOR);
                choice = input.next();
            }
        }
        return choice;
    }
}
