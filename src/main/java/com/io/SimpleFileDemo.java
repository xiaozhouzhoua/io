package com.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class SimpleFileDemo {
    public static void main(String[] args) throws IOException {
        File f = new File("src/test/resources/source.json");

        // 权限
        boolean canX = f.canExecute();
        boolean canR = f.canRead();
        boolean canW = f.canWrite();

//        boolean ok;
//        ok = f.setReadOnly();
//        ok = f.setExecutable(true);
//        ok = f.setReadable(true);
//        ok = f.setWritable(true);

        // 文件信息
        File absoluteFile = f.getAbsoluteFile();
        File canonicalFile = f.getCanonicalFile();
        System.out.println(absoluteFile);
        System.out.println(canonicalFile);

        String absName = f.getAbsolutePath();
        String canName = f.getCanonicalPath();
        System.out.println(absName);
        System.out.println(canName);

        String name = f.getName();
        String pName = f.getParent();
        URI fileURI = f.toURI();
        System.out.println(name);
        System.out.println(pName);
        System.out.println(fileURI);

        boolean exists = f.exists();
        boolean isAbs = f.isAbsolute();
        boolean isDir = f.isDirectory();
        boolean isFile = f.isFile();
        boolean isHidden = f.isHidden();
        long modTime = f.lastModified(); // millis since epoch
        long fileLen = f.length();

        // 文件操作
        boolean renamed = f.renameTo(new File("backup.json"));
        boolean deleted = f.delete();

        boolean createdOK = f.createNewFile();

        File tmp = File.createTempFile("my-tmp", ".tmp");
        tmp.deleteOnExit();

        File dir = new File("src/test/resources/");
        boolean createdDir = dir.mkdir();
        String[] fileNames = dir.list();
        File[] files = dir.listFiles();
    }
}
