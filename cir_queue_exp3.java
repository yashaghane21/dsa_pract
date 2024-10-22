import java.util.Scanner;

class CircularQueue {
    int[] queueArray;
    int front, rear, size;

 
    CircularQueue(int size) {
        this.size = size;
        this.queueArray = new int[size];
        this.front = -1;
        this.rear = -1;
    }

 
    void enqueue(int element) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue Overflow");
        } else {
            if (front == -1) {
                front = 0; 
            }
            rear = (rear + 1) % size;
            queueArray[rear] = element;
            System.out.println("Enqueued: " + element);
        }
    }

 
    void dequeue() {
        if (front == -1) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println("Dequeued: " + queueArray[front]);
            if (front == rear) {
                front = rear = -1;  
            } else {
                front = (front + 1) % size;
            }
        }
    }

 
    boolean isEmpty() {
        return front == -1;
    }


    public String toString() {
        if (front == -1) {
            return "Queue is empty";
        }
        StringBuilder result = new StringBuilder();
        int i = front;
        while (true) {
            result.append(queueArray[i]);
            if (i == rear) {
                break;
            }
            result.append(" -> ");
            i = (i + 1) % size;
        }
        return result.toString();
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        CircularQueue queue = new CircularQueue(5);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1: Enqueue");
            System.out.println("2: Dequeue");
            System.out.println("3: Display Queue");
            System.out.println("4: Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println("Queue: " + queue);
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
