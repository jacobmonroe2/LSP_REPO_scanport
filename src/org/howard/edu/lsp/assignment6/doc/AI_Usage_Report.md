# AI Usage Report

## Tool Used
ChatGPT

## Chat Exchange

**Me:** I'm writing JUnit 5 tests for a Java class called IntegerSet. What's the general structure for a JUnit test class?

**AI:** You'll want to import the JUnit 5 assertions and annotations, create a test class, and use `@BeforeEach` to initialize fresh objects before each test. Each test method gets an `@Test` annotation.

**Me:** What kind of edge cases should I think about for set operations like union and intersect?

**AI:** For union, consider what happens when one set is empty. For intersect, think about when the two sets share no elements at all. For methods like largest() and smallest(), you should test what happens on an empty set — if your code throws an exception, use `assertThrows` to verify that.

**Me:** How do I test that an exception is thrown in JUnit 5?

**AI:** Use `assertThrows(ExceptionType.class, () -> methodCall())`. For example, `assertThrows(IllegalStateException.class, () -> set.largest())` if your method throws that on an empty set.

**Me:** Got it. And for equals(), should I test sets with the same elements but added in different order?

**AI:** Yes, that's a great edge case. Sets should be equal regardless of insertion order. You'd add elements in different orders to two sets and use `assertTrue(setA.equals(setB))`.
