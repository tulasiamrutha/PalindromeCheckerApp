import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based Strategy (LIFO)
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based Strategy (Front & Rear comparison)
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

// Context Class
class PalindromeService {
    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }
}

// Application Class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeService service = new PalindromeService();

        System.out.println("=== Palindrome Checker App (UC12) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        // Dynamic Strategy Selection
        if (choice == 1) {
            service.setStrategy(new StackStrategy());
        } else if (choice == 2) {
            service.setStrategy(new DequeStrategy());
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        boolean result = service.check(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}