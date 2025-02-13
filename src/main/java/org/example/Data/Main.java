package org.example.Data;

import org.example.Data.CSV.CSVPharse;
import org.example.Data.CSV.CSVWrite;
import org.example.Data.People.EcoChecker;
import org.example.Data.People.EcoUsersFilter;
import org.example.Data.People.People;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void checkPath(Path file) throws IOException {
        if (!Files.exists(file) || Files.isDirectory(file)) {
            throw new IOException("Путь не существует или не является путем к файлу");
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Введите абсолютный путь до папки: ");
        Scanner sc = new Scanner(System.in);
        String InputFilePath = sc.nextLine();

        System.out.print("Введите максимальное потребление ресурса: ");
        int maxConsumption = sc.nextInt();
        sc.nextLine();
        Path inputFile = Paths.get(InputFilePath);
        checkPath(inputFile);

        CSVPharse csvRead = new CSVPharse(inputFile.getParent());
        List<People> people = csvRead.parseFilePeople(inputFile.getFileName());

        EcoUsersFilter checker = new EcoUsersFilter(new EcoChecker());
        List<People> ecoPeople = checker.getEcoUsers(people, maxConsumption);

        CSVWrite csvWriter = new CSVWrite(inputFile.getParent());
        csvWriter.writeFilePeople(Path.of("eco_data.csv"), ecoPeople);
    }

}
