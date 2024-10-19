public class SumWithoutThreads {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        long total = 0;
        for (int i = 1; i <= 10000000; i++) {
            total += i;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total without threads: " + total);
        System.out.println("Execution time without threads: " + (endTime - startTime) + " milliseconds");
    }
}
