# Question 1 Answers

## Part 1

**Shared Resource #1:**
`nextId` is the integer counter used to assign unique IDs to each request. Any thread that calls `addRequest()` reads and modifies this value.

**Shared Resource #2:**
`requests` is the `ArrayList<String>` that stores all submitted requests. Multiple threads can attempt to write to it at the same time.

**Concurrency Problem:**
Race condition. Two or more threads can interleave inside `addRequest()` and end up with duplicate IDs or a corrupted list.

**Why `addRequest()` is unsafe:**
It performs two steps that are not atomic. First it calls `getNextId()` to get an ID and then it calls `requests.add()` to store the request. If thread A reads `nextId` and gets paused before incrementing it then thread B can read the same value and both threads end up with the same ID. `ArrayList` is also not thread-safe so two threads calling `add()` at the same time can corrupt the list's internal structure.

---

## Part 2

**Fix A -- `public synchronized int getNextId()`:**
Not correct. Making `getNextId()` synchronized protects the counter but `requests.add()` inside `addRequest()` is still unprotected. Two threads can each get a different ID and then both call `ArrayList.add()` at the same time which can still corrupt the list.

**Fix B -- `public synchronized void addRequest(String studentName)`:**
Correct. Synchronizing the entire `addRequest()` method means only one thread can run it at a time. The ID assignment and the list add both happen under the same lock so there is no way for another thread to get in between them.

**Fix C -- `public synchronized List<String> getRequests()`:**
Not correct. This only protects reading the list. The write operations inside `addRequest()` are still unsynchronized so the race condition on `nextId` and `requests` is completely unaddressed.

---

## Part 3

**Answer:** No, `getNextId()` should not be public.

**Explanation:** Riel's heuristic says to keep a class's public interface as small as possible and only expose what outside code actually needs. `getNextId()` is an internal helper that only `addRequest()` uses. Making it public lets external code increment the counter without adding a request which breaks the expected behavior of the class and can produce gaps or duplicate IDs.

---

## Part 4

**Description:**
Instead of `synchronized` you can use `AtomicInteger` from `java.util.concurrent.atomic`. It handles the read-increment-return operation as a single atomic step at the hardware level with no locking required. For the list you can wrap it with `Collections.synchronizedList()` to make `add()` thread-safe. Together these two changes make `addRequest()` safe without any `synchronized` blocks.

**Code Snippet:**
```java
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Collections;

private AtomicInteger nextId = new AtomicInteger(1);
private List<String> requests = Collections.synchronizedList(new ArrayList<>());

public void addRequest(String studentName) {
    int id = nextId.getAndIncrement();
    String request = "Request-" + id + " from " + studentName;
    requests.add(request);
}
```
