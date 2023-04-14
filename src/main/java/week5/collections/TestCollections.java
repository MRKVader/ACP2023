package week5.collections;

import java.util.*;
import java.util.concurrent.*;

public class TestCollections {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        List <Integer> synchrList = Collections.synchronizedList(list);

        Map<Integer, String> synchrMap = new ConcurrentHashMap<>();

        ExecutorService service = Executors.newFixedThreadPool(50);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        synchrMap.put(j, "dsdssd");
                    }
                }
            });
            service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        synchrMap.remove(j);
                    }
                }
            });
            service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        synchrMap.get(j);
                    }
                }
            });
        }

        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }
}
