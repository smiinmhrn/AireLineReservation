public class Users {
    // this class is responsible for saving username and password and set and get password and username wherever needed
    private final String USERNAME;
    private String password;
    private String charge;
    public Users(String username, String password, String charge) {
        this.USERNAME = username;
        this.password = password;
        this.charge = charge;
    }
    public String getUSERNAME() {
        return USERNAME;
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
