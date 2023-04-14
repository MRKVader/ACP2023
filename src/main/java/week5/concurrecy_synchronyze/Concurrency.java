package week5.concurrecy_synchronyze;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Concurrency {
    static final Logger LOG = Logger.getLogger(Concurrency.class.getName());
    private static int operationCount = 1000;

    public static void main(String[] args) {
        //TODO logging
        LOG.setLevel(Level.INFO);
        LOG.addHandler(new ConsoleHandler());
        IContainer container = new Container();

        long start = System.currentTimeMillis();

        ExecutorService service = Executors.newFixedThreadPool(20);


        for (int i = 0; i < 10; i++) {
            service.submit(new IncThread(container, operationCount));
            service.submit(new DecrThread(container, operationCount));
        }

        service.shutdown();
        while (!service.isTerminated()) {
            try {
                service.awaitTermination(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(container.getCount());

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}

class IncThread implements Runnable {

    private IContainer container;
    private int operationCount;

    public IncThread(IContainer container, int operationCount) {
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

    private IContainer container;
    private int operationCount;

    public DecrThread(IContainer container, int operationCount) {
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

interface IContainer {
    void inc();

    void decr();

    int getCount();
}

class Container implements IContainer {

    private volatile int count;

    private Lock lock = new ReentrantLock(true);
    private Condition producerCond = lock.newCondition();
    private Condition consumerCond = lock.newCondition();

    @Override
    public void inc() {
        try {
            lock.lock();
            System.out.printf("inc count %d, thread %s - monitor\n", count, Thread.currentThread());
            while (count != 0) {
                try {
                    System.out.printf("inc count %d, thread %s - sleep\n", count, Thread.currentThread());
                    producerCond.await();
                    System.out.printf("inc count %d, thread %s - awake\n", count, Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            consumerCond.signalAll();
            System.out.printf("inc count %d, thread %s - release\n", count, Thread.currentThread());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void decr() {
        try {
            lock.lock();
            System.out.printf("decr count %d, thread %s - monitor\n", count, Thread.currentThread());
            while (count != 0) {
                try {
                    System.out.printf("decr count %d, thread %s - sleep\n", count, Thread.currentThread());
                    consumerCond.await();
                    System.out.printf("decr count %d, thread %s - awake\n", count, Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            producerCond.signal();
            System.out.printf("decr count %d, thread %s - release\n", count, Thread.currentThread());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
