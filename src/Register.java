public class Register extends User {
    public void addAdminAccount(Users users) {
        addAccount(users);
    }
    public Users searchAdminName(String username) {
        return searchUsername(username);
    }
    public boolean searchAdminPassword(String password , String username) {
        return searchPassword(password , username);
    }
    public Users searchPassengerName(String username) {
        return searchUsername(username);
    }
    public void addPassengerAccount(Users users) {
        addAccount(users);
    }
    public boolean searchPassengerPassword(String password , String username) {
        return searchPassword(password , username);
    }
}
