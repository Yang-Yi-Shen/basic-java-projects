public class Calculator {
    public static void main(String[] args) {
        // ensure there are sufficient arguments
        if (args.length < 3) {
            System.out.println("ERROR: at least two numbers required for an operation");
            System.exit(1);
        }

        if (args[0].equals("add")) {
            // get sum of any number of arguments
            int sum = 0;

            for (int i = 1; i < args.length; i++) {
                int number = Integer.parseInt(args[i]);
                sum += number;
            }

            System.out.printf("The sum is: %d\n", sum);
            System.exit(0);
        } else if (args[0].equals("subtract")) {
            // you can only subtract between two numbers, so confirm number of args first
            if (args.length > 3) {
                System.out.println("ERROR: cannot subtract more than two numbers");
                System.exit(1);
            }

            int difference = 0;
            difference = Integer.parseInt(args[1]) - Integer.parseInt(args[2]);

            System.out.printf("The difference is: %d\n", difference);
            System.exit(0);
        } else if (args[0].equals("multiply")) {
            // get product of any number of arguments
            int product = 0;

            for (int i = 1; i < args.length; i++) {
                int number = Integer.parseInt(args[i]);
                product *= number;
            }

            System.out.printf("The product is: %d\n", product);
            System.exit(0);
        } else if (args[0].equals("divide")) {
            // you can only divide between two numbers, so confirm number of args first
            if (args.length > 3) {
                System.out.println("ERROR: cannot divide more than two numbers");
                System.exit(1);
            }

            float quotient = 0;
            quotient = Float.parseFloat(args[1]) / Float.parseFloat(args[2]);

            System.out.printf("The quotient is: %f\n", quotient);
            System.exit(0);
        } else {
            System.out.println("ERROR: invalid operator, supported operators are ADD SUBTRACT MULTIPLY and DIVIDE");
        }
    }
}