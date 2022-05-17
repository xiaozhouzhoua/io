package com.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 使用旧的文件流
 */
public class FilesCopyWithStream {
    public static void main(String[] args) {
        var inputFile = new File("src/test/resources/source.json");
        try (var in = new FileInputStream(inputFile)) {
            Files.copy(in, Paths.get("src/test/resources/target.json"));
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
