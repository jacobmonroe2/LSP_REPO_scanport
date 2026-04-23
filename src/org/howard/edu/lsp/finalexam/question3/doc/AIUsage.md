# AI Usage Report

## Tool Used
ChatGPT

## Chat Exchange

**Me:** I'm writing JUnit 5 tests for a GradeCalculator class. It has average(), letterGrade(), and isPassing(). Where should I start?

**AI:** Write one test per method to cover the normal case first. Then think about boundary values — the edges of your valid input range are where bugs hide. For average() that means testing scores of exactly 0 and 100. For letterGrade() you'd want to test the exact cutoff values like 90, 80, 70, and 60.

**Me:** The validateScore method throws an IllegalArgumentException if a score is out of range. How do I test that?

**AI:** Use assertThrows. Pass the exception type and a lambda that calls the method with the bad input — for example, assertThrows(IllegalArgumentException.class, () -> calc.average(-1, 50, 50)). JUnit will fail the test if the exception isn't thrown.

**Me:** Do I need a separate test class or can I put everything in one file?

**AI:** One file is fine. Use @BeforeEach to create a fresh GradeCalculator before each test so they don't share state, then group your @Test methods by the method they're testing.
