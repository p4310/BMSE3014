package practical8;

public class User {
    private String username;
    private String password;
    private boolean isProvider;

    public User(String username, String password, boolean isProvider) {
        this.username = username;
        this.password = password;
        this.isProvider = isProvider;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isProvider() {
        return isProvider;
    }
}
