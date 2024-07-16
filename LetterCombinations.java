import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class LetterCombinations {

    public static void main(String [] args) {
        System.out.printf("Hello Letter Combinations Solution #1%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java LetterCombinations <key-pad-digits>%n");
            return;
        }

        if (args == null || args.length == 0) { // check for args
            System.out.printf("The string of keypad digits is necessary  %n");
            return;
        }

        String input = args[0];
        boolean hasValidNumber = input.matches("^[2-9]+$");
        if (!hasValidNumber) {
            System.out.printf("Number must be digits between 2 and 9%n");
            return;
        }

        LetterCombinations letterCombinations = new LetterCombinations(input);

        List<String> result = letterCombinations.solution();

        System.out.printf("the letter combinations are%n");
        for (String combination : result) {
            System.out.printf("Combination: %s%n", combination);
        }

    }

    private String digits;
    private int n;
    private Map<String, String> letterMap;
    private char [] recursiveSolution;

    public LetterCombinations(String input) {
        digits = input;
        letterMap = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        n = digits.length();
        recursiveSolution = new char [n];
    }

    List<String> answer = new ArrayList<>();

    public List<String> solution() {

        System.out.printf("%nHere are the keypad map entries%n");
        for (Map.Entry<String, String> entry : letterMap.entrySet()) {
            System.out.printf("entry key = %s value %s%n", entry.getKey(), entry.getValue());
        }

        // another way to display the map
        System.out.printf("%n");
        letterMap
            .entrySet()
            .stream()
            .forEach(someEntry -> System.out.printf("entry key = %s value %s%n", someEntry.getKey(), someEntry.getValue()));

        System.out.printf("%nthe length of digits %s is %d%n", digits, n);

        backtrack(0);

        return answer;
    }

    /**
     * The digit index doubles as the recursion level.
     */
    public void backtrack(int digitIndex) {

        System.out.printf("at digit index %d%n", digitIndex);

        // Here is the stop condition.
        // The recursive solution has n characters in it.
        // This can be added to the answer list.
        if (digitIndex == n) {

            System.out.printf("When digit index %d equals n %d, then add next solution to answer%n", digitIndex, n);
            String nextSolution = new String(recursiveSolution);
            answer.add(nextSolution);
            
            return;

        }

        char nextDigit = digits.charAt(digitIndex);
        System.out.printf("the next digit is %c at digit index %d%n", nextDigit, digitIndex);

        String lettersOfDigit = letterMap.get(String.valueOf(nextDigit));
        System.out.printf("the letters of the digit are %s%n", lettersOfDigit);

        char [] charsOfDigit = lettersOfDigit.toCharArray();

        // Note that the next character of the current digit
        // is added in the same position in the recursive solution
        // as its respective digit's positions in the digits input string.

        for (char nextCharOfDigit : charsOfDigit) {

            System.out.printf("next character of digit %c is %c%n", nextDigit, nextCharOfDigit);

            // append a letter to the solution
            recursiveSolution[digitIndex] = nextCharOfDigit;
            System.out.printf("next character of digit %c is added to recursive solution at position %d%n", nextDigit, digitIndex);

            System.out.printf("make recursive call%n");
            backtrack(digitIndex + 1);
            System.out.printf("return from recursive call%n");

            // pop a letter from the solution
            recursiveSolution[digitIndex] = '\u0000';
            System.out.printf("next character of digit %c is popped from recursive solution at position %d%n", nextDigit, digitIndex);
        }

    }

}
