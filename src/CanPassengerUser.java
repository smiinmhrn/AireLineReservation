public interface CanPassengerUser {
    void changePass(String username, String newPass);
    boolean isEnough(String shouldPay, String username);
    void increaseCharge(String username, String chargeAmount);
    void decreaseCharge(String username, String chargeAmount);
    String getCharge(String username);
}
