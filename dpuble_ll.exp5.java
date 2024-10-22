import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

   
    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    
    DoublyLinkedList() {
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
            newNode.prev = temp;
        }
        System.out.println("Inserted: " + data);
    }


    void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

      
        if (temp.data == data) {
            if (temp.next != null) {
                temp.next.prev = null;
            }
            head = temp.next;
            System.out.println("Deleted: " + data);
            return;
        }

      
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Element not found");
            return;
        }

     
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }

        System.out.println("Deleted: " + data);
    }

    
    void displayForward() {
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

  
    void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp.next != null) { 
                temp = temp.next;
            }
            while (temp != null) {  
                System.out.print(temp.data + " -> ");
                temp = temp.prev;
            }
            System.out.println("null");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1: Insert");
            System.out.println("2: Delete");
            System.out.println("3: Display Forward");
            System.out.println("4: Display Backward");
            System.out.println("5: Exit");
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
                    System.out.println("List (Forward): ");
                    list.displayForward();
                    break;
                case 4:
                    System.out.println("List (Backward): ");
                    list.displayBackward();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
