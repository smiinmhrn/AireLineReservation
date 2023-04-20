public class Register {
    private final User user;

    public Register(User user) {
        this.user = user;
    }

    public void addAdminAccount(Users users) {
        user.addAccount(users);
    }
    public Users searchAdminName(String username) {
        return user.searchUsername(username);
    }
    public boolean searchAdminPassword(String password , String username) {
        return user.searchPassword(password , username);
    }
    public Users searchPassengerName(String username) {
        return user.searchUsername(username);
    }
    public void addPassengerAccount(Users users) {
        user.addAccount(users);
    }
    public boolean searchPassengerPassword(String password , String username) {
        return user.searchPassword(password , username);
    }
}
