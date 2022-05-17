package com.io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileStreamDemo {
    public static void main(String[] args) {
        try (var is = new FileInputStream("src/test/resources/source.json")) {
            var buf = new byte[4096];
            int len, count = 0;
            while ((len = is.read(buf)) > 0) {
                for (var i = 0; i < len; i = i + 1)
                    if (buf[i] == 97) {
                        count = count + 1;
                    }
            }
            System.out.println("a总数: "+ count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
