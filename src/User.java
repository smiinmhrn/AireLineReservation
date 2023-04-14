import java.util.ArrayList;
import java.util.List;
public class User {
    // this class is responsible for every action related to users accounts
    private static final List<Users> USERS_LIST = new ArrayList<>();
    /**
     * @param name => searching this name in list
     * @return => and return index of address which having it and if it doesn't exist return -1
     */
    public int searchUsername(String name) {
        for (int i = 0; i < USERS_LIST.size(); i++) {
            if (USERS_LIST.get(i).getUsername().equals(name)) return i;
        } return -1;
    }
    // use for check if the password that user enter ( function get it first ) is similar to its username password
    public boolean searchPassword(String password) {
        for (Users accountElements : USERS_LIST) {
            if (accountElements.getPassword().equals(password)) return true;
        } return false;
    }
    // this function is use for adding new account
    public void addAccount(Users users) { USERS_LIST.add(users); }
    // use for changing password
    public void changePass(int index , String newPass) { USERS_LIST.get(index).setPassword(newPass); }
}
