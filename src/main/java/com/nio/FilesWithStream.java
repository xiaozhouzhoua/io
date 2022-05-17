package com.nio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FilesWithStream {
    public static void main(String[] args) throws IOException {
        var cs = StandardCharsets.UTF_8;
        var target = Path.of("src/test/resources/source.json");
        try (BufferedReader br = Files.newBufferedReader(target, cs);
             BufferedWriter bwr = Files.newBufferedWriter(target, cs);
             InputStream is = Files.newInputStream(target);
             OutputStream os = Files.newOutputStream(target);
             var writer = Files.newBufferedWriter(target, StandardCharsets.UTF_8, StandardOpenOption.WRITE)
        ) {
            writer.write("123");
        }
    }
}
