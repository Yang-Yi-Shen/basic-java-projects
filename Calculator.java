public class Calculator {
    public static void main(String[] args) {
        // ensure there are sufficient arguments
        if (args.length < 3) {
            System.out.println("ERROR: at least two numbers required for an operation");
            System.exit(1);
        }

        // convert numerical arguents to floats from string
        float[] numbers = new float[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            numbers[i - 1] = Float.parseFloat(args[i]);
        }

        if (args[0].equals("add")) {
            // get sum of any number of arguments
            float sum = 0;

            for (int i = 0; i < numbers.length; i++) {
                float number = numbers[i];
                sum += number;
            }

            System.out.printf("The sum is: %f\n", sum);
        } else if (args[0].equals("subtract")) {
            // you can only subtract between two numbers, so confirm number of args first
            if (args.length > 3) {
                System.out.println("ERROR: cannot subtract more than two numbers");
                System.exit(1);
            }

            float difference = 0;
            difference = numbers[0] - numbers[1];

            System.out.printf("The difference is: %f\n", difference);
        } else if (args[0].equals("multiply")) {
            // get product of any number of arguments
            float product = 1;

            for (int i = 0; i < numbers.length; i++) {
                float number = numbers[i];
                product *= number;
            }

            System.out.printf("The product is: %f\n", product);
        } else if (args[0].equals("divide")) {
            // you can only divide between two numbers, so confirm number of args first
            if (args.length > 3) {
                System.out.println("ERROR: cannot divide more than two numbers");
                System.exit(1);
            }

            float quotient = 0;
            quotient = numbers[0] - numbers[1];

            System.out.printf("The quotient is: %f\n", quotient);
        } else {
            System.out.println("ERROR: invalid operator, supported operators are ADD SUBTRACT MULTIPLY and DIVIDE");
        }

        System.exit(0);
    }
}