package com.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleCopyDemo {
    public static void main(String[] args) {
        var input = Path.of("input.txt");
        var output = Path.of("output.txt");

        try {
            Files.copy(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
