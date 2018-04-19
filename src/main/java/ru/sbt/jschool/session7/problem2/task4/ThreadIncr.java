package ru.sbt.jschool.session7.problem2.task4;

import java.util.ArrayList;

public class ThreadIncr {
    private static volatile Integer val = 0;
    private static Object lock = new Object();


    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> list = new ArrayList<>();

        for (int i = 0; i < 1_000; i++) {
            val = 0;
            list.clear();

            for (int j = 0; j < 10; j++) {
                Thread thread = th();
                list.add(thread);
                thread.start();
            }

            for (Thread thread : list) {
                thread.join();
            }
            assert val == 100;
            System.out.println("Checked " + i);
        }
    }

    private static Thread th() {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    ++val;
                }
            }
        });
    }


}
