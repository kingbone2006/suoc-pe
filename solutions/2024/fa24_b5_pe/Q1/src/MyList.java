/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() {
    return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) {
       fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k) { //do not edit this function
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(String xOwner, int xPrice, int xColor) {
    //You should write here appropriate statements to complete this function.
    if(xOwner.charAt(0) == 'A') return;
    Pen x = new Pen(xOwner, xPrice, xColor);
    Node q = new Node(x);
    if(isEmpty()) {
      head = tail = q;
    } else {
      tail.next = q;
      tail = q;
    }
   }

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw");
     ftraverse(f);
     f.close();
    }

//==================================================================
  void f2() throws Exception {
     clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw");
     ftraverse(f);
     Pen x, y;
     x = new Pen("X",1,2);
     y = new Pen("Y",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     Node ny = new Node(y);
     Node nx = new Node(x);
     ny.next = nx;
     nx.next = head;
     head = ny;
    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }

//==================================================================
  void f3() throws Exception {
     clear();
     loadData(9);
     String fname = "f3.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw");
     ftraverse(f);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     Node p = head, prev = null;
     while(p != null) {
       if(p.info.color < 6) {
         if(prev == null) {
           head = head.next;
           if(head == null) tail = null;
         } else {
           prev.next = p.next;
           if(p == tail) tail = prev;
         }
         break;
       }
       prev = p;
       p = p.next;
     }
    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }

//==================================================================
  void f4() throws Exception {
     clear();
     loadData(13);
     String fname = "f4.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw");
     ftraverse(f);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     int count = 0;
     Node p = head;
     while(p != null && count < 5) {
       Node q = p.next;
       int inner = count + 1;
       while(q != null && inner < 5) {
         if(p.info.color > q.info.color) {
           Pen tmp = p.info;
           p.info = q.info;
           q.info = tmp;
         }
         q = q.next;
         inner++;
       }
       p = p.next;
       count++;
     }
    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }

}
