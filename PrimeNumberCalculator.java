import java.util.Scanner;

/**
 * A class to generate primes and break numbers into its prime factors.
 *
 * A natural number is prime if it's divisible by only 1 and itself.
 * For example 2, 3, 5, 7 are prime numbers but 4, 6, 8, 9 are not prime numbers.
 * The number 1 is not a prime number. Every integer has a unique representation
 * of primes called it's unique prime factorization.
 *
 * @author Student#20172422
 */
public class PrimeNumberCalculator {
    /** method to determine if a number is a prime number */
    public static boolean isPrime(int number) {
        /** check if number is less than or equal to 2 */
        if(number <= 2){
            return false;
        }
        /** using for loop iterate over the range 2 to number */
        for (int i = 2; i < number; i++) {
            /** check if number is divisible by i */
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    /** method to return prime factors of number in a String */
    public static String getUniquePrimeFactorization(int number) {
        /** declare variable i and initialize with 2 */
        int i = 2;
        /** declare factors variable and initialize with "" */
        String factors = "";
        /** while loop with condition i less than number */
        while (i < number) {
            while (number % i == 0) {
                number /= i;
                factors = factors + " " + i;
            }
            /** increment i by 1 */
            i++;
        }
        /** check to see if the number is greater than 2 */
        if(number > 2) {
            /** append number to factors String */
            factors = factors + " " + number;
        }
        /** return factors */
        return factors;
    }
    /** displayPrime method to display prime numbers in range minLimit and maxLimit */
    public static void displayPrime(int minLimit, int maxLimit) {
        System.out.println("\nPrime numbers are: ");
        /** for loop in range of minLimit and maxLimit */
        for(int i = minLimit; i <= maxLimit; i++){
            /** check if i is prime number by calling isPrime method */
            if(PrimeNumberCalculator.isPrime(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    /** displayFactors method to display prime factors for numbers in range of minLimit and maxLimit */
    public static void displayFactors(int minLimit, int maxLimit) {
        System.out.println();
        /** for loop in range of minLimit and maxLimit */
        for(int i = minLimit; i <= maxLimit; i++){
            /** get the prime factors of i in String format by calling method getUniquePrimeFactorization */
            String primeFactors = PrimeNumberCalculator.getUniquePrimeFactorization(i);
            /** print prime factors of i */
            System.out.println("Prime factors of " + i + ": " + primeFactors);
        }
    }
    /** Main function to test code */
    public static void main(String[] args) {
        int choice;
        int minLimit, maxLimit;
        do {
            String menu = "Prime Number Calculator" +
                    "\n1: Print all prime numbers upto a limit \n" +
                    "2: Print all prime numbers between a range of values \n" +
                    "3: Print unique prime factorization of a number\n" +
                    "4: Print all prime factorization upto a limit \n" +
                    "5: Exit\n" +
                    "Enter choice: ";
            /** create a Scanner to read input from the user */
            Scanner scanner = new Scanner(System.in);
            /** loop until the user chooses the exit option */
            /** print the menu */
            System.out.print(menu);
            /** see what the user chose */
            choice = scanner.nextInt();
            /** depending on choice, call the method chosen and print the result */
            if (choice == 1) {
                /** prompt user to enter limit value */
                System.out.print("Enter a limit value: ");
                /** input value entered by user in maxLimit variable */
                maxLimit = scanner.nextInt();
                displayPrime(1, maxLimit);
            } else if (choice == 2) {
                /** prompt user to enter min limit and max limit */
                System.out.print("Enter min limit and max limit values: ");
                /** input min limit and max limit entered by user in minLimit variable */
                minLimit = scanner.nextInt();
                maxLimit = scanner.nextInt();
                displayPrime(minLimit, maxLimit);
            } else if (choice == 3) {
                /** prompt user to enter value to print factors of */
                System.out.print("Enter a value to display factors: ");
                /** input number value entered by user in maxLimit variable */
                maxLimit = scanner.nextInt();
                displayFactors(maxLimit, maxLimit);
            } else if (choice == 4) {
                /** prompt user to enter value to print factors upto that number */
                System.out.print("Enter limit number to display factors upto the limit: ");
                maxLimit = scanner.nextInt();
                displayFactors(2, maxLimit);
            } else if (choice == 5) {
                /** exit */
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid choice!");
            }
        }while (choice != 5);
        }
}
