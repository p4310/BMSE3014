package practical6.controller;

import practical6.constants.Config;
import practical6.model.Region;
import practical6.model.ShipmentData;
import practical6.service.RateCalculator;
import practical6.service.StatusResolver;

public class ShipmentProcessor {

    private final RateCalculator rateCalculator;
    private final StatusResolver statusResolver;

    public ShipmentProcessor() {
        this.rateCalculator = new RateCalculator();
        this.statusResolver = new StatusResolver();
    }

    public void processShipment(ShipmentData shipment) {
        System.out.println("--- Starting Shipment Data Calculation for Order: " + shipment.getId() + " ---");

        double rate = rateCalculator.calculateRate(shipment);
        boolean isUrgent = isUrgentShipment(shipment);

        String statusMessage = statusResolver.resolveStatus(shipment.getStatus(), isUrgent);

        printFinalDetails(shipment, rate, statusMessage);
    }

    private boolean isUrgentShipment(ShipmentData shipment) {
        return (shipment.getRegion() == Region.EAST ||
                shipment.getRegion() == Region.WEST) &&
                shipment.getValue() > Config.HIGH_VALUE_THRESHOLD;
    }

    private void printFinalDetails(ShipmentData shipment, double rate, String statusMessage) {
        System.out.println("\n--- FINAL SHIPMENT DATA ---");
        System.out.println("Order ID: " + shipment.getId());
        System.out.println("Shipping Rate: $" + rate);
        System.out.println("Shipment Status: " + statusMessage);
        System.out.println("----------------------------");
    }
}