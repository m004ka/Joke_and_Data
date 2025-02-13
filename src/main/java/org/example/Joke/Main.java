package org.example.Joke;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {


    public static void checkPath(File file) throws IOException {
        if (!file.exists() && !file.isDirectory()) {
            throw new IOException("Путь не существует или не является директорией");
        }
    }


    public static void main(String[] args) throws IOException {

        System.out.print("Введите абсолютный путь до папки: ");

        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        File file = new File(path);
        checkPath(file);

        JokeFileVisitor fileVisitor = new JokeFileVisitor();
        Files.walkFileTree(file.toPath(), fileVisitor);
    }
}
