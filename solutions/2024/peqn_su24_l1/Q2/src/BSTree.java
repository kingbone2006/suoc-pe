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

  void insert(Bird x) {
    //You should insert here statements to complete this function
        Node q = new Node(x);
        if (root == null) {
            root = q;
            return;
        }
        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            if (p.info.wing == x.wing) {
                return;
            }
            if (x.wing < p.info.wing) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (x.wing < f.info.wing) {
            f.left = q;
        } else {
            f.right = q;
        }
    }

    void insert(String xType, int xRate, int xWing) {
    //You should insert here statements to complete this function
        if (xType.charAt(0) == 'B') {
            return;
        }
        Bird x = new Bird(xType, xRate, xWing);
        insert(x);
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
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    breadth1(root,f);


    //------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }  
   void breadth1(Node p, RandomAccessFile f) throws Exception {
     if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty()) {
        r = q.dequeue();
        if(r.info.rate > 4){
        fvisit(r,f);}
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }

//=============================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    postOrder(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

    

    //------------------------------------------------------------------------------------
    postOrder2(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  
	int count2 = 0;
        Node parent(Node x) {
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.wing == x.info.wing) {
                break;
            }
            parent = p;
            if (p.info.wing > x.info.wing) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return parent;
    }  
    


void postOrder2(Node p, RandomAccessFile f) throws Exception {
    if (p == null) return;
    postOrder2(p.left, f);
    postOrder2(p.right, f);

    count2++;
    if (count2 == 4) {
        Node nodeToDelete = parent(p);
        if (nodeToDelete != null) {
            deleByCopy(nodeToDelete);  
            postOrder(root, f);    
        }
    } 
}


void deleByCopy(Node p) {
    if (p == null) return;
    if (p.left == null && p.right == null) {
        deleteLeafNode(p);
    } else if (p.left == null || p.right == null) {
        deleteNodeWithOneChild(p);
    } else {
        Node rightmost = p.left;
        while (rightmost.right != null) {
            rightmost = rightmost.right;
        }
        p.info = rightmost.info;
        deleteLeafNode(rightmost);
    }
}

void deleteNodeWithOneChild(Node p) {
    if (p == null) return;
    Node child = (p.left != null) ? p.left : p.right;

    Node parent = parent(p);

    if (parent == null) {
        root = child; 
        return;
    }

    if (parent.left == p) {
        parent.left = child;
    } else {
        parent.right = child;
    }
}
void deleteLeafNode(Node p) {
    if (p == null) return;

    Node parent = parent(p);

    if (parent == null) {
        root = null;
        return;
    }

    if (parent.left == p) {
        parent.left = null;
    } else {
        parent.right = null;
    }
}

//=============================================================
  void f4() throws Exception {
    clear();
    loadData(13);;
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    postOrder(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    
         int count4 = 0;

    //------------------------------------------------------------------------------------
    postOrder4(root,f);
     count4 = 0;
    f.writeBytes("\r\n");
    f.close();
   }  
 int count4 = 0;
void postOrder4(Node p, RandomAccessFile f) throws Exception {
    if(p==null) return;
    postOrder4(p.left,f);
    postOrder4(p.right,f);
    if(++count4 == 4){
        p.info.rate = calculateHeight(p);
    }
    fvisit(p,f);   
}
     int calculateHeight(Node node) {
    if (node == null) {
        return 0;
    }
    int leftHeight = calculateHeight(node.left);
    int rightHeight = calculateHeight(node.right);
    return Math.max(leftHeight, rightHeight) +1;
}

 }