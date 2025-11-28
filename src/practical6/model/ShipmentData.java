package practical6.model;

public class ShipmentData {
    private final int id;
    private final double value;
    private final double weight;
    private final Region region;
    private final ShipmentStatus status;

    public ShipmentData(int id, double value, double weight, Region region, ShipmentStatus status) {
        this.id = id;
        this.value = value;
        this.weight = weight;
        this.region = region;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public Region getRegion() {
        return region;
    }

    public ShipmentStatus getStatus() {
        return status;
    }
}