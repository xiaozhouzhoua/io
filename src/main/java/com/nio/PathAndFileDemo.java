package com.nio;

import java.io.File;
import java.nio.file.Path;

public class PathAndFileDemo {
    public static void main(String[] args) {
        var p = Path.of("src/test/resources/source.json");

        File f = p.toFile();
        System.out.println(f.getName());

        Path p2 = f.toPath();
        System.out.println(p2.equals(p));
    }
}
