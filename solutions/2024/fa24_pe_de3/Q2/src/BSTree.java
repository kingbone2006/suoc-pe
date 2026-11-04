/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xOwner, int xHorn, int xColor) {
        //You should insert here statements to complete this function
        if (xOwner.charAt(0) == 'A') {
            return;
        }
        Cala newCala = new Cala(xOwner, xHorn, xColor);
        Node newNode = new Node(newCala);
        if (root == null) {
            root = newNode;
            return;
        }
        Node parent = null, current = root;
        while (current != null) {
            parent = current;
            if (xOwner.compareTo(current.info.owner) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (xOwner.compareTo(parent.info.owner) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        Queue queue = new Queue();
    if (root != null) {
        queue.enqueue(root);
    }


    while (!queue.isEmpty()) {
        Node node = queue.dequeue();
        if (node.left != null) { 
            f.writeBytes("(" + node.info.owner + "," + node.info.horn + "," + node.info.color + ") ");
        }
        if (node.left != null) {
            queue.enqueue(node.left);
        }
        if (node.right != null) {
            queue.enqueue(node.right);
        }
    }

        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.
      if the Node q!=null, you can use the statement:
      f.writeBytes(p.info + "\r\n ");
      to write p.info to the file f3.txt 
         */
        Queue queue = new Queue();
        if (root != null) {
            queue.enqueue(root);
        }
        Node toDelete = null, parent = null;
        int count = 0;

        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            count++;
            if (count == 6) {
                toDelete = node;
                break;
            }
            if (node.left != null) {
                parent = node;
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                parent = node;
                queue.enqueue(node.right);
            }
        }

        if (parent != null) {
            f.writeBytes(parent.info + "\r\n");
        }

        if (toDelete != null && parent != null) {
            if (parent.left == toDelete) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        Node target = findThirdNodeWithRightChild(root);
        if (target != null && target.right != null) {
            Node temp = target.right;
            target.right = temp.left;
            temp.left = target;

            if (root == target) {
                root = temp;
            } else {
                replaceParentChildLink(root, target, temp);
            }
        }

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    private Node findThirdNodeWithRightChild(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        int count = 0;

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.right != null) {
                count++;
                if (count == 3) {
                    return current;
                }
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return null;
    }

    private void replaceParentChildLink(Node root, Node oldChild, Node newChild) {
        Node parent = null, current = root;
        while (current != null && current != oldChild) {
            parent = current;
            if (oldChild.info.owner.compareTo(current.info.owner) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (parent != null) {
            if (parent.left == oldChild) {
                parent.left = newChild;
            } else if (parent.right == oldChild) {
                parent.right = newChild;
            }
        }
    }
}