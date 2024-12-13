package org.miniproject;

public class MemoryBlock {
    int size;
    boolean isAllocated;

    public MemoryBlock(int size) {
        this.size = size;
        this.isAllocated = false;
    }
}