package org.example.telegram;

import java.util.List;

public interface SpecificReportFilter {
    List<Report> specificStudentReports(List<Report> reports, String studentUserName);
}
