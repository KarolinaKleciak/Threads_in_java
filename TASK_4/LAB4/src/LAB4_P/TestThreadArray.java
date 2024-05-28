package LAB4_P;

import java.util.Random;

public class TestThreadArray {
    public static void main(String[] args) throws InterruptedException {

        final int numberOfThread = 1;
        final int size = 400000000;
        int[] tabInt = new int[size];
        Random randInt = new Random();

        for (int i = 0; i < size - 1; i++) {
            tabInt[i] = randInt.nextInt(10000000);
        }

        ThreadInt[] thread1s = new ThreadInt[numberOfThread];
        //System.out.println("Started of searches!");
        long time1 = System.nanoTime();
        int interval = size / numberOfThread;
        int currentCapacity = 0;

        for (int i = 0; i < numberOfThread; i++) {
            thread1s[i] = new ThreadInt(("Thread nr: " + i), (currentCapacity + interval - 1), (currentCapacity), tabInt);
            //System.out.println("Filling threads: " + thread1s[i].getName() + " " + thread1s[i].getMinSize() + " " + thread1s[i].getMaxSize());
            currentCapacity += interval;
        }

        for (int i = 0; i < numberOfThread; i++) {
            thread1s[i].join();
        }

        int max1 = thread1s[0].getMax();
        int min1 = thread1s[0].getMin();
        for (int i = 0; i < numberOfThread; i++) {
            if (thread1s[i].getMax() > max1) max1 = thread1s[i].getMax();
            if (thread1s[i].getMin() < min1) min1 = thread1s[i].getMin();
        }

        long times2 = System.nanoTime();
        //System.out.println("End of the searches!");
        long timeSpent = times2 - time1;

        System.out.println("The time of the sorted in int array is: " + timeSpent / 1000000 + "ns" + ", Min: " + min1 + ", Max: " + max1);


        double[] tabDouble = new double[size];
        Random randDouble = new Random();

        for (int i = 0; i < size - 1; i++) {
            tabDouble[i] = randDouble.nextDouble(10000000);
        }


        ThreadDouble[] thread2s = new ThreadDouble[numberOfThread];
        //System.out.println("Started of searches!");
        long time2D = System.nanoTime();
        int interval2 = size / numberOfThread;
        int currentCapacity2 = 0;

        for (int i = 0; i < numberOfThread; i++) {
            thread2s[i] = new ThreadDouble(("Thread nr: " + i), (currentCapacity2 + interval2 - 1), (currentCapacity2), tabDouble);
            //System.out.println("Filling threads: " + thread1s[i].getName() + " " + thread1s[i].getMinSize() + " " + thread1s[i].getMaxSize());
            currentCapacity2 += interval2;
        }

        for (int i = 0; i < numberOfThread; i++) {
            thread2s[i].join();
        }

        double max2 = thread2s[0].getMax();
        double min2 = thread2s[0].getMin();
        for (int i = 0; i < numberOfThread; i++) {
            if (thread2s[i].getMax() > max2) max2 = thread2s[i].getMax();
            if (thread2s[i].getMin() < min2) min2 = thread2s[i].getMin();
        }

        long times2Double = System.nanoTime();
        //System.out.println("End of the searches!");
        long timeSpent2 = times2Double - time2D;

        System.out.println("The time of the sorted in double array is: " + timeSpent2 / 1000000 + "ns" + ", Min: " + min2 + ", Max: " + max2);
    }
}
