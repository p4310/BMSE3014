package practical8.service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import practical8.model.Appointment;

// FR4, FR5, FR6, FR7, FR8 - Appointment Service
public class AppointmentService {
    // NFR1 - Concurrency support for multiple appointments
    private CopyOnWriteArrayList<Appointment> appointments = new CopyOnWriteArrayList<>();
    private NotificationService notificationService;

    public AppointmentService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // FR4/FR5 - Book appointment without conflicts
    public boolean bookAppointment(String client, String provider, String slot) {
        // NFR2 - Booking should respond quickly, < 500ms
        for (Appointment a : appointments) {
            if (a.getProvider().equals(provider) && a.getTimeSlot().equals(slot)) {
                notificationService.log("Conflict for provider: " + provider);
                // NFR3 - Log booking conflict
                return false;
            }
        }
        Appointment appt = new Appointment(client, provider, slot);
        // NFR4 - Ensure data consistency: no overlapping appointments
        appointments.add(appt);

        // FR6 - Notify users
        notificationService.notify(client, "Your appointment is booked.");
        notificationService.notify(provider, "You have a new appointment.");
        // NFR3 - Log successful booking via notifications/logs
        return true;
    }

    // FR7 - View upcoming appointments
    public List<Appointment> viewAppointments(String username) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getClient().equals(username) || a.getProvider().equals(username)) {
                result.add(a);
            }
        }
        return result;
    }

    // FR8 - Cancel appointment
    public boolean cancelAppointment(String client, String provider, String slot) {
        for (Appointment a : appointments) {
            if (a.getClient().equals(client) && a.getProvider().equals(provider) && a.getTimeSlot().equals(slot)) {
                appointments.remove(a);
                notificationService.notify(client, "Your appointment is cancelled.");
                notificationService.notify(provider, "Appointment cancelled by client.");
                return true;
            }
        }
        return false;
    }
}
