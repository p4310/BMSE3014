package practical6;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class SampleCode {

    private static final double GLOBAL_RATE_BASE = 5.0;
    private static final double HIGH_VALUE_THRESHOLD = 500.0;
    private static final double BULKY_WEIGHT_LIMIT = 20.0;

    public static void main(String[] args) {

        Map<String, Object> dataPackage = new HashMap<>();
        dataPackage.put("id", 101);
        dataPackage.put("value", 600.0);
        dataPackage.put("weight", 5.0);
        dataPackage.put("region", "East");
        dataPackage.put("status_code", 1);

        System.out.println("--- Starting Shipment Data Calculation for Order: " + dataPackage.get("id") + " ---");

        double initialCost = GLOBAL_RATE_BASE;
        boolean isUrgent = false;

        String region = (String) dataPackage.get("region");
        double value = (Double) dataPackage.get("value");

        if ("East".equals(region) || "West".equals(region)) {
            if (value > HIGH_VALUE_THRESHOLD) {
                initialCost *= 1.25; // 25% rush fee
                isUrgent = true;
                System.out.println("DEBUG: Applied 25% rush fee for high value/target region.");
            }
        } else if ("Central".equals(region)) {
            initialCost += 10.0; // Remote fee
            System.out.println("DEBUG: Applied $10 remote fee for Central region.");
        } else {
            initialCost *= 1.10; // Standard surcharge
            System.out.println("DEBUG: Applied 10% standard surcharge.");
        }

        double weight = (Double) dataPackage.get("weight");
        if (weight > BULKY_WEIGHT_LIMIT) {
            double weightFactor = weight / BULKY_WEIGHT_LIMIT;
            initialCost += (weightFactor * 5.0);
            System.out.println("DEBUG: Applied bulky surcharge based on weight factor: " + weightFactor);
        }

        String msg = "";
        int statusCode = (Integer) dataPackage.get("status_code");

        if (statusCode == 1) {
            msg = "Ready for Shipment";
            if (isUrgent) {
                msg += " (Priority)";
            }
        } else if (statusCode == 2) {
            msg = "Pending Review - Address Issue";
        } else {
            msg = "Error: Unknown Status";
        }

        double finalRate = Math.round(initialCost * 100.0) / 100.0;

        System.out.println("\n--- FINAL SHIPMENT DATA ---");
        System.out.println("Order ID: " + dataPackage.get("id"));
        System.out.println("Shipping Rate: $" + finalRate);
        System.out.println("Shipment Status: " + msg);
        System.out.println("----------------------------");
    }
}
