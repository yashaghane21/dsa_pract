import java.util.Scanner;

class Node {
    int data;
    Node next;

  
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

  
    SinglyLinkedList() {
        this.head = null;
    }

   
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {  
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {  
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Inserted: " + data);
    }

 
    void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == data) {
            head = head.next;
            System.out.println("Deleted: " + data);
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }

     
        if (temp.next != null) {
            System.out.println("Deleted: " + data);
            temp.next = temp.next.next;
        } else {
            System.out.println("Element not found");
        }
    }

  
    void display() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1: Insert");
            System.out.println("2: Delete");
            System.out.println("3: Display List");
            System.out.println("4: Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    list.insert(value);
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();
                    list.delete(deleteValue);
                    break;
                case 3:
                    list.display();
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
