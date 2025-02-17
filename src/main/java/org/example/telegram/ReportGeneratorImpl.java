package org.example.telegram;

import java.util.List;
import java.util.Objects;

public class ReportGeneratorImpl implements ReportGenerator {

    static final String SEPARATOR = "\n-----------------\n";

    public String reportHistory(List<Report> reports, String studentUserName, int count) {
        StringBuilder text = new StringBuilder();

        reports.stream()
                .filter(report -> Objects.equals(report.getStudentUserName(), studentUserName))
                .limit(count)
                .forEach(report -> {
                    if (!text.isEmpty()) {
                        text.append(SEPARATOR);
                    }
                    text.append(report);
                });

        return text.toString();
    }

}
