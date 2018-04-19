package ru.sbt.jschool.session7.problem2.task2_and_3;

public class Lock {
    private final int capacity;
    private volatile int i = 1;

    public Lock(int capacity) {
        this.capacity = capacity;
    }

    public int next() {
        i = ++i > capacity ? 1 : i;
        return i;
    }

    public int getI() {
        return this.i;
    }
}
