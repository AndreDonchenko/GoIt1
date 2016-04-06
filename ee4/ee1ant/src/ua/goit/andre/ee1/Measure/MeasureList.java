package ua.goit.andre.ee1.Measure;

import java.util.List;
import java.util.ListIterator;

public class MeasureList extends MeasureCollection {
    List<Integer> list;

    @Override
    public void testAdd(int numTests) {
        for (int i = 0; i < numTests; i++) {
            list.add(i);
        }
    }

    @Override
    public void testGet(int numTests) {
        for (int i = 0; i < numTests; i++) {
            list.get(i);
        }
    }

    @Override
    public void testRemove(int numTests) {
        while (list.size() > 0) {
            list.remove(0);
        }
    }

    @Override
    public void testContains(int numTests) {
        for (int i = 0; i < numTests; i++) {
            list.contains(10);
        }
    }

    @Override
    public void testPopulate(int numTests) {
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set(10);
        }
    }

    @Override
    public void testIteratorAdd(int numTests) {
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            if (it.next() % 10 == 0) {
                it.add(Integer.MIN_VALUE);
            }
        }
    }

    @Override
    public void testIteratorRemove(int numTests) {
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            if (it.next() == Integer.MIN_VALUE) {
                it.remove();
            }
        }
    }
}
