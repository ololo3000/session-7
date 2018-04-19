package ru.sbt.jschool.session7.problem2.task5;

import java.io.File;
import java.lang.reflect.Field;

public class FileLoader implements Runnable {
    private String dirPath;

    public FileLoader(String dirPath) {
        this.dirPath = dirPath;
    }

    @Override
    public void run() {
        File dir = new File(dirPath);
        if(!dir.isDirectory()) {
            return;
        }

        for (File f : dir.listFiles()) {
            if (f.isFile()) {
                try {
                    FileQueue.getInstance().put(f);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
