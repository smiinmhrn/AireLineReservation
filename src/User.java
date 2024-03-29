import java.util.ArrayList;
import java.util.List;
// this class is responsible for every action related to users accounts
public class User implements CanPassengerUser {
    private final List<Users> USERS_LIST = new ArrayList<>();
    /**
     * @param name => searching this name in list
     * @return => and return index of address which having it and if it doesn't exist return -1
     */
    public Users searchUsername(String name) {
        for (Users users : USERS_LIST)
            if (users.getUSERNAME().equals(name)) return users;
        return null;
    }
    // use for check if the password that user enter ( function get it first ) is similar to its username password
    public boolean searchPassword(String password, String username) {
        return searchUsername(username).getPassword().equals(password);
    }
    // this function is use for adding new account
    public void addAccount(Users users) { USERS_LIST.add(users); }
    // use for changing password
    @Override
    public void changePass(String username, String newPass) {
        searchUsername(username).setPassword(newPass);
    }
    // this function use for getting amount of user charge
    @Override
    public String getCharge(String username) {
        return searchUsername(username).getCharge();
    }
    // return a boolean that shows if charge is enough for buying tickets or not
    @Override
    public boolean isEnough(String shouldPay, String username){
        return Long.parseLong(getCharge(username)) >= Long.parseLong(shouldPay);
    }
    // this function use for increasing charge
    @Override
    public void increaseCharge(String username, String chargeAmount) {

        String oldCharge = searchUsername(username).getCharge();
        long newCharge = Long.parseLong(oldCharge) + Long.parseLong(chargeAmount);
        searchUsername(username).setCharge(String.valueOf(newCharge));
    }
    // this function use for decreasing charge
    @Override
    public void decreaseCharge(String username, String chargeAmount) {

        String oldCharge = searchUsername(username).getCharge();
        long newCharge = Long.parseLong(oldCharge) - Long.parseLong(chargeAmount);
        searchUsername(username).setCharge(String.valueOf(newCharge));
    }
}
