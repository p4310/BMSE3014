package practical8;

import java.util.HashMap;

public class AuthService {

    private HashMap<String, User> users = new HashMap<>(); // persistent later

    public boolean register(User user) {
        if (users.containsKey(user.getUsername()))
            return false;
        users.put(user.getUsername(), user);
        return true;
    }

    public boolean authenticate(String username, String password) {
        if (!users.containsKey(username))
            return false;
        return users.get(username).getPassword().equals(password);
    }
}
