package org.miniproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemoryManager memoryManager = new MemoryManager();

        while (true) {
            System.out.println("\nChoose the Option:");
            System.out.println("1. Allocate Memory");
            System.out.println("2. Free Memory");
            System.out.println("3. Print Memory State");

            System.out.print("Enter your option here: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    memoryManager.allocateMemory(scanner);
                    break;
                case "2":
                    memoryManager.freeMemory(scanner);
                    break;
                case "3":
                    memoryManager.printMemoryState();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    break;
            }
        }
    }
}
