package practical10;

import java.util.List;
import java.util.Map;

public class ReportGenerator {

    public String generate(String reportType, List<Map<String, Object>> data) {
        System.out.println("Starting report generation...");

        // Format data
        String formatted;
        if (reportType.equals("pdf")) {
            formatted = "PDF::" + data.toString();
        } else if (reportType.equals("csv")) {
            StringBuilder sb = new StringBuilder();
            for (Map<String, Object> row : data) {
                sb.append(String.join(",", row.values().toString())).append("\n");
            }
            formatted = sb.toString();
        } else if (reportType.equals("xml")) {
            StringBuilder sb = new StringBuilder("<items>");
            for (Map<String, Object> row : data) {
                sb.append("<item>").append(row.get("name")).append("</item>");
            }
            sb.append("</items>");
            formatted = sb.toString();
        } else {
            throw new RuntimeException("Unknown report type");
        }

        // Saving file (mock)
        String fileName = reportType + "_report";
        System.out.println("Saving file: " + fileName);

        // Auditing
        System.out.println("AUDIT: Report generated at " + System.currentTimeMillis());

        return formatted;
    }
}
