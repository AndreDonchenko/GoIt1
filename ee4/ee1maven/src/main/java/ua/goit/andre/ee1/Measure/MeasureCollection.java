package ua.goit.andre.ee1.Measure;

import java.util.Collection;

public abstract class MeasureCollection {

    Collection<Integer> collection;

    public void testAdd(int numTests) {
        for (int i = 0; i < numTests; i++) {
            collection.add(i);
        }
    }

    public void testRemove(int numTests) {
        for (int i = 0; i < numTests; i++) {
            collection.remove(i);
        }
    }

    public void testContains(int numTests) {
        for (int i = 0; i < numTests; i++) {
            collection.contains(i);
        }
    }

    public void testPopulate(int numTests) {
        for (int i = 0; i < numTests; i++) {
            collection.remove(i);
            collection.add(-i);
        }
    }

    public void testGet(int numTests){}
    public void testIteratorAdd(int numTests){}
    public void testIteratorRemove(int numTests){}
}
