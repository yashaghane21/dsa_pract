import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    void dfsPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            dfsPreOrder(node.left);
            dfsPreOrder(node.right);
        }
    }

    void dfsInOrder(Node node) {
        if (node != null) {
            dfsInOrder(node.left);
            System.out.print(node.data + " ");
            dfsInOrder(node.right);
        }
    }

    void dfsPostOrder(Node node) {
        if (node != null) {
            dfsPostOrder(node.left);
            dfsPostOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1: Insert Node");
            System.out.println("2: Perform Pre-Order DFS");
            System.out.println("3: Perform In-Order DFS");
            System.out.println("4: Perform Post-Order DFS");
            System.out.println("5: Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    tree.root = insertNode(tree.root, value);
                    System.out.println(value + " inserted.");
                    break;
                case 2:
                    System.out.println("Pre-Order DFS Traversal:");
                    tree.dfsPreOrder(tree.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("In-Order DFS Traversal:");
                    tree.dfsInOrder(tree.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Post-Order DFS Traversal:");
                    tree.dfsPostOrder(tree.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static Node insertNode(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insertNode(root.left, data);
        } else if (data > root.data) {
            root.right = insertNode(root.right, data);
        }

        return root;
    }
}
