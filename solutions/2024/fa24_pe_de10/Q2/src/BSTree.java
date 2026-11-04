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
   void clear() {
       root=null;
      }
   void visit(Node p) {
      System.out.print("p.info: ");
      if(p != null) System.out.println(p.info + " ");
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

   void loadData(int k) { //do not edit this function
      String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int [] c = Lib.readLineToIntArray("data.txt", k+2);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i],c[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void insert(String xOwner, int xHorn, int xColor) {
    //You should insert here statements to complete this function
    if(xOwner.charAt(0) == 'B') return;
    
    Node node = new Node(new Cala(xOwner, xHorn, xColor));
    
    if(root == null) {
        root = node;
        return;
    }
    
    Node p = root;
    Node parent = null;
    
    while(p != null) {
        parent = p;
        if(xHorn < p.info.horn) {
            p = p.left;
        } else if(xHorn > p.info.horn) {
            p = p.right;
        } else {
            return;
        }
    }
    
    if(xHorn < parent.info.horn) {
        parent.left = node;
    } else {
        parent.right = node;
    }
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
  
//=============================================================
 void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    
    breadth2(root,f);
    
    f.writeBytes("\r\n");
    f.close();
   }  

void breadth2(Node p, RandomAccessFile f) throws Exception {
    if(p == null) return;
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    while(!q.isEmpty()) {
        r = q.dequeue();
        if(r.right != null) {
            fvisit(r,f);
        }
        if(r.left != null) q.enqueue(r.left);
        if(r.right != null) q.enqueue(r.right);
    }
}

//=============================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    
    Node p = null, fa = null;
    Queue q = new Queue();
    q.enqueue(root);
    int count = 0;
    
    while(!q.isEmpty()) {
        Node r = q.dequeue();
        count++;
        
        if(count == 7) {
            p = r;
            break;
        }
        
        if(r.left != null) {
            q.enqueue(r.left);
        }
        if(r.right != null) {
            q.enqueue(r.right);
        }
    }
    
    if(p != null) {
        fa = getParent(root, p);
    }
    
    if(fa != null) {
        f.writeBytes(fa.info + "\r\n");
    }
    
    if(p != null) {
        deleteByCopy(p);
    }
    
    breadth(root,f);
    f.writeBytes("\r\n");
    f.close();
}

void deleteByCopy(Node p) {
    if(p == null) return;
    Node f = null, q = root;
    while(q != null) {
        if(q.info.horn == p.info.horn) break;
        f = q;
        if(p.info.horn < q.info.horn) q = q.left;
        else q = q.right;
    }
    if(q.left == null && q.right == null) {
        if(f == null) root = null;
        else if(f.left == q) f.left = null;
        else f.right = null;
    }
    else if(q.left == null) {
        if(f == null) root = q.right;
        else if(f.left == q) f.left = q.right;
        else f.right = q.right;
    }
    else if(q.right == null) {
        if(f == null) root = q.left;
        else if(f.left == q) f.left = q.left;
        else f.right = q.left;
    }
    else {
        Node rp = q.right;
        Node frp = q;
        while(rp.left != null) {
            frp = rp;
            rp = rp.left;
        }
        q.info = rp.info;
        if(frp == q) frp.right = rp.right;
        else frp.left = rp.right;
    }
}

//=============================================================
 void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    
    Node p = findNode();
    
    rotateRight(p);
    
    breadth(root,f);
    f.writeBytes("\r\n");
    f.close();
}

Node findNode() {
    int count = 0;
    return preOrderFind(root, count);
}

Node preOrderFind(Node p, int count) {
    if(p == null) return null;
    if(p.left != null) count++;
    if(count == 2) return p;
    Node leftResult = preOrderFind(p.left, count);
    if(leftResult != null) return leftResult;
    return preOrderFind(p.right, count);
}

void rotateRight(Node p) {
    if(p == null || p.left == null) return;
    Node parent = getParent(root, p);
    Node q = p.left;
    p.left = q.right;
    q.right = p;
    if(parent == null) root = q;
    else if(parent.left == p) parent.left = q;
    else parent.right = q;
}

Node getParent(Node root, Node p) {
    if(root == null || p == root) return null;
    if(root.left == p || root.right == p) return root;
    Node left = getParent(root.left, p);
    if(left != null) return left;
    return getParent(root.right, p);
}

 }