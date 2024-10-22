import java.util.Scanner;

class Stack {
    int[] stackArray;
    int top;
    int size;

    // Constructor to initialize the stack
    Stack(int size) {
        this.size = size;
        this.stackArray = new int[size];
        this.top = -1;
    }

    // Push method to add elements to the stack
    void push(int element) {
        if (top + 1 == size) {
            System.out.println("Stack Overflow");
        } else {
            top++;
            stackArray[top] = element;
            System.out.println("Pushed: " + element);
        }
    }

    // Method to return the topmost element
    int top() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // Pop method to remove the topmost element
    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println("Popped: " + stackArray[top]);
            top--;
        }
    }

    // Method to check if the stack is empty
    boolean isEmpty() {
        return top == -1;
    }

    // Method to print the stack
    public String toString() {
        if (top == -1) {
            return "Stack is empty";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            result.append(stackArray[i]);
            if (i < top) {
                result.append(" -> ");
            }
        }
        return result.toString();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creating a stack of size 3
        Stack stack = new Stack(3);
        
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1: Push");
            System.out.println("2: Pop");
            System.out.println("3: Display Stack");
            System.out.println("4: Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println("Stack: " + stack);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
