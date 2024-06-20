import java.util.Scanner;
public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private static String userId = "01234";
    private static String userPin = "9876";
    private static double balance = 5000.0; // Initial balance

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM");
        authenticateUser();
    }

    private static void authenticateUser() {
        System.out.print("Enter User ID: ");
        String inputId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String inputPin = scanner.nextLine();

        if (inputId.equals(userId) && inputPin.equals(userPin)) {
            System.out.println("Authentication successfull");
            displayMenu();
        } else {
            System.out.println("Invalid credentials. Please try again.");
            authenticateUser();
        }
    }

    private static void displayMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Quit");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Your balance is: $" + balance);
                displayMenu();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                System.out.println("Thank you for using the ATM");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMenu();
                break;
        }
    }

    private static void withdraw() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
        }
        displayMenu();
    }

    private static void deposit() {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();

        balance += amount;
        System.out.println("$" + amount + " deposited successfully.");
        displayMenu();
    }
}