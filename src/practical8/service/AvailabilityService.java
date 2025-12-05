package practical8.service;

import java.util.*;
import java.util.concurrent.*;

// FR3 - Providers shall define their available time slots.
public class AvailabilityService {
    private ConcurrentHashMap<String, CopyOnWriteArrayList<String>> providerSlots = new ConcurrentHashMap<>();

    // Add availability slot
    public boolean addAvailability(String provider, String timeSlot) {
        providerSlots.putIfAbsent(provider, new CopyOnWriteArrayList<>());
        CopyOnWriteArrayList<String> slots = providerSlots.get(provider);
        if (slots.contains(timeSlot))
            return false; // duplicate
        slots.add(timeSlot);
        return true;
    }

    // Get provider availability
    public List<String> getAvailability(String provider) {
        return providerSlots.getOrDefault(provider, new CopyOnWriteArrayList<>());
    }
}