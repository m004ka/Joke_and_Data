package org.example.Joke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class JokeFile {

    private static final String JOKE_FILE_NAME = "joke.java";
    private static final String HELLO_WORLD_CODE = """
            public class joke {
                public static void main(String[] args) {
                     System.out.println("Hello, World!");
                }
            }""";

    public static File generateJokeFile(Path directory) throws IOException{
        File jokeFile = new File(directory.toFile(), JOKE_FILE_NAME);
        try (FileWriter writer = new FileWriter(jokeFile)) {
            writer.write(HELLO_WORLD_CODE);
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла " + jokeFile.getAbsolutePath() + ": " + e.getMessage());
            throw e;
        }

        return jokeFile;
    }
}
