package org.example.telegram;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpecificReportFilterImpl implements SpecificReportFilter {
    public List<Report> specificStudentReports(List<Report> reports, String studentUserName) {
        List<Report> specific = new ArrayList<>();
        for (Report report : reports) {
            if (Objects.equals(report.getStudentUserName(), studentUserName)) {
                specific.add(report);
            }
        }
        return specific;
    }
}
