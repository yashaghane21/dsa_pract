import java.util.LinkedList;
import java.util.Queue;
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

    void bfs() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
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
            System.out.println("2: Perform BFS");
            System.out.println("3: Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    tree.root = insertNode(tree.root, value);
                    System.out.println(value + " inserted.");
                    break;
                case 2:
                    System.out.println("BFS Traversal:");
                    tree.bfs();
                    System.out.println();
                    break;
                case 3:
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
