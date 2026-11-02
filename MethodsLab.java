/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package methodslab;

import java.util.Scanner;

/**
 *
 * @author ASUS 2
 */
public class MethodsLab {

    /**
     *
     */
    // INPUT VALIDATION METHOD
    // Accepts exactly the required number of integers
    public static int[] readExactInts(Scanner input, int count) {

        while (true) {
            String line = input.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("Warning: Input cannot be empty.");
                System.out.print("Try again: ");
                continue;
            }

            String[] values = line.split("\\s+");

            if (values.length != count) {
                System.out.println("Warning: Please enter exactly "
                        + count + " number(s).");
                System.out.print("Try again: ");
                continue;
            }

            int[] numbers = new int[count];

            try {
                for (int i = 0; i < count; i++) {
                    numbers[i] = Integer.parseInt(values[i]);
                }

                return numbers;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                System.out.print("Try again: ");
            }
        }
    }

    // INPUT VALIDATION METHOD FOR ONE WORD
    public static String readExactWord(Scanner input) {

        while (true) {
            String word = input.nextLine().trim();

            if (word.isEmpty()) {
                System.out.println("Warning: Input cannot be empty.");
                System.out.print("Try again: ");
            } else if (word.split("\\s+").length != 1) {
                System.out.println("Warning: Please enter only one word.");
                System.out.print("Try again: ");
            } else {
                return word;
            }
        }
    }

    // TASK 1: GREETING METHOD
    public static void greetPeople() {
        System.out.println("Hello People, welcome to the Math Program!");
    }

    // TASK 2: ARITHMETIC METHODS
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    // TASK 3: FACTORIAL METHOD (ITERATIVE)
    public static long factorial(int n) {
        long result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    // TASK 4: SUM OF ARRAY
    public static int sumArray(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    // TASK 5: PRIME NUMBER CHECKER
    public static boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
    

    // TASK 6: MAXIMUM ELEMENT IN ARRAY
    public static int maxInArray(int[] numbers) {
        int max = numbers[0];

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }

    
    // TASK 7: GREATEST COMMON DIVISOR
    public static int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // TASK 7: LEAST COMMON MULTIPLE
    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    // CHALLENGE 1: RECURSIVE FACTORIAL
    public static long recursiveFactorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * recursiveFactorial(n - 1);
    }

    
    // CHALLENGE 2: RECURSIVE FIBONACCI
    public static long fib(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
    

    // CHALLENGE 3: PALINDROME CHECKER
    public static boolean isPalindrome(String word) {

        word = word.toLowerCase();

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {

            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // TASK 1
        greetPeople();

        // TASK 2: ARITHMETIC
        System.out.print("\nEnter exactly two numbers: ");
        int[] arithmetic = readExactInts(input, 2);

        int num1 = arithmetic[0];
        int num2 = arithmetic[1];

        System.out.println("Addition: " + add(num1, num2));
        System.out.println("Subtraction: " + subtract(num1, num2));
        System.out.println("Multiplication: " + multiply(num1, num2));

        if (num2 != 0) {
            System.out.println("Division: " + divide(num1, num2));
        } else {
            System.out.println("Division: Cannot divide by zero.");
        }
        

        // TASK 3: FACTORIAL
        // The input is limited to 0-20 because the long data type
        // cannot store factorial results greater than 20!.
        // This prevents integer overflow and incorrect results.
        
        System.out.print("\nEnter a number for factorial (0-20): ");
        int factNum;

        while (true) {
            int[] values = readExactInts(input, 1);
            factNum = values[0];

            if (factNum >= 0 && factNum <= 20) {
                break;
            }

            System.out.println("Warning: Enter a number from 0 to 20 only.");
            System.out.print("Try again: ");
        }

        System.out.println("Factorial: " + factorial(factNum));

        // TASK 4: SUM OF ARRAY
        System.out.println("\nEnter exactly 5 numbers for the array:");
        int[] numbers = readExactInts(input, 5);

        System.out.println("Sum of array elements: " + sumArray(numbers));

        // TASK 5: PRIME CHECKER
        System.out.print("\nEnter a number to check prime: ");
        int[] primeInput = readExactInts(input, 1);

        int primeNum = primeInput[0];

        if (isPrime(primeNum)) {
            System.out.println(primeNum + " is prime.");
        } else {
            System.out.println(primeNum + " is not prime.");
        }

        // TASK 6: MAXIMUM ELEMENT
        System.out.println("\nLargest element in array: "
                + maxInArray(numbers));

        // TASK 7: GCD AND LCM
        System.out.println("\nEnter exactly two positive integers for GCD and LCM:");

        int[] gcdInput;

        while (true) {
            gcdInput = readExactInts(input, 2);

            if (gcdInput[0] > 0 && gcdInput[1] > 0) {
                break;
            }

            System.out.println("Warning: Both numbers must be positive.");
            System.out.print("Try again: ");
        }

        int a = gcdInput[0];
        int b = gcdInput[1];

        System.out.println("GCD: " + gcd(a, b));
        System.out.println("LCM: " + lcm(a, b));

        // CHALLENGE 1: RECURSIVE FACTORIAL
        // NOTE: Large input values may exceed the storage capacity
        // of the long data type and cause incorrect results.
        System.out.print("\nEnter a number for recursive factorial : ");

        int recursiveNum;

        while (true) {
            int[] values = readExactInts(input, 1);
            recursiveNum = values[0];

            if (recursiveNum >= 0 && recursiveNum <= 20) {
                break;
            }

            System.out.println("Warning: Enter a number from 0 to 20 only.");
            System.out.print("Try again: ");
        }

        System.out.println("Recursive Factorial: "
                + recursiveFactorial(recursiveNum));

        // CHALLENGE 2: FIBONACCI
        // NOTE: Recursive Fibonacci may take a long time for large
        // input values because the method repeatedly calls itself.
        // The long data type also has a limited storage capacity.
        System.out.print("\nEnter a number for Fibonacci (0-40): ");

        int fibNum;

        while (true) {
            int[] values = readExactInts(input, 1);
            fibNum = values[0];

            if (fibNum >= 0 && fibNum <= 40) {
                break;
            }

            System.out.println("Warning: Enter a number from 0 to 40 only.");
            System.out.print("Try again: ");
        }

        System.out.println("Fibonacci: " + fib(fibNum));

        // CHALLENGE 3: PALINDROME
        System.out.print("\nEnter one word to check palindrome: ");

        String word = readExactWord(input);

        if (isPalindrome(word)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }

        System.out.println("\nThank you for using the Math Program!");

        input.close();
    }
}
