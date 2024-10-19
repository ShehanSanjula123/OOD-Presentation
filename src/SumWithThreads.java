import java.util.ArrayList;
import java.util.List;

public class SumWithThreads {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 4;
        int n = 10000000;
        long[] results = new long[numThreads];
        List<Thread> threads = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        int segmentSize = n / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int start = i * segmentSize + 1;
            int end = (i == numThreads - 1) ? n : (i + 1) * segmentSize;
            final int index = i;

            Thread thread = new Thread(() -> {
                long segmentSum = 0;
                for (int j = start; j <= end; j++) {
                    segmentSum += j;
                }
                results[index] = segmentSum;
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long total = 0;
        for (long result : results) {
            total += result;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total with threads: " + total);
        System.out.println("Execution time with threads: " + (endTime - startTime) + " milliseconds");
    }
}
