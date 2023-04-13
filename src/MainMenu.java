import java.util.Scanner;
import appearance.Appearance;
public class MainMenu {
    Scanner input = new Scanner(System.in);
    private final Template TEMPLATE;
    public MainMenu(Template TEMPLATE) {
        this.TEMPLATE = TEMPLATE;
    }
    public void mainMenu() {

        System.out.println(Appearance.BLUE + "[ WELCOME TO AIRLINE RESERVATION SYSTEM ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC + """
            1. Sign in
            2. Sign up
            Choose : \s""" + Appearance.RESET_STYLE);

        String choice = input.next();
        label :
        while (true){
            switch (TEMPLATE.availableInput(choice)) {
                case "1" :
                    break label;
                case "2" :
                    break label;
                default:
                    System.out.println(Appearance.RED + "Wrong command! Try again :" + Appearance.RESET_COLOR);
                    choice = input.next();
            }
        }
    }
}
