public class Users {
    // this class is responsible for saving username and password and set and get password and username wherever needed
    private final String username;
    private String password;
    private String charge;
    public Users(String username, String password, String charge) {
        this.username = username;
        this.password = password;
        this.charge = charge;
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
    public String getCharge() {
        return charge;
    }
    public void setCharge(String charge) {
        this.charge = charge;
    }
}
