package model.userSettings;

public class User {
    private int id;
    private String login;
    private int companyID;
    private int deportmentID;
    private String username;
    private int born;
    public User(String username, int born) {
        this.username = username;
        this.born = born;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBorn() {
        return born;
    }

    public void setBorn(int born) {
        this.born = born;
    }
}
