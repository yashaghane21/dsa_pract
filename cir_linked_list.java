import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head = null;

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Point to itself
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head; // Complete the circular link
        }
    }

    void delete(int key) {
        if (head == null) return;

        Node temp = head, prev = null;

        // If the node to be deleted is the head node
        if (temp.data == key) {
            while (temp.next != head) {
                temp = temp.next;
            }
            if (head == head.next) {
                head = null; // List becomes empty
            } else {
                temp.next = head.next; // Change head to next node
                head = head.next; // Update head
            }
            return;
        }

        // Search for the node to be deleted
        while (temp.next != head && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp.data == key) {
            prev.next = temp.next; // Bypass the node to be deleted
        } else {
            System.out.println("Node with value " + key + " not found.");
        }
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1: Insert Node");
            System.out.println("2: Delete Node");
            System.out.println("3: Display List");
            System.out.println("4: Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    list.insert(value);
                    System.out.println(value + " inserted.");
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();
                    list.delete(deleteValue);
                    break;
                case 3:
                    System.out.println("Circular Linked List:");
                    list.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
