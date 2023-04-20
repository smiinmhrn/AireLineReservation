// this class has responsible for register passenger and admin account
public class Register {
    private final User USER;
    public Register(User user) {
        this.USER = user;
    }
    // this function has the method for adding admin account
    public void addAdminAccount(Users users) {
        USER.addAccount(users);
    }
    // this function has the method for adding passenger account
    public void addPassengerAccount(Users users) {
        USER.addAccount(users);
    }
    // this function has the method for searching admin name and return the address of the account
    public Users searchAdminName(String username) {
        return USER.searchUsername(username);
    }
    // this function has the method for searching passenger name and return the address of the account
    public Users searchPassengerName(String username) {
        return USER.searchUsername(username);
    }
    // this function has the method for searching admin password and return true if the password is same as input
    public boolean searchAdminPassword(String password, String username) {
        return USER.searchPassword(password, username);
    }
    // this function has the method for searching admin password and return true if the password is same as input
    public boolean searchPassengerPassword(String password, String username) {
        return USER.searchPassword(password, username);
    }
}
