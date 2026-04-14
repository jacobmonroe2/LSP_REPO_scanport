package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;

public class IntegerSet {

    private ArrayList<Integer> set = new ArrayList<>();

    public IntegerSet() {}

    public void clear() {
        set.clear();
    }

    public int length() {
        return set.size();
    }

    public boolean equals(IntegerSet b) {
        if (this.length() != b.length()) return false;
        ArrayList<Integer> copy = new ArrayList<>(set);
        Collections.sort(copy);
        ArrayList<Integer> bCopy = new ArrayList<>(b.set);
        Collections.sort(bCopy);
        return copy.equals(bCopy);
    }

    public boolean contains(int value) {
        return set.contains(value);
    }

    public int largest() {
        if (isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.max(set);
    }

    public int smallest() {
        if (isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.min(set);
    }

    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);
        for (int val : intSetb.set) {
            if (!result.set.contains(val)) {
                result.set.add(val);
            }
        }
        return result;
    }

    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : this.set) {
            if (intSetb.set.contains(val)) {
                result.set.add(val);
            }
        }
        return result;
    }

    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : this.set) {
            if (!intSetb.set.contains(val)) {
                result.set.add(val);
            }
        }
        return result;
    }

    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : intSetb.set) {
            if (!this.set.contains(val)) {
                result.set.add(val);
            }
        }
        return result;
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}
