package org.example.Data;

import org.example.Data.User.*;

import java.io.File;
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
        String inputFilePath = sc.nextLine();

        System.out.print("Введите максимальное потребление ресурса: ");
        int maxConsumption = sc.nextInt();
        sc.nextLine();
        Path inputFile = Paths.get(inputFilePath);
        checkPath(inputFile);

        UserReader Reader = new UserReaderImpl(inputFile);
        List<User> users = Reader.read();

        UserFilter Filter = new UserFilterImpl(maxConsumption);
        List<User> ecoUsers = Filter.filter(users);

        Path outputFilePath = Path.of(inputFile.getParent() + File.separator + "eco_data.csv");
        UserWriter writer = new UserWriterImpl(outputFilePath);
        writer.write(ecoUsers);
    }

}
