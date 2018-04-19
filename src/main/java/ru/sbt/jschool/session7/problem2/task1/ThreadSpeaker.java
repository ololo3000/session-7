package ru.sbt.jschool.session7.problem2.task1;

public class ThreadSpeaker implements Runnable {
    private int i;

    public ThreadSpeaker(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        if (i == 50) {
            System.out.println("Hello from thread " + i);
            return;
        }

        Thread thread = new Thread(new ThreadSpeaker(i + 1));
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello from thread " + i);
    }

    public static void main(String[] args) {
        Thread speaker = new Thread(new ThreadSpeaker(1));
        speaker.start();
        try {
            speaker.join();
        } catch (InterruptedException e) {
            new RuntimeException(e);
        }
    }

}
