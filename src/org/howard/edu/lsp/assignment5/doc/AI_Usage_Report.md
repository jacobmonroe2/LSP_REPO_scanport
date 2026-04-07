# AI Usage Report – Assignment 5: IntegerSet Implementation

## Tool Used
ChatGPT (GPT-4)

---

## Conversation Log

---

**Me:**
I have a Java assignment where I need to implement a class called IntegerSet that models a mathematical set of integers. It needs to use an ArrayList internally and support operations like union, intersect, diff, and complement. The operations are supposed to return new sets and not modify the originals. Where do I start?

**ChatGPT:**
Good starting point. Since you're using an `ArrayList<Integer>` internally, the key things to keep in mind are:

1. No duplicates — your `add` method needs to check before inserting.
2. Set operations should create and return a **new** `IntegerSet`, never mutate `this` or the parameter.
3. For `toString()`, sort before printing so the output is consistent.

Start by defining the class and the backing list:

```java
import java.util.ArrayList;
import java.util.Collections;

public class IntegerSet {
    private ArrayList<Integer> set = new ArrayList<>();
}
```

Then build `add`, `remove`, `contains`, and `isEmpty` first since everything else depends on them.

---

**Me:**
Ok I got those. How do I implement union and intersect without changing the original sets?

**ChatGPT:**
Create a new `IntegerSet` inside the method and populate it — never touch `this.set` or `intSetb.set` directly as the destination.

For **union**, copy everything from `this`, then add anything from `intSetb` that isn't already there:

```java
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
```

For **intersect**, only add elements that appear in both:

```java
public IntegerSet intersect(IntegerSet intSetb) {
    IntegerSet result = new IntegerSet();
    for (int val : this.set) {
        if (intSetb.set.contains(val)) {
            result.set.add(val);
        }
    }
    return result;
}
```

---

**Me:**
What's the difference between diff and complement? The assignment says diff is (this - b) and complement is (b - this).

**ChatGPT:**
Exactly right. They're symmetric operations:

- `diff(b)` → elements in `this` that are **not** in `b`
- `complement(b)` → elements in `b` that are **not** in `this`

```java
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
```

---

**Me:**
For equals, the assignment says [1, 2, 3] and [3, 2, 1] should return true. How do I handle order not mattering?

**ChatGPT:**
Sort both lists into copies before comparing. Don't sort the originals or you'll change the internal order of the set.

```java
public boolean equals(IntegerSet b) {
    if (this.length() != b.length()) return false;
    ArrayList<Integer> copy = new ArrayList<>(set);
    Collections.sort(copy);
    ArrayList<Integer> bCopy = new ArrayList<>(b.set);
    Collections.sort(bCopy);
    return copy.equals(bCopy);
}
```

---

**Me:**
Should largest() and smallest() throw an exception if the set is empty?

**ChatGPT:**
Yes, that's the right approach. Returning a default like 0 or -1 would be misleading since those are valid integers. Use `IllegalStateException`:

```java
public int largest() {
    if (isEmpty()) throw new IllegalStateException("Set is empty");
    return Collections.max(set);
}

public int smallest() {
    if (isEmpty()) throw new IllegalStateException("Set is empty");
    return Collections.min(set);
}
```

---

**Me:**
The assignment says toString() needs to output in ascending order with no extra spaces, like [1, 2, 3]. Can I just use ArrayList's built-in toString?

**ChatGPT:**
Yes, `ArrayList.toString()` already formats as `[1, 2, 3]` which matches the required format. Just sort a copy first:

```java
@Override
public String toString() {
    ArrayList<Integer> sorted = new ArrayList<>(set);
    Collections.sort(sorted);
    return sorted.toString();
}
```

The `@Override` annotation is required by the assignment since you're overriding `Object.toString()`.

---

**Me:**
Got it, everything compiles and the Driver output looks right. Thanks.

**ChatGPT:**
Looks good. Just double-check that none of your set operations modify `this` or the parameter — run the Driver and confirm that Set1 and Set2 print the same values before and after the operations.
