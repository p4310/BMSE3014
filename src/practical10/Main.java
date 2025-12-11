package practical10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ReportGenerator generator = new ReportGenerator();

        // --- Test Data 1 ---
        List<Map<String, Object>> data1 = new ArrayList<>();
        Map<String, Object> row1 = new HashMap<>();
        row1.put("name", "Alice");
        row1.put("age", 30);
        row1.put("city", "New York");
        data1.add(row1);

        // --- Test Data 2 ---
        List<Map<String, Object>> data2 = new ArrayList<>();
        Map<String, Object> row2a = new HashMap<>();
        row2a.put("name", "Bob");
        row2a.put("age", 25);
        row2a.put("city", "Los Angeles");
        Map<String, Object> row2b = new HashMap<>();
        row2b.put("name", "Carol");
        row2b.put("age", 28);
        row2b.put("city", "Chicago");
        data2.add(row2a);
        data2.add(row2b);

        // --- Test Data 3 ---
        List<Map<String, Object>> data3 = new ArrayList<>();
        Map<String, Object> row3 = new HashMap<>();
        row3.put("name", "David");
        row3.put("age", 35);
        row3.put("city", "San Francisco");
        data3.add(row3);

        System.out.println("=== Test Data 1 ===");
        System.out.println(generator.generate("pdf", data1));
        System.out.println(generator.generate("csv", data1));
        System.out.println(generator.generate("xml", data1));

        System.out.println("\n=== Test Data 2 ===");
        System.out.println(generator.generate("pdf", data2));
        System.out.println(generator.generate("csv", data2));
        System.out.println(generator.generate("xml", data2));

        System.out.println("\n=== Test Data 3 ===");
        System.out.println(generator.generate("pdf", data3));
        System.out.println(generator.generate("csv", data3));
        System.out.println(generator.generate("xml", data3));
    }
}
