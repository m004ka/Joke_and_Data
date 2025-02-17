package org.example.telegram;

import java.util.List;

public interface ReportGenerator {
    String reportHistory(List<Report> reports, String studentUserName, int count);

}
