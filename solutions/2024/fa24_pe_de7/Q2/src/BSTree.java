
/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Stack;

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
    if (p != null)
      System.out.println(p.info + " ");
  }

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if (p != null)
      f.writeBytes(p.info + " ");
  }

  void breadth(Node p, RandomAccessFile f) throws Exception {
    if (p == null)
      return;
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    while (!q.isEmpty()) {
      r = q.dequeue();
      fvisit(r, f);
      if (r.left != null)
        q.enqueue(r.left);
      if (r.right != null)
        q.enqueue(r.right);
    }
  }

  void preOrder(Node p, RandomAccessFile f) throws Exception {
    if (p == null)
      return;
    fvisit(p, f);
    preOrder(p.left, f);
    preOrder(p.right, f);
  }

  void inOrder(Node p, RandomAccessFile f) throws Exception {
    if (p == null)
      return;
    inOrder(p.left, f);
    fvisit(p, f);
    inOrder(p.right, f);
  }

  void postOrder(Node p, RandomAccessFile f) throws Exception {
    if (p == null)
      return;
    postOrder(p.left, f);
    postOrder(p.right, f);
    fvisit(p, f);
  }

  void loadData(int k) { // do not edit this function
    String[] a = Lib.readLineToStrArray("data.txt", k);
    int[] b = Lib.readLineToIntArray("data.txt", k + 1);
    int[] c = Lib.readLineToIntArray("data.txt", k + 2);
    int n = a.length;
    for (int i = 0; i < n; i++)
      insert(a[i], b[i], c[i]);
  }

  // (2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void insert(String xOwner, int xHorn, int xColor) {
    //You should insert here statements to complete this function
    if (xOwner.charAt(0) == 'A')
      return;
    Node node = new Node(new Cala(xOwner, xHorn, xColor));
    if (root == null) {
      root = node;
      return;
    }
    Node curr = root;
    Node parent = null;
    while (curr != null) {
      parent = curr;
      if (xColor < curr.info.color) {
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }
    if (xColor < parent.info.color) {
      parent.left = node;
    } else {
      parent.right = node;
    }
  }

  // Do not edit this function. Your task is to complete insert function above
//Do not edit this function. Your task is to complete insert function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if (g123.exists())
      g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root, f);
    f.writeBytes("\r\n");
    inOrder(root, f);
    f.writeBytes("\r\n");
    f.close();
  }

  void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if (g123.exists())
      g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root, f);
    f.writeBytes("\r\n");
    /*
     * You must keep statements pre-given in this function.
     * Your task is to insert statements here, just after this comment,
     * to complete the question in the exam paper.
     */

    Queue q = new Queue();
    q.enqueue(root);
    Node r;
    while (!q.isEmpty()) {
      r = q.dequeue();
      if (r.left != null) {
        fvisit(r, f);
      }
      if (r.left != null)
        q.enqueue(r.left);
      if (r.right != null)
        q.enqueue(r.right);
    }

    f.writeBytes("\r\n");
    f.close();
  }

  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if (g123.exists())
      g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root, f);
    f.writeBytes("\r\n");
    /*
     * You must keep statements pre-given in this function.
     * Your task is to insert statements here, just after this comment,
     * to complete the question in the exam paper.
     * if the Node q!=null, you can use the statement:
     * f.writeBytes(p.info + "\r\n ");
     * to write p.info to the file f3.txt
     */
    Queue q = new Queue();
    q.enqueue(root);
    Node p = null;
    Node fa = null;
    int count = 0;

    while (!q.isEmpty()) {
      Node r = q.dequeue();
      count++;
      if (count == 6) {
        p = r;
        break;
      }
      if (r.left != null) {
        q.enqueue(r.left);
        if (count == 5 && r.left == p)
          fa = r;
      }
      if (r.right != null) {
        q.enqueue(r.right);
        if (count == 5 && r.right == p)
          fa = r;
      }
    }

    if (fa != null) {
      f.writeBytes(fa.info + "\r\n");
    }

    if (fa != null) {
      if (fa.left == p) {
        if (p.left != null)
          fa.left = p.left;
        else
          fa.left = p.right;
      } else if (fa.right == p) {
        if (p.left != null)
          fa.right = p.left;
        else
          fa.right = p.right;
      }
    }

    breadth(root, f);
    f.writeBytes("\r\n");
    f.close();
  }

  void f4() throws Exception {
    clear();
    loadData(13);
    ;
    String fname = "f4.txt";
    File g123 = new File(fname);
    if (g123.exists())
      g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root, f);
    f.writeBytes("\r\n");
    /*
     * You must keep statements pre-given in this function.
     * Your task is to insert statements here, just after this comment,
     * to complete the question in the exam paper.
     */

    Node p = findThirdNodeHavingRightChild(root);
    if (p != null)
      rotateLeft(p);

    breadth(root, f);
    f.writeBytes("\r\n");
    f.close();
  }

  Node findThirdNodeHavingRightChild(Node root) {
    if (root == null)
      return null;
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    int count = 0;

    while (!stack.isEmpty()) {
      Node node = stack.pop();
      if (node.right != null) {
        count++;
        if (count == 3)
          return node;
      }

      if (node.right != null)
        stack.push(node.right);
      if (node.left != null)
        stack.push(node.left);
    }
    return null;
  }

  void rotateLeft(Node p) {
    if (p == null || p.right == null)
      return;
    Node parent = getParent(root, p);
    Node q = p.right;
    p.right = q.left;
    q.left = p;

    if (parent == null) {
      root = q;
    } else {
      if (parent.left == p)
        parent.left = q;
      else
        parent.right = q;
    }
  }

  Node getParent(Node root, Node node) {
    if (root == null || root == node)
      return null;
    if (root.left == node || root.right == node)
      return root;

    Node left = getParent(root.left, node);
    if (left != null)
      return left;
    return getParent(root.right, node);
  }

}