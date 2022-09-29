package tutes.oop4;

import java.util.Scanner;

public class SingleThread {
    private final static int MAX = 200000;

    private volatile static int maxDivisorCount = 0;

    private volatile static int intWithMaxDivisorCount;

    synchronized private static void report(int maxCountFromThread,
                                            int intWithMaxFromThread) {
        if (maxCountFromThread > maxDivisorCount) {
            maxDivisorCount = maxCountFromThread;
            intWithMaxDivisorCount = intWithMaxFromThread;
        }
    }

    private static class CountDivisorsThread extends Thread {
        int min, max;
        public CountDivisorsThread(int min, int max) {
            this.min = min;
            this.max = max;
        }
        public void run() {
//         System.out.println("Thread " + this + " testing range " +
//               min + " to " + max);  // For testing.
//         long startTime = System.currentTimeMillis();
            int maxDivisors = 0;
            int whichInt = 0;
            for (int i = min; i < max; i++) {
                int divisors = countDivisors(i);
                if (divisors > maxDivisors) {
                    maxDivisors = divisors;
                    whichInt = i;
                }
            }
//         long elapsedTime = System.currentTimeMillis() - startTime;
//         System.out.println("Thread " + this + " used " +
//               (elapsedTime/1000.0) + " seconds.");   // for testing.
            report(maxDivisors,whichInt);
        }
    }

    private static void countDivisorsWithThreads(int numberOfThreads) {
        System.out.println("\nCounting divisors using " +
                numberOfThreads + " threads...");
        long startTime = System.currentTimeMillis();
        CountDivisorsThread[] worker = new CountDivisorsThread[numberOfThreads];
        int integersPerThread = MAX/numberOfThreads;
        int start = 1;  // Starting point of the range of ints for first thread.
        int end = start + integersPerThread - 1;   // End point of the range of ints.
        for (int i = 0; i < numberOfThreads; i++) {
            if (i == numberOfThreads - 1) {
                end = MAX;  // Make sure that the last thread's range goes all
                // the way up to MAX.  Because of rounding, this
                // is not automatic.
            }
            worker[i] = new CountDivisorsThread( start, end );
            start = end+1;    // Determine the range of ints for the NEXT thread.
            end = start + integersPerThread - 1;
        }
        maxDivisorCount = 0;
        for (int i = 0; i < numberOfThreads; i++)
            worker[i].start();
        for (int i = 0; i < numberOfThreads; i++) {
            // Wait for each worker thread to die, because the results
            // are not complete until all threads have completed and
            // reported their results.
            while (worker[i].isAlive()) {
                try {
                    worker[i].join();
                }
                catch (InterruptedException e) {
                }
            }
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("\nThe largest number of divisors " +
                "for numbers between 1 and " + MAX + " is " + maxDivisorCount);
        System.out.println("An integer with that many divisors is " +
                intWithMaxDivisorCount);
        System.out.println("Total elapsed time:  " +
                (elapsedTime/1000.0) + " seconds.\n");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfThreads = 0;
        while (numberOfThreads < 1 || numberOfThreads > 10) {
            System.out.print("How many threads do you want to use  (1 to 10) ?  ");
            numberOfThreads = in.nextInt();
            if (numberOfThreads < 1 || numberOfThreads > 10)
                System.out.println("Please enter a number from 1 to 10 !");
        }
        countDivisorsWithThreads(numberOfThreads);
    }

    /**
     * Finds the number of divisors of the integer N.  Note that this method does
     * the counting in a stupid way, since it tests every integer in the range
     * 1 to N to see whether it evenly divides N.
     */
    public static int countDivisors(int N) {
        int count = 0;
        for (int i = 1; i <= N ; i++) {
            if ( N % i == 0 )
                count ++;
        }
        return count;
    }
}
