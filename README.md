# Buddy System Memory Management Project

### Overview

This project implements a **Buddy System** memory management algorithm in Java. It simulates dynamic memory allocation and deallocation, demonstrating how memory is split and merged based on allocation requirements. 

The program is built as a Maven project using IntelliJ IDEA, and it includes functionality for memory allocation, deallocation, and visualization of memory states.

## Features

1. **Memory Allocation**: Dynamically allocates memory blocks using the Buddy System algorithm.
2. **Memory Deallocation**: Frees allocated memory blocks and merges buddy blocks if possible.
3. **Memory Visualization**: Displays the current memory state, showing allocated and free blocks.
4. **Interactive Menu**: Provides an intuitive console-based menu for users to interact with the system.

## Technologies Used

- **Programming Language**: Java  
- **Build Tool**: Maven  
- **IDE**: IntelliJ IDEA  

## How to Run the Project

### Prerequisites
1. Install Java Development Kit (JDK) 8 or later.
2. Install Maven for dependency management.
3. Install IntelliJ IDEA or any preferred Java IDE.

## Usage

1. Launch the application.
2. Choose an option from the interactive menu:
   - **1**: Allocate memory by specifying the required size in KB.
   - **2**: Free memory by specifying the size of the block to deallocate.
   - **3**: View the current memory state, including free and allocated blocks.
3. Follow the on-screen prompts to perform actions.


## Project Structure

src
└── main
    ├── java
    │   └── org.miniproject
    │       ├── Main.java
    │       └── MemoryBlock.java
    └── resources

## Future Enhancements

1. Add a graphical user interface (GUI) for better user interaction.
2. Enhance error handling and input validation.
3. Extend functionality to support persistent memory states.

