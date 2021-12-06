package ru.venediktov.javacore.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizedExample {

    private static final int NUM_INCREMENTS = 10000;

    private static int count = 0;

    public void execute() {
        System.out.println("SynchronizedExample");
        testSyncIncrement();
        testNonSyncIncrement();
    }

    private static void testSyncIncrement() {
        count = 0;

        ExecutorService executor = Executors.newFixedThreadPool(3);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executor.submit(SynchronizedExample::incrementSync));

        SynchronizedExample.stop(executor);

        System.out.println("   Sync: " + count);
    }

    private static void testNonSyncIncrement() {
        count = 0;

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executor.submit(SynchronizedExample::increment));

        SynchronizedExample.stop(executor);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("NonSync: " + count);
    }

    private static synchronized void incrementSync() {
        count = count + 1;
    }

    private static void increment() {
        count = count + 1;
    }

    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }
}
