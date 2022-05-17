package com.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class CountDemo {
    public static void main(String[] args) {
        var alice = Path.of("src/test/resources/source.json");
        try {
            long count = Files.lines(alice)
                    .flatMap(l -> Stream.of(l.split("")))
                    .filter(s -> s.equals("a"))
                    .count();
            System.out.println("'a's seen: "+ count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
