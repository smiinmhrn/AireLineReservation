public class Users {
    // this class is responsible for saving username and password and set and get password and username wherever needed
    private final String username;
    private String password;
    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
