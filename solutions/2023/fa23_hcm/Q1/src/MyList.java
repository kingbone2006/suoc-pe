/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;
public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() { return head==null; }
  void clear() {head=tail=null;}
  void fvisit(Node p, RandomAccessFile f) throws Exception { if(p != null) f.writeBytes(p.info + " "); }
  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) { fvisit(p,f); p=p.next; }
    f.writeBytes("\r\n");
  }
  void loadData(int k) {
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    for(int i=0;i<a.length;i++) addLast(a[i],b[i]);
  }
//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(String xOwner, int xPrice) {
    //You should write here appropriate statements to complete this function.
    if(xOwner.charAt(0) == 'B' || xPrice > 100) return;
    Plane x = new Plane(xOwner, xPrice);
    Node q = new Node(x);
    if(isEmpty()) head = tail = q;
    else { tail.next = q; tail = q; }
  }
  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear(); loadData(1);
     String fname = "f1.txt"; File g123 = new File(fname); if(g123.exists()) g123.delete();
     RandomAccessFile f = new RandomAccessFile(fname, "rw"); ftraverse(f); f.close();
  }
  void f2() throws Exception {
     clear(); loadData(4);
     String fname = "f2.txt"; File g123 = new File(fname); if(g123.exists()) g123.delete();
     RandomAccessFile f = new RandomAccessFile(fname, "rw"); ftraverse(f);
     Plane x = new Plane("X", 1); Node q = new Node(x);
     q.next = head; head = q; if(tail == null) tail = q;
     ftraverse(f); f.close();
  }
  void f3() throws Exception {
     clear(); loadData(7);
     String fname = "f3.txt"; File g123 = new File(fname); if(g123.exists()) g123.delete();
     RandomAccessFile f = new RandomAccessFile(fname, "rw"); ftraverse(f);
     Node p = head, prev = null;
     while(p != null) {
       if(p.info.price == 5) {
         if(prev == null) { head = head.next; if(head == null) tail = null; }
         else { prev.next = p.next; if(p == tail) tail = prev; }
         break;
       }
       prev = p; p = p.next;
     }
     ftraverse(f); f.close();
  }
  void f4() throws Exception {
     clear(); loadData(10);
     String fname = "f4.txt"; File g123 = new File(fname); if(g123.exists()) g123.delete();
     RandomAccessFile f = new RandomAccessFile(fname, "rw"); ftraverse(f);
     for(Node p = head; p != null; p = p.next) {
       for(Node q = p.next; q != null; q = q.next) {
         if(p.info.price > q.info.price) {
           Plane tmp = p.info; p.info = q.info; q.info = tmp;
         }
       }
     }
     ftraverse(f); f.close();
  }
}