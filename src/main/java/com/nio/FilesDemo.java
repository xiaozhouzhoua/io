package com.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class FilesDemo {

    private static final String FILE_NAME = "src/test/resources/fileToCreate.txt";
    private static final String FILE_NAME_1 = "src/test/resources/source.json";
    private static final String FILE_NAME_2 = "src/test/resources/target.json";

    public static void main(String[] args) throws IOException {
        Path source = Path.of(FILE_NAME_1);
        Path target = Path.of(FILE_NAME_2);

        // Files.createFile(Path.of(FILE_NAME));
        // Files.delete(target);
        // boolean deleted = Files.deleteIfExists(source);

        Files.copy(source, target);
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        // Files.move(source, target);

        long size = Files.size(target);

        FileTime lastModifiedTime = Files.getLastModifiedTime(target);
        System.out.println(lastModifiedTime.to(TimeUnit.SECONDS));

        Map<String, Object> attrs = Files.readAttributes(source, "*");
        System.out.println(attrs);

        boolean isDir = Files.isDirectory(target);
        boolean isLnk = Files.isSymbolicLink(target);

        Charset cs = StandardCharsets.UTF_8;
        List<String> lines = Files.readAllLines(source, cs);
        byte[] bytes = Files.readAllBytes(source);

        Stream<String> stringStream = Files.lines(source, cs);
    }
}
