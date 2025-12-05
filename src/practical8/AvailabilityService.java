package practical8;

import java.util.*;

public class AvailabilityService {
    private HashMap<String, List<String>> providerSlots = new HashMap<>();

    public boolean addAvailability(String provider, String timeSlot) {
        providerSlots.putIfAbsent(provider, new ArrayList<>());
        if (providerSlots.get(provider).contains(timeSlot))
            return false;
        providerSlots.get(provider).add(timeSlot);
        return true;
    }

    public List<String> getAvailability(String provider) {
        return providerSlots.getOrDefault(provider, List.of());
    }
}
