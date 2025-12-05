package practical8;

import java.util.*;

public class AppointmentService {
    private List<Appointment> appointments = new ArrayList<>();
    private NotificationService notificationService;

    public AppointmentService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public boolean bookAppointment(String client, String provider, String slot) {
        for (Appointment a : appointments) {
            if (a.getProvider().equals(provider) && a.getTimeSlot().equals(slot)) {
                notificationService.log("Conflict for provider: " + provider);
                return false;
            }
        }
        Appointment appt = new Appointment(client, provider, slot);
        appointments.add(appt);

        notificationService.notify(client, "Your appointment is booked.");
        notificationService.notify(provider, "You have a new appointment.");

        return true;
    }
}
