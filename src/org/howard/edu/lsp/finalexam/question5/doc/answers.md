# Question 5 -- Riel's Object-Oriented Design Heuristics

---

## Heuristic 1

**Name:**
All data should be hidden within its class.

**Explanation:**
This heuristic is about making all instance variables private so nothing outside the class can directly read or change them. It helps readability because callers only need to understand the public methods and not how the data is stored internally. It also makes the class easier to maintain since the internal structure can change without breaking any outside code. In lecture this was shown by pointing out that a public field like `public int nextId` lets any class reach in and modify the counter directly while a private field with controlled access through methods prevents that.

---

## Heuristic 2

**Name:**
A class should capture one and only one key abstraction.

**Explanation:**
A class that does too many things gets hard to read and hard to change. When each class is focused on a single idea the class name alone tells you what it does. It also helps with maintenance because a change to one responsibility will not accidentally affect something unrelated. In lecture this came up when separating a `Task` class that just represents a task from a `TaskManager` class that manages the collection rather than combining all of that into one class.

---

## Heuristic 3

**Name:**
Minimize the public interface of a class.

**Explanation:**
Every public method is something outside code can depend on which makes it harder to change later. Keeping the public interface small makes a class easier to understand and easier to update without breaking callers. In lecture this was connected to the `RequestManager` example where `getNextId()` was public but should not have been. Exposing it lets outside code increment the ID counter without going through `addRequest()` which breaks the expected behavior of the class.
