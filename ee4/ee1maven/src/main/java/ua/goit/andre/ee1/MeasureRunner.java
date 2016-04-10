package ua.goit.andre.ee1;

import ua.goit.andre.ee1.Measure.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class MeasureRunner {

    private static BufferedWriter outputStream=null;

    private static void writeLn(String s){
        System.out.println(s);
        try {
            outputStream.write(s);
            outputStream.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runTest(int numTests) {
        final String HEADER_LINE = "----------------------------------------------------------------------------------------------------------";
        final int NUM_METER = 1;

        writeLn(HEADER_LINE);
        writeLn(String.format("| %11s |        add |        get |     remove |   contains |   populate |iterator.add| iter.remove|",Integer.toString(numTests)));
        writeLn(HEADER_LINE);

        RowResults arrayListResults   = new RowResults("Arraylist");
        RowResults linkedListResults  = new RowResults("Linkedlist");
        RowResults hashSetResults = new RowResults("HashSet");
        RowResults treeSetResults = new RowResults("TreeSet");

        for (int i=0; i<NUM_METER; i++) {
            MeasureCollection arrayList = new MeasureArrayList();
            runSingleTest(numTests, arrayListResults, arrayList);

            MeasureCollection linkedList = new MeasureLinkedList();
            runSingleTest(numTests, linkedListResults, linkedList);

            MeasureCollection hashSet = new MeasureHashSet();
            runSingleTest(numTests, hashSetResults, hashSet);

            MeasureCollection treeSet = new MeasureTreeSet();
            runSingleTest(numTests, treeSetResults, treeSet);
        }

        writeLn(arrayListResults.toString(NUM_METER));
        writeLn(linkedListResults.toString(NUM_METER));
        writeLn(hashSetResults.toString(NUM_METER));
        writeLn(treeSetResults.toString(NUM_METER));

        writeLn(HEADER_LINE);
    }

    private static void runSingleTest(int numTests, RowResults rowResults, MeasureCollection testCollection) {

        long timeout = System.currentTimeMillis();
        testCollection.testAdd(numTests);
        long ms = System.currentTimeMillis() - timeout;
        rowResults.setAddR(rowResults.getAddR() + ms);

        timeout = System.currentTimeMillis();
        testCollection.testContains(numTests);
        ms = System.currentTimeMillis() - timeout;
        rowResults.setContainsR(rowResults.getContainsR()+ ms);

        timeout = System.currentTimeMillis();
        testCollection.testGet(numTests);
        ms = System.currentTimeMillis() - timeout;
        rowResults.setGetR(rowResults.getGetR() + ms);

        timeout = System.currentTimeMillis();
        testCollection.testIteratorAdd(numTests);
        ms = System.currentTimeMillis() - timeout;
        rowResults.setIteratorAddR(rowResults.getIteratorAddR() + ms);

        timeout = System.currentTimeMillis();
        testCollection.testIteratorRemove(numTests);
        ms = System.currentTimeMillis() - timeout;
        rowResults.setIteratorRemoveR(rowResults.getIteratorRemoveR() + ms);

        timeout = System.currentTimeMillis();
        testCollection.testPopulate(numTests);
        ms = System.currentTimeMillis() - timeout;
        rowResults.setPopulateR(rowResults.getPopulateR() + ms);

        timeout = System.currentTimeMillis();
        testCollection.testRemove(numTests);
        ms = System.currentTimeMillis() - timeout;
        rowResults.setRemoveR(rowResults.getRemoveR() + ms);
    }

    public static void main(String[] args) throws IOException {
        outputStream = new BufferedWriter(new FileWriter("outputfile.txt"));

        runTest(10000);
        runTest(100000);
        //runTest(1000000);

        if (outputStream!=null) outputStream.close();
        System.out.println("Done.");
    }
}
