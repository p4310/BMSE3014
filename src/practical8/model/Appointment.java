package practical8.model;

public class Appointment {
    private String client;
    private String provider;
    private String timeSlot;

    public Appointment(String client, String provider, String timeSlot) {
        this.client = client;
        this.provider = provider;
        this.timeSlot = timeSlot;
    }

    public String getClient() {
        return client;
    }

    public String getProvider() {
        return provider;
    }

    public String getTimeSlot() {
        return timeSlot;
    }
}