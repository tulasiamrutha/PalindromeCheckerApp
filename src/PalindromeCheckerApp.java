import java.util.*;

public class PalindromeCheckerApp {

    // 1. Reverse String Method
    static boolean reverseMethod(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return input.equals(reversed);
    }

    // 2. Two Pointer Method
    static boolean twoPointerMethod(String input) {
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    // 3. Stack Method
    static boolean stackMethod(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray())
            stack.push(c);
        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) != stack.pop())
                return false;
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (UC13) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Reverse Method Timing
        long start1 = System.nanoTime();
        boolean r1 = reverseMethod(input);
        long end1 = System.nanoTime();

        // Two Pointer Timing
        long start2 = System.nanoTime();
        boolean r2 = twoPointerMethod(input);
        long end2 = System.nanoTime();

        // Stack Method Timing
        long start3 = System.nanoTime();
        boolean r3 = stackMethod(input);
        long end3 = System.nanoTime();

        System.out.println("\n=== Results ===");
        System.out.println("Reverse Method: " + r1 + " | Time: " + (end1 - start1) + " ns");
        System.out.println("Two Pointer Method: " + r2 + " | Time: " + (end2 - start2) + " ns");
        System.out.println("Stack Method: " + r3 + " | Time: " + (end3 - start3) + " ns");

        scanner.close();
    }
}