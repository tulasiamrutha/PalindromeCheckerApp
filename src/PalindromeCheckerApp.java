import java.util.Scanner;

public class PalindromeCheckerApp {

    // Palindrome check logic
    static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (UC10) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize string:
        // 1. Convert to lowercase
        // 2. Remove spaces using regex
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        boolean result = isPalindrome(normalized);

        if (result) {
            System.out.println("Result: The given string is a Palindrome (ignoring spaces & case).");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}