package test;

import org.junit.jupiter.api.*;

import practical6.model.Region;
import practical6.model.ShipmentData;
import practical6.model.ShipmentStatus;
import practical6.service.RateCalculator;

import static org.junit.jupiter.api.Assertions.*;

class RateCalculatorTest {

    private RateCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new RateCalculator();
    }

    @Test
    void testHighValueEastRegionRushFee() {
        // High value shipment in EAST region → Apply 25% rush fee
        ShipmentData data = new ShipmentData(101, 600.0, 10.0, Region.EAST, ShipmentStatus.READY);
        assertEquals(6.25, calculator.calculateRate(data));
    }

    @Test
    void testCentralRegionRemoteFee() {
        // Central region → Add fixed $10 remote region fee
        ShipmentData data = new ShipmentData(102, 300.0, 10.0, Region.CENTRAL, ShipmentStatus.READY);
        assertEquals(15.0, calculator.calculateRate(data));
    }

    @Test
    void testStandardRegionSurcharge() {
        // Other region → Apply 10% standard surcharge
        ShipmentData data = new ShipmentData(103, 300.0, 10.0, Region.OTHER, ShipmentStatus.READY);
        assertEquals(5.5, calculator.calculateRate(data));
    }

    @Test
    void testBulkyWeightSurcharge() {
        // Weight above 20kg → Apply bulky surcharge based on weight factor
        ShipmentData data = new ShipmentData(104, 200.0, 40.0, Region.EAST, ShipmentStatus.READY);
        assertEquals(15.0, calculator.calculateRate(data));
    }
}