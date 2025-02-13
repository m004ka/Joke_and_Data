package org.example.Data.CSV;

import org.example.Data.People.People;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVPharse extends CSV {


    public CSVPharse(Path dirPath) {
        super(dirPath);
    }

    public List<People> parseFilePeople(Path fileName) {
        List<People> people = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(dirPath + File.separator + fileName))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] val = line.split("\\|");
                People user = new People(
                        Integer.parseInt(val[0]),
                        val[1],
                        Integer.parseInt(val[2]),
                        Integer.parseInt(val[3]),
                        Integer.parseInt(val[4]),
                        Integer.parseInt(val[5]),
                        Integer.parseInt(val[6]));
                people.add(user);
            }

        } catch (IOException e) {
            throw new RuntimeException("Не удалось открыть файл");
        }
        return people;
    }
}
