package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {

    private GradeCalculator calc;

    @BeforeEach
    public void setUp() {
        calc = new GradeCalculator();
    }

    // ==================== average() ====================

    @Test
    @DisplayName("Test average of three typical scores")
    public void testAverageTypical() {
        assertEquals(80.0, calc.average(70, 80, 90), 0.001);
    }

    // ==================== letterGrade() ====================

    @Test
    @DisplayName("Test letterGrade returns A for average >= 90")
    public void testLetterGradeA() {
        assertEquals("A", calc.letterGrade(95.0));
    }

    @Test
    @DisplayName("Test letterGrade returns F for average < 60")
    public void testLetterGradeF() {
        assertEquals("F", calc.letterGrade(55.0));
    }

    // ==================== isPassing() ====================

    @Test
    @DisplayName("Test isPassing returns true for average >= 60")
    public void testIsPassingTrue() {
        assertTrue(calc.isPassing(60.0));
    }

    // ==================== boundary-value tests ====================

    @Test
    @DisplayName("Boundary: average of all zeros returns 0.0")
    public void testAverageBoundaryAllZero() {
        assertEquals(0.0, calc.average(0, 0, 0), 0.001);
    }

    @Test
    @DisplayName("Boundary: average of all 100s returns 100.0")
    public void testAverageBoundaryAllMax() {
        assertEquals(100.0, calc.average(100, 100, 100), 0.001);
    }

    // ==================== exception tests ====================

    @Test
    @DisplayName("Exception: score below 0 throws IllegalArgumentException")
    public void testNegativeScoreThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(-1, 50, 50));
    }

    @Test
    @DisplayName("Exception: score above 100 throws IllegalArgumentException")
    public void testScoreAbove100Throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(101, 50, 50));
    }
}
