package ua.goit.andre.ee3phaser;

import java.util.stream.IntStream;

public class SquareSumRunner {
    public static void main(String[] args) {
        final int numElems = 1000;
        final int numThreads = 5;
        int[] arr = new int[numElems];

        IntStream.range(0, numElems).forEach ( i -> arr[i] = i + 1 );

        long result = new SquareSumImpl().getSquareSum(arr,numThreads);
        System.out.println ("Result = " + result);
    }
}
