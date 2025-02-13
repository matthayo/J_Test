
public class ThreadTest1 {
	final static int START = 3000000;
	final static int MAX = 12000000;
    
	public static void main(String[] args) {
    	long startTime = System.currentTimeMillis();
        int count = countPrimes(START,MAX);
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("There are  " + 
                count + " primes. Time taken " + (elapsedTime/1000.0) + " seconds.");
    }

    private static int countPrimes(int min, int max) {
        int count = 0;
        for (int i = min; i <= max; i++)
            if (isPrime(i))
                count++;
        return count;
    }

    private static boolean isPrime(int x) {
        assert x > 1;
        int top = (int)Math.sqrt(x);
        for (int i = 2; i <= top; i++)
            if ( x % i == 0 )
                return false;
        return true;
    }
}

