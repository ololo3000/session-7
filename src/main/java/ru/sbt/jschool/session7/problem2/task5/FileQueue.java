package ru.sbt.jschool.session7.problem2.task5;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class FileQueue {
    private static BlockingQueue<File> instance = new LinkedBlockingQueue<>();

    public static BlockingQueue<File> getInstance() {
        return instance;
    }
}
