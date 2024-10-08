# Kotlin Algorithms & Data Structures

Welcome to the **Kotlin Algorithms & Data Structures** repository! This open-source project is dedicated to implementing
a wide range of algorithms and data structures using Kotlin, a modern programming language that offers clarity,
conciseness, and powerful features.

## Our Mission

Our aim is to provide a comprehensive collection of well-implemented algorithms and data structures in Kotlin, making it
an invaluable resource for developers, students, and educators alike. Whether you're preparing for technical interviews,
teaching computer science concepts, or just looking to explore algorithms in a new language, this repository has
something for you.

## What You'll Find Here

- **Algorithms:** From basic sorting and searching to more advanced graph and dynamic programming algorithms, our
  collection is continually growing.
- **Data Structures:** Implementations of essential data structures like lists, trees, graphs, stacks, queues, and more,
  showcasing Kotlin's capabilities.
- **Examples and Tests:** Each implementation is accompanied by examples and thorough tests to ensure reliability and
  ease of understanding.
- **Documentation:** Clear documentation for each algorithm and data structure, explaining the logic, complexity, and
  potential use cases.

# Current implementations:

# Table of Contents

- [Data Structures](#data-structures)
- [Maths](#maths)
- [Searching](#searching)
- [Sequences](#sequences)
- [Sorting](#sorting) 

### Data Structures

- List
  - [Array List](https://github.com/devstromo/kotlin-algorithms/blob/main/data-structure/src/main/kotlin/lists/ArrayList.kt)
  - [Circular Linked List](https://github.com/devstromo/kotlin-algorithms/blob/main/data-structure/src/main/kotlin/lists/CircularLinkedList.kt)
  - [Doubly Linked List](https://github.com/devstromo/kotlin-algorithms/blob/main/data-structure/src/main/kotlin/lists/DoublyLinkedList.kt)
  - [Singly Linked List](https://github.com/devstromo/kotlin-algorithms/blob/main/data-structure/src/main/kotlin/lists/SinglyLinkedList.kt)
  - [Skip List](https://github.com/devstromo/kotlin-algorithms/blob/main/data-structure/src/main/kotlin/lists/SkipList.kt)

- Queue
  - [Backed by Array List](https://github.com/devstromo/kotlin-algorithms/blob/main/data-structure/src/main/kotlin/queues/ArrayQueue.kt)
  - [Backed by Linked List](https://github.com/devstromo/kotlin-algorithms/blob/main/data-structure/src/main/kotlin/queues/LinkedQueue.kt)

- Sets
  - [Disjoint Set](https://github.com/devstromo/kotlin-algorithms/blob/main/data-structure/src/main/kotlin/sets/DisjointSet.kt)

- Stack
  - [Backed by Array List](https://github.com/devstromo/kotlin-algorithms/blob/main/data-structure/src/main/kotlin/stacks/ArrayStack.kt)
  - [Backed by Linked List](https://github.com/devstromo/kotlin-algorithms/blob/main/data-structure/src/main/kotlin/stacks/LinkedStack.kt)

- Trees
  - [Binary Tree](https://github.com/devstromo/kotlin-algorithms/blob/main/data-structure/src/main/kotlin/trees/BinaryTree.kt)
  - [Binary Search Tree](https://github.com/devstromo/kotlin-algorithms/blob/main/data-structure/src/main/kotlin/trees/BinarySearchTree.kt)

### Maths

- [Distance](https://github.com/devstromo/kotlin-algorithms/blob/main/maths/src/main/kotlin/distance/Distance.kt)
    - Euclidean
    - Manhattan
    - Hamming
    - Levenshtein
- [Division](https://github.com/devstromo/kotlin-algorithms/blob/main/maths/src/main/kotlin/division/Division.kt)
- [Exponentiation](https://github.com/devstromo/kotlin-algorithms/blob/main/maths/src/main/kotlin/division/Exponentiation.kt)
- [Permutations](https://github.com/devstromo/kotlin-algorithms/blob/main/maths/src/main/kotlin/division/Permutations.kt)
- [Primes](https://github.com/devstromo/kotlin-algorithms/blob/main/maths/src/main/kotlin/division/Primes.kt)
    - Classic Approach
    - Optimized Approach
    - Sieve of Eratosthenes
    - Fermat primality test
    - Miller-Rabin

### Searching

The Searching section of this repository focuses on implementing various algorithms to efficiently search for data
within different data structures. Searching algorithms are fundamental to computer science and software development,
allowing us to find specific elements within datasets quickly. This section covers a range of searching techniques, from
simple linear searches to more complex algorithms like binary search and beyond.

- [Linear Search](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/searching/linear/LinearSearch.kt)
- [Binary Search(sorted array)](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/searching/binary/BinarySearch.kt)
- [Interpolation Search(sorted array)](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/searching/interpolation/InterpolationSearch.kt)
- [Exponential Search(sorted array)](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/searching/exponential/ExponentialSearch.kt)

### Sequences

This section covers various sequence algorithms, showcasing different methods to generate or manipulate numerical
sequences.

- [Find n-th element in fibonacci sequence](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/sequences/fibonacci/Fibonacci.kt)
    - Recursive
    - Memoization
    - Tabular
    - Binet's Formula
    - Fast Doubling Method Negative
- [Maximum Subarray Problem](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/sequences/maximum_sub_array/MaximumSubArray.kt)

### Sorting

- [Bubble Sort](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/sorting/bubble/BubbleSort.kt)
- [Insertion Sort](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/sorting/insertion/InsertionSort.kt)
- [Selection Sort](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/sorting/selection/SelectionSort.kt)
- [Shell Sort](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/sorting/shell/ShellSort.kt)
- [Radix Sort](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/sorting/radix/RadixSort.kt)
- [Merge Sort](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/sorting/merge/MergeSort.kt)
    - Classical approach
    - Top-down optimized approach
    - Bottom-up approach
- [Quicksort](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/sorting/quicksort/QuickSort.kt)
    - Classical approach
    - With cutoff
    - Dijkstra's 3-way partition
- [Counting sort](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/sorting/counting/CountingSort.kt)
- [American Flag](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/sorting/americanFlag/AmericanFlagSort.kt)
- [Patience Sort](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/sorting/patience/PatienceSort.kt)
- [Heap Sort](https://github.com/devstromo/kotlin-algorithms/blob/main/algorithms/src/main/kotlin/sorting/heapsort/Heapsort.kt)

## Contributing

This is a collaborative project, and contributions are warmly welcomed. Whether it's adding new implementations,
improving existing ones, or enhancing documentation, your input is valuable.

## Getting Started

Clone the repository and explore the wide variety of algorithms and data structures implemented in Kotlin. The code is
organized for easy navigation and understanding.

Join us in building an extensive Kotlin-based algorithms and data structures library. Your journey into the efficient
and elegant world of Kotlin starts here!

## References

- Robert Sedgewick and Kevin Wayne. *Algorithms, 4th Edition*. Available online
  at [Algorithms, 4th Edition](https://algs4.cs.princeton.edu/home/).
- Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein. *Introduction to Algorithms, 3rd
  Edition (MIT Press)*. Available online
  at [Amazon](https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844).

## Other repositories

- [Java Algorithms Implementation](https://github.com/phishman3579/java-algorithms-implementation)



