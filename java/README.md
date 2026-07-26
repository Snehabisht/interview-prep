# Java Interview Prep

## OOP
- Classes and objects
- Constructors
- Inheritance
- Interfaces vs abstract classes
- Java 8 interface: default and static methods
- Method overriding rules
- Method overloading vs overriding
- Polymorphism
- Encapsulation and abstraction
- `final` keyword (class, method, variable)
- `static` keyword
- `this` and `super`
- Pass by value vs pass by reference

## Strings
- String immutability
- String pool
- `==` vs `.equals()`
- `StringBuilder` vs `StringBuffer`

## Collections
- `ArrayList` vs `LinkedList`
- `HashMap` internals (buckets, hashCode, equals, chaining, treeify at 8)
- Load factor (0.75) and rehashing
- `ConcurrentHashMap` vs `Collections.synchronizedMap()`
- `HashSet` internals
- `TreeMap` vs `HashMap`
- `LinkedHashMap`
- Fail-fast vs fail-safe iterators
- `Iterator` vs `ListIterator`
- `Comparable` vs `Comparator`
- Null keys: HashMap (yes, 1) vs ConcurrentHashMap (no)

## Java 8+ Features
- Lambda expressions
- Functional interfaces: `Predicate`, `Function`, `Consumer`, `Supplier`
- Stream API: filter, map, flatMap, sorted, reduce, collect
- Lazy evaluation in streams
- `orElse` vs `orElseGet` vs `orElseThrow`
- Parallel streams (when to use, when NOT to)
- Method references
- `Optional`

## Exception Handling
- Checked vs unchecked exceptions
- `try-catch-finally`
- `try-with-resources`
- Custom exceptions
- Exception hierarchy

## JVM Internals
- JVM vs JRE vs JDK
- JVM memory: Heap (Young/Old gen), Stack, Method Area, Metaspace
- Minor GC vs Major/Full GC
- GC types: Serial, Parallel, G1 (default Java 9+), ZGC
- Memory leak causes (static collections, unclosed resources, ThreadLocal)
- Class loading mechanism

## Concurrency
- Thread lifecycle
- `Runnable` vs `Callable`
- `ExecutorService` and thread pools (fixed, cached, scheduled)
- `Future` vs `CompletableFuture`
- `synchronized` vs `ReentrantLock`
- `volatile` (visibility guarantee, NOT atomicity)
- Atomic classes (`AtomicInteger`, `AtomicReference`)
- `CountDownLatch` vs `CyclicBarrier`
- `BlockingQueue` (producer-consumer)
- `ThreadLocal` and memory leak risk in thread pools
- Deadlock (4 conditions + prevention)
- `wait()` vs `sleep()` vs `yield()`

## Miscellaneous
- Autoboxing and unboxing
- Immutable classes
- Generics
- Enums
- Serialization
- `hashCode()` and `equals()` contract
