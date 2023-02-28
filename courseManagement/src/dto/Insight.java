package dto;

public class Insight {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String userName;
    private long phoneNumber;
    private String email;

    public Insight(String userName, long phoneNumber, String email) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

}
