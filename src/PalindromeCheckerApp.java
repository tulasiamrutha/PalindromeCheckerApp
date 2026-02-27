public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // UC2: Hardcoded Palindrome Check
        // -------------------------------

        // Hardcoded String Literal
        String word = "madam";

        // Variable to store reversed string
        String reversed = "";

        // Reverse the string
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        // Check Palindrome using if-else
        if (word.equals(reversed)) {
            System.out.println("The given string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + word + "\" is NOT a Palindrome.");
        }

        System.out.println("-----------------------------------------------");
        System.out.println("PROGRAM TERMINATED SUCCESSFULLY");

    }
}