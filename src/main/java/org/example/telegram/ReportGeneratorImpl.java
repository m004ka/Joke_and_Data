package org.example.telegram;

import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {

    SpecificReportFilter filter = new SpecificReportFilterImpl();
    static final String SEPARATOR = "\n-----------------\n";

    public String reportHistory(List<Report> reports, String studentUserName, int count) {
        var filterReports = filter.specificStudentReports(reports, studentUserName);
        StringBuilder text = new StringBuilder();
        if (count > filterReports.size()) {
            count = filterReports.size();
        }
        for (int i = 0; i < count; i++) {
            text.append(filterReports.get(i).toString());
            if (i + 1 != count) {
                text.append(SEPARATOR);
            }
        }
        return text.toString();
    }
}
