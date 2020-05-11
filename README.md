Write a function to sort a list of numbers so that odd numbers are sorted before even numbers, and relative order is preserved, for. example: [1, 2, 4, 3, 7, 16] is sorted as [1, 3, 7, 2, 4, 16]

Your code must be accompanied by unit tests demonstrating its correctness.

files: 

Task.java (jdk >= 1.8) [tests are embedded]

Task.hs (Haskell)

About Time Complexity
  
Algorithms in both files run in O(nlogn) time, which is the minimum time which any comparision based sort algorithm takes. No matter how many optimizations are made, for sufficiently large n, tight upperbound will always be O(NlogN).
