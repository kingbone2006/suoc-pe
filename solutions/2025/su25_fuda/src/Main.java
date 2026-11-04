import java.util.*;
public class Main {
    static class AIModel {
        String name; int monthPublish; int size;
        AIModel(String name, int monthPublish, int size) {
            this.name = name; this.monthPublish = monthPublish; this.size = size;
        }
        public String toString() { return "(" + name + "," + monthPublish + "," + size + ")"; }
    }
    static class Node {
        AIModel info; Node left, right; int height;
        Node(AIModel info) { this.info = info; this.height = 1; }
    }
    static class AVLTree {
        Node root;
        int height(Node n) { return n == null ? 0 : n.height; }
        int getBalance(Node n) { return n == null ? 0 : height(n.left) - height(n.right); }
        Node rightRotate(Node y) {
            Node x = y.left; Node T2 = x.right; x.right = y; y.left = T2;
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            return x;
        }
        Node leftRotate(Node x) {
            Node y = x.right; Node T2 = y.left; y.left = x; x.right = T2;
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            return y;
        }
        Node insert(Node node, AIModel info) {
            if (node == null) return new Node(info);
            if (info.size < node.info.size) node.left = insert(node.left, info);
            else if (info.size > node.info.size) node.right = insert(node.right, info);
            else return node;
            node.height = 1 + Math.max(height(node.left), height(node.right));
            int balance = getBalance(node);
            if (balance > 1 && info.size < node.left.info.size) return rightRotate(node);
            if (balance < -1 && info.size > node.right.info.size) return leftRotate(node);
            if (balance > 1 && info.size > node.left.info.size) { node.left = leftRotate(node.left); return rightRotate(node); }
            if (balance < -1 && info.size < node.right.info.size) { node.right = rightRotate(node.right); return leftRotate(node); }
            return node;
        }
        void inOrder(Node p) {
            if (p == null) return;
            inOrder(p.left); System.out.print(p.info + " "); inOrder(p.right);
        }
    }
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, new AIModel("GPT4", 3, 175));
        tree.root = tree.insert(tree.root, new AIModel("BERT", 10, 110));
        tree.root = tree.insert(tree.root, new AIModel("LLaMA", 2, 70));
        tree.inOrder(tree.root);
        System.out.println();
    }
}