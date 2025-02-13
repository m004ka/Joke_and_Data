package org.example.Data.CSV;

import org.example.Data.People.People;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class CSVWrite extends CSV {

    private final String form = "id|name|waterCountDay|waterCountNight|gasCount|electroCountDay|electroCountNight";

    public CSVWrite(Path dirPath) {
        super(dirPath);
    }


    public void writeFilePeople(Path fileName, List<People> people) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dirPath + File.separator + fileName))) {
            writer.write(form);
            writer.newLine();
            for (People user : people) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Не удалось произвести запись в файл");
        }

    }
}
