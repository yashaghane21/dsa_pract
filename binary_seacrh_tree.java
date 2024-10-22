import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    boolean search(int data) {
        return searchRec(root, data);
    }

    boolean searchRec(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (data < root.data) {
            return searchRec(root.left, data);
        } else if (data > root.data) {
            return searchRec(root.right, data);
        } else {
            return true;
        }
    }

    void inOrderTraversal() {
        inOrderRec(root);
    }

    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1: Insert");
            System.out.println("2: Search");
            System.out.println("3: In-order Traversal");
            System.out.println("4: Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    bst.insert(value);
                    System.out.println(value + " inserted.");
                    break;
                case 2:
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();
                    boolean found = bst.search(searchValue);
                    if (found) {
                        System.out.println(searchValue + " is present in the BST.");
                    } else {
                        System.out.println(searchValue + " is not found.");
                    }
                    break;
                case 3:
                    System.out.println("In-order Traversal:");
                    bst.inOrderTraversal();
                    System.out.println();
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
