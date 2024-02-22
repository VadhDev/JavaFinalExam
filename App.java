//? Allow user to enter the numbers 
//? Display number 

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int arraySize = scanner.nextInt();

        int[] inputNumber = new int[arraySize];

        System.out.println("Enter the numbers:");
        for (int i = 0; i < arraySize; i++) {
            inputNumber[i] = scanner.nextInt();
        }

        System.out.println("**************************************");
        System.out.print("Number You Input ~ ");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(inputNumber[i] + " ; ");
        }
        System.out.println(" ");
        System.out.println("************************************");

        scanner.close();
    }
}
