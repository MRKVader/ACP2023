package week5.common_resource;

import java.util.ArrayList;
import java.util.List;

public class _01intro {

    private static int operationCount;

    public static void main(String[] args) {
        //TODO logging
        ContainerSpinLock container = new ContainerSpinLock();

        long start = System.currentTimeMillis();

        int operationCount = 1000000;

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(new IncThread(container, operationCount));
            thread1.start();
            Thread thread2 = new Thread(new DecrThread(container, operationCount));
            thread2.start();

            threadList.add(thread1);
            threadList.add(thread2);
        }

        System.out.println(container.getCount());

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}

class IncThread implements Runnable {

    private ContainerSpinLock container;
    private int operationCount;

    public IncThread(ContainerSpinLock container, int operationCount) {
        this.container = container;
        this.operationCount = operationCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < operationCount; i++) {
            container.inc();
        }
    }
}

class DecrThread implements Runnable {

    private ContainerSpinLock container;
    private int operationCount;

    public DecrThread(ContainerSpinLock container, int operationCount) {
        this.container = container;
        this.operationCount = operationCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < operationCount; i++) {
            container.decr();
        }
    }
}

class ContainerSpinLock {

    private volatile int count;

    private Object lock = new Object();

    public void inc() {
        synchronized (lock) {
            count++;
        }
    }

    public void decr() {
        synchronized (lock) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
