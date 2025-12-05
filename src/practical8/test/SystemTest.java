package practical8.test;

import org.junit.jupiter.api.*;

import java.util.List;
import practical8.model.*;
import practical8.service.*;

import static org.junit.Assert.*;

/**
 * Running the test will generates users.txt.
 * Clear the users.txt everytime before running the test cases.
 */
public class SystemTest {

    private AuthService authService;
    private AvailabilityService availabilityService;
    private NotificationService notificationService;
    private AppointmentService appointmentService;

    @BeforeEach
    public void setup() {
        authService = new AuthService();
        availabilityService = new AvailabilityService();
        notificationService = new NotificationService();
        appointmentService = new AppointmentService(notificationService);
    }

    // TC1 - FR1 - Register new user successfully
    @Test
    public void testRegisterUser() {
        assertTrue(authService.register(new User("alice", "1234", false)));
    }

    // TC2 - FR1 - Prevent duplicate registration
    @Test
    public void testDuplicateRegistration() {
        authService.register(new User("alice", "1234", false));
        assertFalse(authService.register(new User("alice", "0000", false)));
    }

    // TC3 - FR2 - Authentication success
    @Test
    public void testAuthenticationSuccess() {
        // TODO
    }

    // TC4 - FR2 - Authentication failure
    @Test
    public void testAuthenticationFailure() {
        // TODO
    }

    // TC5 - FR3 - Provider adds availability slot
    @Test
    public void testAddAvailability() {
        // TODO
    }

    // TC6 - FR4/FR5 - Book without conflict
    @Test
    public void testBookingWithoutConflict() {
        // TODO
    }

    // TC7 - FR5 - Conflict detection
    @Test
    public void testBookingConflict() {
        // TODO
    }

    // TC8 - FR6 - Notification is triggered
    @Test
    public void testNotificationTriggered() {
        // TODO
    }

    // TC9 - FR7 - View upcoming appointments
    @Test
    public void testViewAppointments() {
        // TODO
    }

    // TC10 - FR8 - Cancel appointment
    @Test
    public void testCancelAppointment() {
        // TODO
    }

    // TC11 - FR9 - Persistent storage writes data (basic check)
    @Test
    public void testPersistentStorage() {
        // TODO
    }

    // TC12 - NFR2 - Check booking response time < 500ms
    @Test
    public void testBookingResponseTime() {
        // TODO
    }
}