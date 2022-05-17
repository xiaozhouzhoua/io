package com.nio;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class PathDemo {
    public static void main(String[] args) throws URISyntaxException {
        var p = Path.of("/Users/zhouguangping/Code/io/src/test/resources/source.json");
        var p2 = Path.of(new URI("file:///Users/zhouguangping/Code/io/src/test/resources/source.json"));
        System.out.println(p2.equals(p));
    }
}
