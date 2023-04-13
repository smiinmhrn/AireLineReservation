import appearance.Appearance;
import java.util.Scanner;
public class Admin {
    Scanner input = new Scanner(System.in);
    private final Template TEMPLATE;
    private final AdminActions ADMIN_ACTIONS;
    public Admin(Template TEMPLATE, AdminActions ADMIN_ACTIONS) {
        this.TEMPLATE = TEMPLATE;
        this.ADMIN_ACTIONS = ADMIN_ACTIONS;
    }
    // this function is for handling admin menu
    public void adminMenu() {
        System.out.println(Appearance.BLUE + "[ ADMIN MENU OPTIONS ]" + Appearance.RESET_COLOR);
        System.out.println(Appearance.TEXT_ITALIC +  """
            1. Add
            2. Update
            3. Remove
            4. Flight schedules
            0. Sign out
            Choose :\s""" +  Appearance.RESET_STYLE);

        String choice = input.next();
        label :
        while (true) {
            switch (TEMPLATE.availableInput(choice)) {
                case "1" :
                    break label;
                case "2" :
                    break label;
                case "3" :
                    break label;
                case "4" :
                    break label;
                case "0" :
                    break label;
                default :
                    System.out.println(Appearance.RED + "Wrong command! Try again :" + Appearance.RESET_COLOR);
                    choice = input.next();
            }
        }
    }

}
