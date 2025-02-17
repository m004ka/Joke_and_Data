package org.example.telegram;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Report {

    public Report(String studentUserName, Integer hours, LocalDate date, String title) {
        this.studentUserName = studentUserName;
        this.hours = hours;
        this.date = date;
        this.title = title;
    }

    private Long id;

    private String studentUserName;

    private Integer hours;

    private LocalDate date;

    private String title;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(studentUserName + "\n");
        str.append(date + "\n");
        str.append(hours + "\n");
        str.append(title);

        return str.toString();
    }
}
