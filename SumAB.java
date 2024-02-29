public class SumAB {
    public static void main(String[] args) {
        // check if there are two arguments
        if (args.length != 2) {
            System.err.println("ERROR: Two arguments must be passed, no less, no more");

            System.exit(1);
        }

        // check if both arguments are integers
        try {
            int A = Integer.parseInt(args[0]);
            int B = Integer.parseInt(args[1]);

            int sumAB = A + B;

            // if all checks pass, print result
            System.out.printf("Result: %d\n", sumAB);

            System.exit(0);
        } catch (NumberFormatException e) {
            System.err.println("ERROR: Both arguments must be integers");

            System.exit(1);
        }
    }
}