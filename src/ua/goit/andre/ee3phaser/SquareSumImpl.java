package ua.goit.andre.ee3phaser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SquareSumImpl implements SquareSum{


    public long getSquareSum(int[] values, int numberOfThreads) {
        final int startOffset = values.length / numberOfThreads;
        Phaser phaser = new Phaser (numberOfThreads);

        List<Callable<Long>> callables = new ArrayList<> ();
        IntStream.range(0, numberOfThreads).forEach ( i -> callables.add(() -> {
            phaser.register ();
            phaser.arrive ();
            long res = 0L;
            int startIndex = i * startOffset;
            int endIndex;
            if ((i+1) == numberOfThreads) {
                endIndex = values.length;
            } else{
                endIndex = (i + 1) * startOffset;
            }
            for (int j = startIndex; j < endIndex; j++) {
                res += Math.pow (values[j], 2);
            }
            //Thread.sleep ( i*100 );
            phaser.arriveAndAwaitAdvance ();
            //System.out.println ("Thread: " + i + " result = " + res);
            return res;
        }));

        Long result = 0L;
        ExecutorService executor = Executors.newCachedThreadPool ();
        try {
            List<Future<Long>> sum = executor.invokeAll ( callables );
            for (Future<Long> f: sum) {
                result = result + f.get ();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace ();
        } finally {
            executor.shutdown ();
        }
        return result;
	}
}
