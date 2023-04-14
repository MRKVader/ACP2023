package week5.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConcurrencyAtomic {
    static final Logger LOG = Logger.getLogger(ConcurrencyAtomic.class.getName());
    private static int operationCount = 100000;

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

    private volatile AtomicInteger count = new AtomicInteger();

    @Override
    public void inc() {
        int temp = count.incrementAndGet();
//        System.out.println(temp);
    }

    @Override
    public void decr() {
       int temp = count.decrementAndGet();
//        System.out.println(temp);
    }

    @Override
    public int getCount() {
        return count.get();
    }
}
