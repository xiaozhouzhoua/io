package com.io;

import java.io.File;

public class MkdirDemo {
    public static void main(String[] args) {
        var homedir = new File(System.getProperty("user.home"));
        var file = new File(homedir, "app.conf");
        if (file.exists() && file.isFile() && file.canRead()) {
            // Create a file object for a new configuration directory
            var configdir = new File(file, ".configdir");
            configdir.mkdir();
            // Finally, move the config file to its new home
            file.renameTo(new File(configdir, ".configs"));
        }
    }
}
