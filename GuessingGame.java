import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = (int) (Math.random() * 10 + 1);
        int totalTries = 0;

        System.out.println("This is the number guessing game!\nThe program has randomly selected a number from 1 to 10. Try to guess what it is!");
        System.out.printf("--------------------\n");

        while (true) {
            String[] input = scanner.nextLine().split(" ");

            if (input.length > 1) {
                System.out.println("ERROR: Input should be a single number only");
                continue;
            }

            try {
                Integer.parseInt(input[0]);
            } catch (Exception e) {
                System.out.println("ERROR: Input is not a number");
                continue;
            }

            int guess = Integer.parseInt(input[0]);
            if (guess == number) {
                System.out.println("Congratulations, you guessed correctly!");
                break;
            } else if (totalTries < 9) {
                totalTries += 1;
                System.out.printf("Wrong number, try again! You have %d tries left\n", 10 - totalTries);
                continue;
            } else {
                System.out.printf("Wrong! The correct number was %d\n", number);
                break;
            }
        }

        scanner.close();
        System.exit(0);
    }
}
