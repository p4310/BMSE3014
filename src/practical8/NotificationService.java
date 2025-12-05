package practical8;

public class NotificationService {

    public void notify(String user, String message) {
        System.out.println("[Notify] " + user + ": " + message);
    }

    public void log(String message) {
        System.out.println("[Log] " + message);
    }
}
