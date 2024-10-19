import java.util.concurrent.*;

public class MultiThreadSum {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int numberOfThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        Future<Long>[] results = new Future[numberOfThreads];
        long range = 10000000 / numberOfThreads;

        long startTime = System.nanoTime();

        for (int i = 0; i < numberOfThreads; i++) {
            final long start = i * range + 1;
            final long end = (i + 1) * range;
            results[i] = executor.submit(() -> {
                long sum = 0;
                for (long j = start; j <= end; j++) {
                    sum += j;
                }
                return sum;
            });
        }

        long totalSum = 0;
        for (Future<Long> result : results) {
            totalSum += result.get();
        }

        executor.shutdown();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // convert to milliseconds

        System.out.println("Multi-threaded sum: " + totalSum);
        System.out.println("Execution time: " + duration + " ms");
    }
}
