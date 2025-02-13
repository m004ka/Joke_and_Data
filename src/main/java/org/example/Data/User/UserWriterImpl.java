package org.example.Data.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

public class UserWriterImpl implements UserWriter {

    public UserWriterImpl(Path path) {
        this.path = path;
    }

    Path path;

    @Override
    public void write(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), StandardCharsets.UTF_8))) {
            String form = "id|name|waterCountDay|waterCountNight|gasCount|electroCountDay|electroCountNight";
            writer.write(form);
            writer.newLine();
            for (User user : users) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Не удалось произвести запись в файл");
        }
    }
}
