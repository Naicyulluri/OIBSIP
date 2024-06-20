import java.util.Random;
import java.util.Scanner;
public class GuessTheNumberGame{

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int rounds = 2;

        for (int round = 1; round <= rounds; round++) {
            int target = random.nextInt(100) + 1, attempts = 10, points = 10;
            System.out.println("Round " + round + ": Guess the number between 1 and 100");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts--;

                if (guess == target) {
                    System.out.println("Congratulations! You guessed the number.");
                    totalScore += points;
                    break;
                } else {
                    System.out.println("The number is " + (guess < target ? "higher" : "lower") + " than your guess.");
                    points--;
                    System.out.println("Attempts left: " + attempts);
                }
            }

            if (attempts == 0) {
                System.out.println("Out of attempts! The number was: " + target);
            }
            System.out.println("Score for this round: " + points + "\n");
        }

        System.out.println("Game over Your total score is: " + totalScore);
        scanner.close();
    }
}
