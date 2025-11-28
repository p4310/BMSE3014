package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practical6.model.ShipmentStatus;
import practical6.service.StatusResolver;

import static org.junit.jupiter.api.Assertions.*;

class StatusResolverTest {

    private StatusResolver resolver;

    @BeforeEach
    void setUp() {
        resolver = new StatusResolver();
    }

    @Test
    void testReadyStatusNormal() {
        // Ready status without urgency → Normal status message
        assertEquals("Ready for Shipment", resolver.resolveStatus(ShipmentStatus.READY, false));
    }

    @Test
    void testReadyStatusUrgent() {
        // Ready status AND urgent → Should include "Priority"
        assertEquals("Ready for Shipment (Priority)", resolver.resolveStatus(ShipmentStatus.READY, true));
    }

    @Test
    void testPendingReview() {
        // Pending review status → Returns correct message
        assertEquals("Pending Review - Address Issue", resolver.resolveStatus(ShipmentStatus.PENDING_REVIEW, false));
    }

    @Test
    void testUnknownStatus() {
        // Unknown status → Should return error message
        assertEquals("Error: Unknown Status", resolver.resolveStatus(ShipmentStatus.UNKNOWN, false));
    }
}
