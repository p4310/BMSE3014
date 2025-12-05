package practical8.service;

import java.util.ArrayList;
import java.util.List;

// FR6 - The system shall notify the provider and client when an appointment is booked.
public class NotificationService {
    private List<String> notifications = new ArrayList<>();

    public void notify(String user, String message) {
        notifications.add(user + ": " + message);
        System.out.println("[Notify] " + user + ": " + message);
    }

    public void log(String message) {
        System.out.println("[Log] " + message);
    }

    public List<String> getNotifications() {
        return new ArrayList<>(notifications);
    }

    public void clearNotifications() {
        notifications.clear();
    }
}
