import java.util.*;
public class Main {
    static class Employee {
        int id; String name; double salary;
        Employee(int id, String name, double salary) {
            this.id = id; this.name = name; this.salary = salary;
        }
        public String toString() { return "(" + id + "," + name + "," + salary + ")"; }
    }
    static class Node {
        Employee info; Node left, right;
        Node(Employee x) { info = x; left = right = null; }
    }
    static class BST {
        Node root;
        BST() { root = null; }
        void insert(Employee x) {
            Node q = new Node(x);
            if(root == null) { root = q; return; }
            Node p = root, f = null;
            while(p != null) {
                if(p.info.id == x.id) return;
                f = p;
                if(x.id < p.info.id) p = p.left;
                else p = p.right;
            }
            if(x.id < f.info.id) f.left = q;
            else f.right = q;
        }
        void inOrder(Node p) {
            if(p == null) return;
            inOrder(p.left); System.out.print(p.info + " "); inOrder(p.right);
        }
    }
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(new Employee(3, "Alice", 1500));
        tree.insert(new Employee(1, "Bob", 1200));
        tree.insert(new Employee(5, "Charlie", 2000));
        tree.inOrder(tree.root);
        System.out.println();
    }
}