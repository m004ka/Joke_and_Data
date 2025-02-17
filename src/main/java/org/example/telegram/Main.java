package org.example.telegram;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Report report1 = new Report("Ren", 5, LocalDate.now(), "Учился жоска");
        Report report2 = new Report("Ren", 6, LocalDate.now(), "Учился жоска1");
        Report report3 = new Report("Ren", 7, LocalDate.now(), "Учился жоска2");
        Report report4 = new Report("Ren", 8, LocalDate.now(), "Учился жоска3");

        Report report5 = new Report("Danone", 5, LocalDate.now(), "Учился жоска");
        Report report6 = new Report("Danone", 6, LocalDate.now(), "Учился жоска1");
        Report report7 = new Report("Danone", 7, LocalDate.now(), "Учился жоска2");
        Report report8 = new Report("Tevzadze", 8, LocalDate.now(), "Учился жоска");

        List<Report> reports = new ArrayList<>();
        reports.add(report1);
        reports.add(report2);
        reports.add(report3);
        reports.add(report4);
        reports.add(report5);
        reports.add(report6);
        reports.add(report7);
        reports.add(report8);


        ReportGenerator repService = new ReportGeneratorImpl();


//        String report = repService.reportHistory(reports, "Tevzadze", 3);
//        System.out.println(report);
//
//        String report = repService.reportHistory(reports, "Ren", 3);
//        System.out.println(report);
//
        String report = repService.reportHistory(reports, "Ren", 3);
        System.out.println(report);

//        String report = repService.reportHistory(reports, "Danone", 1);
//        System.out.println(report);

    }
}
