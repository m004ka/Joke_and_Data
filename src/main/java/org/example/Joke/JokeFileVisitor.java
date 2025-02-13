package org.example.Joke;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

public class JokeFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        JokeFile.generateJokeFile(dir);
        return FileVisitResult.CONTINUE;
    }
}
