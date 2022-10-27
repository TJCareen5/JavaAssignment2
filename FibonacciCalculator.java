import java.util.Scanner;
/**
 *  A class that allows someone to validate and generate Fibonacci Numbers
 *  The Fibonacci numbers, commonly denoted Fn, form a sequence, called the
 *  Fibonacci sequence, such that each number is the sum of the two preceding ones,
 *  starting from 0 and 1.
 *  That is:
 *
 *      F_0 = 0 and F_1 = 1
 *      And
 *      F_N = F_N-1 + F_N-2
 *
 *  The beginning of the sequence is thus: 0, 1, 1, 2, 3, 5, 8, 13, ...
 *
 * @author Student#20172422
 */
public class FibonacciCalculator {
    /** Method to Check to see if an integer passed in is a Fibonacci number. */
    public static boolean isFibonacciNumber(int number) {
        int a = 0;
        int b = 1;
        int f = 0;
        /** loop until the f variable exceeds the number */
        while (f < number) {
            /** add a and b, store the result in f */
            f = a + b;
            a = b;
            b = f;
        }
        /** if f is equal to number, then number is a fibonacci number */
        return f == number;
    }

    /** method to calculate fibonacci number */
    public static int getFibonacciNumber(int number){
        int a = 0;
        int b = 1;
        int f = 0;
        /** loop for number times */
        for (int i = 0; i < number; i++) {
            /** add a and b, store the result in f */
            f = a + b;
            a = b;
            b = f;
        }
        return a;
    }


    /** Main function to test code */
    public static void main(String[] args) {
        int choice;
        do {
            String menu = "Fibonacci Calculator\n" +
                    "1. Prints all Fibonacci numbers up to users input\n" +
                    "2. Prints Fibonacci numbers equal to a limit number\n" +
                    "3. Check if an entered number is a Fibonacci number\n" +
                    "4. Exit\n" +
                    "Your choice: " ;
            /** create a Scanner to read input from the user */
            Scanner scanner = new Scanner(System.in);
            /** loop until the user chooses the exit option */
            /** print the menu */
            System.out.print(menu);
            /** see what the user chose */
            choice = scanner.nextInt();
            /** depending on choice, call the method chosen and print the result */
            if (choice == 1) {
                /** prompt user to enter number */
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();
                /** loop from 0 to number-1 and print each number where isFibonacciNumber returns true */
                for (int i = 0; i < number; i++) {
                    if (FibonacciCalculator.isFibonacciNumber(i)) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();

            } else if (choice == 2) {
                /** prompt user to enter limit to print Fibonacci numbers upto the limit */
                System.out.print("Enter limit number: ");
                int number = scanner.nextInt();
                /** loop from 0 to n-1 and print each number returned by the getFibonacciNumber method */
                for (int i = 0; i < number; i++) {
                    System.out.print(FibonacciCalculator.getFibonacciNumber(i) + " ");
                }
                System.out.println();
            } else if (choice == 3) {
                /** prompt user to enter number to check if it is a Fibonacci number */
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();
                /** call isFibonacciNumber and print the results */
                if (FibonacciCalculator.isFibonacciNumber(number)) {
                    System.out.println(number + " is a Fibonacci number");
                } else {
                    System.out.println(number + " is not a Fibonacci number");
                }
            } else if (choice == 4) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }while(choice != 4);
        }
}