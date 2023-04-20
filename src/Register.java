public class Register {
    private final User USER;
    public Register(User user) {
        this.USER = user;
    }
    public void addAdminAccount(Users users) {
        USER.addAccount(users);
    }
    public void addPassengerAccount(Users users) {
        USER.addAccount(users);
    }
    public Users searchAdminName(String username) {
        return USER.searchUsername(username);
    }
    public Users searchPassengerName(String username) {
        return USER.searchUsername(username);
    }
    public boolean searchAdminPassword(String password, String username) {
        return USER.searchPassword(password, username);
    }
    public boolean searchPassengerPassword(String password, String username) {
        return USER.searchPassword(password, username);
    }
}
