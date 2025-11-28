package practical6.service;

import practical6.model.ShipmentStatus;

public class StatusResolver {

    public String resolveStatus(ShipmentStatus status, boolean isUrgent) {
        switch (status) {
            case READY:
                return isUrgent ? "Ready for Shipment (Priority)" : "Ready for Shipment";
            case PENDING_REVIEW:
                return "Pending Review - Address Issue";
            default:
                return "Error: Unknown Status";
        }
    }
}