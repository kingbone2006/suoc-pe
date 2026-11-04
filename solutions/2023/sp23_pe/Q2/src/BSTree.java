/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;
public class BSTree {
  Node root;
  BSTree() {root=null;}
  boolean isEmpty() { return root==null; }
  void clear() {root=null;}
  void fvisit(Node p, RandomAccessFile f) throws Exception { if(p != null) f.writeBytes(p.info + " "); }
  void breadth(Node p, RandomAccessFile f) throws Exception {
    if(p==null) return;
    Queue q = new Queue(); q.enqueue(p); Node r;
    while(!q.isEmpty()) {
      r = q.dequeue(); fvisit(r,f);
      if(r.left!=null) q.enqueue(r.left);
      if(r.right!=null) q.enqueue(r.right);
    }
  }
  void preOrder(Node p, RandomAccessFile f) throws Exception {
    if(p==null) return;
    fvisit(p,f); preOrder(p.left,f); preOrder(p.right,f);
  }
  void inOrder(Node p, RandomAccessFile f) throws Exception {
    if(p==null) return;
    inOrder(p.left,f); fvisit(p,f); inOrder(p.right,f);
  }
  void postOrder(Node p, RandomAccessFile f) throws Exception {
    if(p==null) return;
    postOrder(p.left,f); postOrder(p.right,f); fvisit(p,f);
  }
  void loadData(int k) {
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    for(int i=0;i<a.length;i++) insert(a[i],b[i]);
  }
//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void insert(String xOwner, int xPrice) {
    //You should insert here statements to complete this function
    if(xOwner.charAt(0) == 'B' || xPrice > 100) return;
    Bike x = new Bike(xOwner, xPrice); Node q = new Node(x);
    if(isEmpty()) { root = q; return; }
    Node p = root, f = null;
    while(p != null) {
      if(p.info.price == xPrice) return;
      f = p;
      if(xPrice < p.info.price) p = p.left;
      else p = p.right;
    }
    if(xPrice < f.info.price) f.left = q;
    else f.right = q;
  }
//Do not edit this function. Your task is to complete insert function above only.
  void f1() throws Exception {
    clear(); loadData(1);
    String fname = "f1.txt"; File g123 = new File(fname); if(g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root,f); f.writeBytes("\r\n"); inOrder(root,f); f.writeBytes("\r\n"); f.close();
  }
  void preOrder2(Node p, RandomAccessFile f) throws Exception {
    if(p==null) return;
    if(p.info.price >= 3 && p.info.price <= 5) fvisit(p,f);
    preOrder2(p.left,f); preOrder2(p.right,f);
  }
  void f2() throws Exception {
    clear(); loadData(4);
    String fname = "f2.txt"; File g123 = new File(fname); if(g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    preOrder(root,f); f.writeBytes("\r\n"); preOrder2(root,f); f.writeBytes("\r\n"); f.close();
  }
  Node findNodeForF3F4() {
    if(root == null) return null;
    Queue q = new Queue(); q.enqueue(root);
    while(!q.isEmpty()) {
      Node r = q.dequeue();
      if(r.left != null && r.info.price < 7) return r;
      if(r.left != null) q.enqueue(r.left);
      if(r.right != null) q.enqueue(r.right);
    }
    return null;
  }
  void deleByCopy(Node p) {
    if(p == null || p.left == null) return;
    Node rightMost = p.left, pRightMost = p;
    while(rightMost.right != null) { pRightMost = rightMost; rightMost = rightMost.right; }
    p.info = rightMost.info;
    if(pRightMost == p) p.left = rightMost.left;
    else pRightMost.right = rightMost.left;
  }
  Node getParent(Node child) {
    if(root == null || child == null || root == child) return null;
    Node p = root, parent = null;
    while(p != null) {
      if(p == child) return parent;
      parent = p;
      if(child.info.price < p.info.price) p = p.left;
      else p = p.right;
    }
    return null;
  }
  void rotateRight(Node p) {
    if(p == null || p.left == null) return;
    Node c = p.left; Node parent = getParent(p);
    p.left = c.right; c.right = p;
    if(parent == null) root = c;
    else if(parent.left == p) parent.left = c;
    else parent.right = c;
  }
  void f3() throws Exception {
    clear(); loadData(7);
    String fname = "f3.txt"; File g123 = new File(fname); if(g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root,f); f.writeBytes("\r\n");
    Node p = findNodeForF3F4(); deleByCopy(p);
    breadth(root,f); f.writeBytes("\r\n"); f.close();
  }
  void f4() throws Exception {
    clear(); loadData(10);
    String fname = "f4.txt"; File g123 = new File(fname); if(g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root,f); f.writeBytes("\r\n");
    Node p = findNodeForF3F4(); rotateRight(p);
    breadth(root,f); f.writeBytes("\r\n"); f.close();
  }
}