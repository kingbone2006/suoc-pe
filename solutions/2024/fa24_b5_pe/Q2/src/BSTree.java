/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;
public class BSTree {
  Node root;
  BSTree() {root=null;}
  boolean isEmpty() {
    return(root==null);
  }
  void clear() {root=null;}
  void visit(Node p) {
    System.out.print(p.info + " ");
  }
  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
  }
  void breadth(Node p, RandomAccessFile f) throws Exception {
    if(p==null) return;
    Queue q = new Queue();
    q.enqueue(p);Node r;
    while(!q.isEmpty()) {
      r = q.dequeue();
      fvisit(r,f);
      if(r.left!=null) q.enqueue(r.left);
      if(r.right!=null) q.enqueue(r.right);
    }
  }
  void preOrder(Node p, RandomAccessFile f) throws Exception {
    if(p==null) return;
    fvisit(p,f);
    preOrder(p.left,f);
    preOrder(p.right,f);
  }
  void inOrder(Node p, RandomAccessFile f) throws Exception {
    if(p==null) return;
    inOrder(p.left,f);
    fvisit(p,f);
    inOrder(p.right,f);
  }
  void postOrder(Node p, RandomAccessFile f) throws Exception {
    if(p==null) return;
    postOrder(p.left,f);
    postOrder(p.right,f);
    fvisit(p,f);
  }
  void loadData(int k) {
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) insert(a[i],b[i],c[i]);
  }
//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void insert(String xPlace, int xDepth, int xType) {
    //You should insert here statements to complete this function
    if(xPlace.charAt(0) == 'B') return;
    Beaver x = new Beaver(xPlace, xDepth, xType);
    Node q = new Node(x);
    if(isEmpty()) {
      root = q;
      return;
    }
    Node p = root, f = null;
    while(p != null) {
      if(p.info.depth == xDepth) return;
      f = p;
      if(xDepth < p.info.depth) p = p.left;
      else p = p.right;
    }
    if(xDepth < f.info.depth) f.left = q;
    else f.right = q;
  }
//Do not edit this function. Your task is to complete insert function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw");
    breadth(root,f);
    f.writeBytes("\r\n");
    inOrder(root,f);
    f.writeBytes("\r\n");
    f.close();
  }
  void postOrder2(Node p, RandomAccessFile f) throws Exception {
    if(p==null) return;
    postOrder2(p.left,f);
    postOrder2(p.right,f);
    if(p.info.type < 7) fvisit(p,f);
  }
  void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw");
    postOrder(root,f);
    f.writeBytes("\r\n");
    postOrder2(root,f);
    f.writeBytes("\r\n");
    f.close();
  }
  Node findSecondNodeWithLeftSon() {
    if(root == null) return null;
    Queue q = new Queue();
    q.enqueue(root);
    int count = 0;
    while(!q.isEmpty()) {
      Node r = q.dequeue();
      if(r.left != null) {
        count++;
        if(count == 2) return r;
      }
      if(r.left != null) q.enqueue(r.left);
      if(r.right != null) q.enqueue(r.right);
    }
    return null;
  }
  Node getParent(Node child) {
    if(root == null || child == null || root == child) return null;
    Node p = root, parent = null;
    while(p != null) {
      if(p == child) return parent;
      parent = p;
      if(child.info.depth < p.info.depth) p = p.left;
      else p = p.right;
    }
    return null;
  }
  void deleteLargestInSubtree(Node p) {
    if(p == null) return;
    Node maxNode = p;
    Node parent = getParent(p);
    Node pMax = parent;
    while(maxNode.right != null) {
      pMax = maxNode;
      maxNode = maxNode.right;
    }
    if(maxNode == p) {
      if(parent == null) {
        root = p.left;
      } else if(parent.left == p) {
        parent.left = p.left;
      } else {
        parent.right = p.left;
      }
    } else {
      pMax.right = maxNode.left;
    }
  }
  void rotateRight(Node p) {
    if(p == null || p.left == null) return;
    Node c = p.left;
    Node parent = getParent(p);
    p.left = c.right;
    c.right = p;
    if(parent == null) {
      root = c;
    } else if(parent.left == p) {
      parent.left = c;
    } else {
      parent.right = c;
    }
  }
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw");
    breadth(root,f);
    f.writeBytes("\r\n");
    Node p = findSecondNodeWithLeftSon();
    deleteLargestInSubtree(p);
    breadth(root,f);
    f.writeBytes("\r\n");
    f.close();
  }
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw");
    breadth(root,f);
    f.writeBytes("\r\n");
    Node p = findSecondNodeWithLeftSon();
    rotateRight(p);
    breadth(root,f);
    f.writeBytes("\r\n");
    f.close();
  }
}