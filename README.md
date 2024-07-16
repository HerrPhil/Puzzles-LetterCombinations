# Puzzles-LetterCombinations

Find letter combinations related to phone number pad digits.

## Lesson Task Description

The input is a sequence of digits that are pressed on a phone.

The output is a list of strings where number of characters equals the number of digits.

For example, the user presses "23".

The solution returns `["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]`.

We will exercise a classic algorithm: recursive backtracking.

This inherently is a DFS (depth-first search).

We want a hash map that defines the letters on each button on the keypad.

For every map entry, the key is the number, and the value is all the letters it represents.

The algorithm tracks the current solution of the DFS traversal.

The solution starts at the empty state.

The backtrack starts traversing on every letter of the first digit.

The backtrack recursion begin with the next level of recursion of the next digit.

The backtrack recursion stop condition is when the current solution length is equal to the digits length.

The backtrack recursion returns to its calling point in the code.

Here one letter is popped from the solution, and the next letter is processed.

The overall answers are added to an answer list or array.

## Background Information

This [recursive backtracking](https://brilliant.org/wiki/recursive-backtracking/) article
and [depth first search](https://en.wikipedia.org/wiki/Depth-first_search) wiki post
can help in understanding the concepts used.
