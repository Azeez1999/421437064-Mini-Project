package org.miniproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoryManager {
    private final List<MemoryBlock> memoryBlocks;

    public MemoryManager() {
        memoryBlocks = new ArrayList<>();
        memoryBlocks.add(new MemoryBlock(1024)); // Initialize with 1024 KB block
    }

    public void allocateMemory(Scanner scanner) {
        System.out.print("Enter the size of memory you need to allocate (in KB): ");
        try {
            int size = Integer.parseInt(scanner.nextLine());
            int allocationSize = getSmallestPowerOfTwo(size);
            boolean allocated = false;

            for (int i = 0; i < memoryBlocks.size(); i++) {
                if (!memoryBlocks.get(i).isAllocated && memoryBlocks.get(i).size >= allocationSize) {
                    splitBlock(i, allocationSize);
                    memoryBlocks.get(i).isAllocated = true;
                    System.out.println("\nAllocated Block of Size: " + allocationSize + "KB\n");
                    allocated = true;
                    printMemoryState();
                    break;
                }
            }

            if (!allocated) {
                System.out.println("Not enough memory to allocate the requested size.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }

    public void freeMemory(Scanner scanner) {
        System.out.print("Enter the size of the memory block you want to free (in KB): ");
        try {
            int size = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < memoryBlocks.size(); i++) {
                if (memoryBlocks.get(i).isAllocated && memoryBlocks.get(i).size == size) {
                    memoryBlocks.get(i).isAllocated = false;
                    System.out.println("Freed Block of Size: " + size + "KB\n");
                    mergeBuddies();
                    printMemoryState();
                    return;
                }
            }
            System.out.println("No allocated block of that size found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }

    public void printMemoryState() {
        int totalMemory = 1024;
        int allocatedMemory = memoryBlocks.stream()
                .filter(block -> block.isAllocated)
                .mapToInt(block -> block.size)
                .sum();
        int freeMemory = totalMemory - allocatedMemory;

        System.out.println("\nCurrent Memory State:");
        System.out.println("Total Memory: " + totalMemory + "KB");
        System.out.println("Allocated Memory: " + allocatedMemory + "KB");
        System.out.println("Free Memory: " + freeMemory + "KB\n");

        System.out.println("Free Blocks:");
        for (MemoryBlock block : memoryBlocks) {
            System.out.println("Block Size: " + block.size + "KB, Allocated: " + block.isAllocated);
        }
    }

    private int getSmallestPowerOfTwo(int size) {
        int power = 1;
        while (power < size) {
            power *= 2;
        }
        return power;
    }

    private void splitBlock(int index, int allocationSize) {
        while (memoryBlocks.get(index).size > allocationSize) {
            int newSize = memoryBlocks.get(index).size / 2;
            memoryBlocks.get(index).size = newSize;
            memoryBlocks.add(index + 1, new MemoryBlock(newSize));
        }
    }

    private void mergeBuddies() {
        for (int i = 0; i < memoryBlocks.size() - 1; i++) {
            if (!memoryBlocks.get(i).isAllocated && !memoryBlocks.get(i + 1).isAllocated &&
                    memoryBlocks.get(i).size == memoryBlocks.get(i + 1).size) {
                memoryBlocks.get(i).size *= 2;
                memoryBlocks.remove(i + 1);
                i = -1; // Restart the loop after merging
            }
        }
    }
}
