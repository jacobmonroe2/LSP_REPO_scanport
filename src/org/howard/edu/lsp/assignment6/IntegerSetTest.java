package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

    private IntegerSet setA;
    private IntegerSet setB;

    @BeforeEach
    public void setUp() {
        setA = new IntegerSet();
        setB = new IntegerSet();
    }

    // ==================== clear() ====================

    @Test
    @DisplayName("Test case for clear - normal")
    public void testClearNormal() {
        setA.add(1);
        setA.add(2);
        setA.clear();
        assertEquals(0, setA.length());
        assertTrue(setA.isEmpty());
    }

    @Test
    @DisplayName("Test case for clear - already empty set")
    public void testClearEmpty() {
        setA.clear();
        assertEquals(0, setA.length());
        assertTrue(setA.isEmpty());
    }

    // ==================== length() ====================

    @Test
    @DisplayName("Test case for length - normal")
    public void testLengthNormal() {
        setA.add(1);
        setA.add(2);
        setA.add(3);
        assertEquals(3, setA.length());
    }

    @Test
    @DisplayName("Test case for length - empty set")
    public void testLengthEmpty() {
        assertEquals(0, setA.length());
    }

    // ==================== equals() ====================

    @Test
    @DisplayName("Test case for equals - same elements different order")
    public void testEqualsDifferentOrder() {
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setB.add(3);
        setB.add(1);
        setB.add(2);
        assertTrue(setA.equals(setB));
    }

    @Test
    @DisplayName("Test case for equals - different elements")
    public void testEqualsMismatch() {
        setA.add(1);
        setA.add(2);
        setB.add(1);
        setB.add(3);
        assertFalse(setA.equals(setB));
    }

    @Test
    @DisplayName("Test case for equals - different sizes")
    public void testEqualsDifferentSizes() {
        setA.add(1);
        setB.add(1);
        setB.add(2);
        assertFalse(setA.equals(setB));
    }

    // ==================== contains() ====================

    @Test
    @DisplayName("Test case for contains - value present")
    public void testContainsPresent() {
        setA.add(5);
        setA.add(10);
        assertTrue(setA.contains(5));
    }

    @Test
    @DisplayName("Test case for contains - value not present")
    public void testContainsAbsent() {
        setA.add(5);
        assertFalse(setA.contains(99));
    }

    // ==================== largest() ====================

    @Test
    @DisplayName("Test case for largest - normal")
    public void testLargestNormal() {
        setA.add(1);
        setA.add(5);
        setA.add(3);
        assertEquals(5, setA.largest());
    }

    @Test
    @DisplayName("Test case for largest - single element")
    public void testLargestSingleElement() {
        setA.add(42);
        assertEquals(42, setA.largest());
    }

    @Test
    @DisplayName("Test case for largest - empty set throws exception")
    public void testLargestEmpty() {
        assertThrows(IllegalStateException.class, () -> setA.largest());
    }

    // ==================== smallest() ====================

    @Test
    @DisplayName("Test case for smallest - normal")
    public void testSmallestNormal() {
        setA.add(1);
        setA.add(5);
        setA.add(3);
        assertEquals(1, setA.smallest());
    }

    @Test
    @DisplayName("Test case for smallest - single element")
    public void testSmallestSingleElement() {
        setA.add(42);
        assertEquals(42, setA.smallest());
    }

    @Test
    @DisplayName("Test case for smallest - empty set throws exception")
    public void testSmallestEmpty() {
        assertThrows(IllegalStateException.class, () -> setA.smallest());
    }

    // ==================== add() ====================

    @Test
    @DisplayName("Test case for add - normal")
    public void testAddNormal() {
        setA.add(1);
        setA.add(2);
        assertTrue(setA.contains(1));
        assertTrue(setA.contains(2));
        assertEquals(2, setA.length());
    }

    @Test
    @DisplayName("Test case for add - duplicate value")
    public void testAddDuplicate() {
        setA.add(1);
        setA.add(1);
        assertEquals(1, setA.length());
    }

    // ==================== remove() ====================

    @Test
    @DisplayName("Test case for remove - normal")
    public void testRemoveNormal() {
        setA.add(1);
        setA.add(2);
        setA.remove(1);
        assertFalse(setA.contains(1));
        assertEquals(1, setA.length());
    }

    @Test
    @DisplayName("Test case for remove - value not present")
    public void testRemoveMissing() {
        setA.add(1);
        setA.remove(99);
        assertEquals(1, setA.length());
    }

    // ==================== union() ====================

    @Test
    @DisplayName("Test case for union - normal")
    public void testUnionNormal() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        IntegerSet result = setA.union(setB);
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertEquals(3, result.length());
    }

    @Test
    @DisplayName("Test case for union - with empty set")
    public void testUnionWithEmpty() {
        setA.add(1);
        setA.add(2);
        IntegerSet result = setA.union(setB);
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertEquals(2, result.length());
    }

    // ==================== intersect() ====================

    @Test
    @DisplayName("Test case for intersect - normal")
    public void testIntersectNormal() {
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setB.add(2);
        setB.add(3);
        setB.add(4);
        IntegerSet result = setA.intersect(setB);
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertEquals(2, result.length());
    }

    @Test
    @DisplayName("Test case for intersect - no common elements")
    public void testIntersectNoOverlap() {
        setA.add(1);
        setA.add(2);
        setB.add(3);
        setB.add(4);
        IntegerSet result = setA.intersect(setB);
        assertEquals(0, result.length());
        assertTrue(result.isEmpty());
    }

    // ==================== diff() ====================

    @Test
    @DisplayName("Test case for diff - normal")
    public void testDiffNormal() {
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setB.add(2);
        setB.add(3);
        IntegerSet result = setA.diff(setB);
        assertTrue(result.contains(1));
        assertEquals(1, result.length());
    }

    @Test
    @DisplayName("Test case for diff - identical sets")
    public void testDiffIdentical() {
        setA.add(1);
        setA.add(2);
        setB.add(1);
        setB.add(2);
        IntegerSet result = setA.diff(setB);
        assertEquals(0, result.length());
        assertTrue(result.isEmpty());
    }

    // ==================== complement() ====================

    @Test
    @DisplayName("Test case for complement - normal")
    public void testComplementNormal() {
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setB.add(2);
        setB.add(3);
        setB.add(4);
        setB.add(5);
        IntegerSet result = setA.complement(setB);
        assertTrue(result.contains(4));
        assertTrue(result.contains(5));
        assertFalse(result.contains(2));
        assertFalse(result.contains(3));
        assertEquals(2, result.length());
    }

    @Test
    @DisplayName("Test case for complement - disjoint sets")
    public void testComplementDisjoint() {
        setA.add(1);
        setA.add(2);
        setB.add(3);
        setB.add(4);
        IntegerSet result = setA.complement(setB);
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
        assertEquals(2, result.length());
    }

    // ==================== isEmpty() ====================

    @Test
    @DisplayName("Test case for isEmpty - empty set")
    public void testIsEmptyTrue() {
        assertTrue(setA.isEmpty());
    }

    @Test
    @DisplayName("Test case for isEmpty - non-empty set")
    public void testIsEmptyFalse() {
        setA.add(1);
        assertFalse(setA.isEmpty());
    }

    // ==================== toString() ====================

    @Test
    @DisplayName("Test case for toString - normal")
    public void testToStringNormal() {
        setA.add(3);
        setA.add(1);
        setA.add(2);
        assertEquals("[1, 2, 3]", setA.toString());
    }

    @Test
    @DisplayName("Test case for toString - empty set")
    public void testToStringEmpty() {
        assertEquals("[]", setA.toString());
    }
}
