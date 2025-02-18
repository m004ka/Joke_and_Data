package org.example.telegram;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {

    static final String SEPARATOR = "\n-----------------\n";

    public String reportHistory(List<Report> reports, String studentUserName, int count) {

        return reports.stream()
                .filter(report -> Objects.equals(report.getStudentUserName(), studentUserName))
                .limit(count)
                .map(Report::toString)
                .collect(Collectors.joining(SEPARATOR));
    }
}
