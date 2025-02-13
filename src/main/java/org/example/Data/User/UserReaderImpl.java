package org.example.Data.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserReaderImpl implements UserReader {
    public UserReaderImpl(Path path) {
        this.path = path;
    }

    protected Path path;

    @Override
    public List<User> read() {
        List<User> ecoUsers = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] val = line.split("\\|");
                User user = new User(
                        Integer.parseInt(val[0]),
                        val[1],
                        Integer.parseInt(val[2]),
                        Integer.parseInt(val[3]),
                        Integer.parseInt(val[4]),
                        Integer.parseInt(val[5]),
                        Integer.parseInt(val[6]));
                ecoUsers.add(user);
            }

        } catch (IOException e) {
            throw new RuntimeException("Не удалось открыть файл");
        }
        return ecoUsers;
    }
}
