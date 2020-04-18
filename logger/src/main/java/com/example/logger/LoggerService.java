package com.example.logger;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Service
public class LoggerService {
    private final String FILE_NAME = "LOGGER.txt";
    private final Path file = Paths.get(FILE_NAME);

    public void writeToFile(String string) throws IOException {
        Files.write(file, List.of(string), StandardCharsets.UTF_8, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }
}
