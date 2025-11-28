package practical6;

import practical6.controller.ShipmentProcessor;
import practical6.model.Region;
import practical6.model.ShipmentData;
import practical6.model.ShipmentStatus;

public class SampleCode {
    public static void main(String[] args) {
        ShipmentData shipment = new ShipmentData(
                101,
                600.0,
                5.0,
                Region.EAST,
                ShipmentStatus.READY);

        new ShipmentProcessor().processShipment(shipment);
    }
}