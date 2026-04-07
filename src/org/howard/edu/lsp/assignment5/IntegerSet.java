package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a mathematical set of integers.
 * A set cannot contain duplicate elements.
 * Supports standard set operations such as union, intersection,
 * difference, and complement.
 */
public class IntegerSet {

    private ArrayList<Integer> set = new ArrayList<>();

    /**
     * Default constructor. Creates an empty IntegerSet.
     */
    public IntegerSet() {}

    /**
     * Removes all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if this set and the given set contain exactly the same elements,
     * regardless of order.
     *
     * @param b the other IntegerSet to compare
     * @return true if both sets are equal
     */
    public boolean equals(IntegerSet b) {
        if (this.length() != b.length()) return false;
        ArrayList<Integer> copy = new ArrayList<>(set);
        Collections.sort(copy);
        ArrayList<Integer> bCopy = new ArrayList<>(b.set);
        Collections.sort(bCopy);
        return copy.equals(bCopy);
    }

    /**
     * Returns true if the set contains the specified value.
     *
     * @param value the integer to search for
     * @return true if value is in the set
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in the set.
     *
     * @return the largest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in the set.
     *
     * @return the smallest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it is not already present.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it is present.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new IntegerSet containing all elements from both this set and set b.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the union
     */
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

    /**
     * Returns a new IntegerSet containing only elements common to both this set and set b.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the intersection
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : this.set) {
            if (intSetb.set.contains(val)) {
                result.set.add(val);
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements in this set but not in set b.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the difference (this - b)
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : this.set) {
            if (!intSetb.set.contains(val)) {
                result.set.add(val);
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements in set b but not in this set.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the complement (b - this)
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : intSetb.set) {
            if (!this.set.contains(val)) {
                result.set.add(val);
            }
        }
        return result;
    }

    /**
     * Returns true if the set contains no elements.
     *
     * @return true if the set is empty
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * Elements are enclosed in brackets and separated by ", ".
     * An empty set returns "[]".
     *
     * @return string representation of the set
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}
