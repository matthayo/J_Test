import java.util.Scanner;

public class ThreadTest2 {

    private static final int START = 3000000;

    private static int total;

    synchronized private static void addToTotal(int x) {
        total = total + x;
        System.out.println(total + " primes found so far.");
    }

    private static class CountPrimesThread extends Thread {
        int count = 0;
        int min, max;
        public CountPrimesThread(int min, int max) {
            this.min = min;
            this.max = max;
        }
        public void run() {
            count = countPrimes(min,max);
            System.out.println("There are " + count + 
                    " primes between " + min + " and " + max);
            addToTotal(count);
        }
    }

    private static void countPrimesWithThreads(int numberOfThreads) {
        int increment = START/numberOfThreads * 2;
        
        System.out.println("\nCounting primes between " + (START+1) + " and " 
                + (3*START) + " using " + numberOfThreads + " threads...\n");
       
        long startTime = System.currentTimeMillis();
        
        CountPrimesThread[] worker = new CountPrimesThread[numberOfThreads];
        
        for (int i = 0; i < numberOfThreads; i++)
            worker[i] = new CountPrimesThread( START+(i*increment)+1, START+(i+1)*increment );
        
        total = 0;
        
        for (int i = 0; i < numberOfThreads; i++)
            worker[i].start();
        
        for (int i = 0; i < numberOfThreads; i++) {
            while (worker[i].isAlive()) {
                try {
                    worker[i].join();
                }
                catch (InterruptedException e) {
                }
            }
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("\nThe number of primes is " + total + ".");
        System.out.println("\nTotal elapsed time:  " + (elapsedTime/1000.0) + " seconds.\n");
    }

    /**
     * Gets the number of threads from the user and counts primes using that many threads.
     */
    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
    	
        int processors = Runtime.getRuntime().availableProcessors();
        if (processors == 1)
            System.out.println("Your computer has only 1 available processor.\n");
        else
            System.out.println("Your computer has " + processors + " available processors.\n");
        int numberOfThreads = 0;
        while (numberOfThreads < 1 || numberOfThreads > 5) {
            System.out.print("How many threads do you want to use  (from 1 to 5) ?  ");
            numberOfThreads = input.nextInt();
            if (numberOfThreads < 1 || numberOfThreads > 5)
                System.out.println("Please enter 1, 2, 3, 4, or 5 !");
        }
        countPrimesWithThreads(numberOfThreads);
    }

    /**
     * Count the primes between min and max, inclusive.
     */
    private static int countPrimes(int min, int max) {
        int count = 0;
        for (int i = min; i <= max; i++)
            if (isPrime(i))
                count++;
        return count;
    }

    /**
     * Test whether x is a prime number.
     * x is assumed to be greater than 1.
     */
    private static boolean isPrime(int x) {
        int top = (int)Math.sqrt(x);
        for (int i = 2; i <= top; i++)
            if ( x % i == 0 )
                return false;
        return true;
    }

}
