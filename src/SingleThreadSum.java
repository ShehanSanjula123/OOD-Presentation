public class SingleThreadSum {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long sum = 0;
        for (int i = 1; i <= 10000000; i++) {
            sum += i;
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // convert to milliseconds
        System.out.println("Single-threaded sum: " + sum);
        System.out.println("Execution time: " + duration + " ms");
    }
}
