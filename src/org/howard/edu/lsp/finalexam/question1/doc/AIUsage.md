# AI Usage Report

## Tool Used
ChatGPT

## Chat Exchange

**Me:** I have a class with a shared integer counter and an ArrayList. Multiple threads call addRequest() at the same time. What could go wrong?

**AI:** Two things are at risk. First, the counter — if two threads both read nextId before either increments it, they'll get the same value and produce duplicate IDs. Second, ArrayList isn't thread-safe, so concurrent calls to add() can corrupt its internal state.

**Me:** If I only put synchronized on getNextId(), does that fix it?

**AI:** Not completely. It makes the ID generation atomic, but the add() call back in addRequest() is still outside any lock. Two threads can each grab a unique ID and then call ArrayList.add() at the same time, which can still corrupt the list.

**Me:** What about synchronizing addRequest() itself?

**AI:** That works. Wrapping the whole method means only one thread can execute it at a time — the ID assignment and the list add happen together as one atomic operation.

**Me:** Is there a way to fix it without using synchronized at all?

**AI:** Yes — use AtomicInteger instead of a plain int for the counter. Its getAndIncrement() method is atomic at the hardware level. For the list, wrap it with Collections.synchronizedList(). That way you don't need any synchronized blocks.
