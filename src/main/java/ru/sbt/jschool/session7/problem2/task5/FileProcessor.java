package ru.sbt.jschool.session7.problem2.task5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor implements Runnable {
    @Override
    public void run() {
        while (true) {
            File file;
            int wordCount = 0;

            try {
                file = FileQueue.getInstance().take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    wordCount += line.split("\\s").length;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(file.getName() + ": " + wordCount);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread loader1 = new Thread(new FileLoader("/"));
        Thread processor = new Thread(new FileProcessor());

        loader1.start();
        processor.start();
        loader1.join();
        processor.join();
    }
}
