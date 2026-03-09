import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive palindrome check
    static boolean isPalindrome(String str, int start, int end) {

        // Base condition
        if (start >= end)
            return true;

        // If characters don’t match
        if (str.charAt(start) != str.charAt(end))
            return false;

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (UC9) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}