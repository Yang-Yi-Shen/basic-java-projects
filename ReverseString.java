public class ReverseString {
    public static void main(String[] args) {
        // makes sure that there is only one argument
        if (args.length != 1) {
            System.err.println("ERROR: only one argument should be passed");

            System.exit(1);
        }

        String inputString = args[0];
        String[] splitInputString = inputString.split("(?!^)");
        String[] splitOutputString = new String[splitInputString.length];

        for (int i = 0, j = splitInputString.length - 1; i < splitInputString.length; i++, j--) {
            splitOutputString[j] = splitInputString[i];
        }

        System.out.printf("Result: %s\n", String.join("", splitOutputString));
        System.exit(0);
    }
}
