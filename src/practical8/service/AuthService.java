package practical8.service;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

import practical8.model.User;

public class AuthService {
    // NFR1 - Concurrency support for multiple users
    private ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
    private final File storageFile = new File("users.txt");

    public AuthService() {
        loadFromFile();
    }

    // FR1 - Register new user
    public boolean register(User user) {
        // NFR4 - Ensure user registration consistency under concurrency
        if (users.putIfAbsent(user.getUsername(), user) != null) {
            return false; // user already exists
        }
        saveToFile();
        return true;
    }

    // FR2 - Authenticate user
    public boolean authenticate(String username, String password) {
        // NFR2 - Method should respond quickly, < 500ms
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    // FR9 - Persist users to text file
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(storageFile))) {
            for (User u : users.values()) {
                writer.write(u.getUsername() + "," + u.getPassword() + "," + u.isProvider());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        if (!storageFile.exists())
            return;
        try (BufferedReader reader = new BufferedReader(new FileReader(storageFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users.put(parts[0], new User(parts[0], parts[1], Boolean.parseBoolean(parts[2])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}