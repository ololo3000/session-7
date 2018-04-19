package ru.sbt.jschool.session7.problem2.task2_and_3;

public class Speaker implements  Runnable {
    private Lock lock;
    private int i;

    public Speaker(Lock lock, int i) {
        this.i = i;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                while (lock.getI() != i) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        throw new RuntimeException(i + " terminated");
                    }
                }

                System.out.println(i);
                lock.next();
                lock.notifyAll();
            }
        }
    }

    static public void main(String[] args) {
        int cap = 4;
        Lock lock = new Lock(cap);
        for (int i = 1; i <= cap; i++) {
            Thread thread = new Thread(new Speaker(lock, i));
            thread.start();
        }

    }

}
