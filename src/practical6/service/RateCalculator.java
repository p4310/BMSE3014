package practical6.service;

import practical6.constants.Config;
import practical6.model.Region;
import practical6.model.ShipmentData;

public class RateCalculator {

    public double calculateRate(ShipmentData shipment) {
        double cost = Config.GLOBAL_RATE_BASE;

        cost = applyRegionalAdjustment(cost, shipment);
        cost = applyWeightAdjustment(cost, shipment.getWeight());

        return roundTwoDecimals(cost);
    }

    private double applyRegionalAdjustment(double cost, ShipmentData shipment) {
        Region region = shipment.getRegion();
        double value = shipment.getValue();

        switch (region) {
            case EAST:
            case WEST:
                if (value > Config.HIGH_VALUE_THRESHOLD) {
                    System.out.println("DEBUG: Applied 25% rush fee for high value/target region.");
                    return cost * Config.RUSH_FEE_RATE;
                }
                return cost;

            case CENTRAL:
                System.out.println("DEBUG: Applied $10 remote fee for Central region.");
                return cost + Config.REMOTE_REGION_FEE;

            default:
                System.out.println("DEBUG: Applied 10% standard surcharge.");
                return cost * Config.STANDARD_SURCHARGE_RATE;
        }
    }

    private double applyWeightAdjustment(double cost, double weight) {
        if (weight > Config.BULKY_WEIGHT_LIMIT) {
            double weightFactor = weight / Config.BULKY_WEIGHT_LIMIT;
            double surcharge = weightFactor * Config.BULKY_SURCHARGE_RATE;
            System.out.println("DEBUG: Applied bulky surcharge, weight factor: " + weightFactor);
            return cost + surcharge;
        }
        return cost;
    }

    private double roundTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}