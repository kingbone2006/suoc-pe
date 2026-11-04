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
  void addLast(String xOwner, int xHorn, int xColor) {
    //You should write here appropriate statements to complete this function.
    if(xOwner.charAt(0) == 'A') {
        return;
    }
    
    Cala cala = new Cala(xOwner, xHorn, xColor);
    Node node = new Node(cala);
    
    if(isEmpty()) {
        head = tail = node;
        return;
    }
    
    tail.next = node;
    tail = node;
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
     Cala x, y, z;
     x = new Cala("X",1,2);
     y = new Cala("Y",2,3);
     z = new Cala("Z",3,4);
     //------------------------------------------------------------------------------------
     Node p = head;
     Node nx = new Node(x, p.next);
     p.next = nx;
     
     p = head;
     for(int i = 0; i < 3; i++) {
         p = p.next;
     }
     Node ny = new Node(y, p.next);
     p.next = ny;
     
     p = head;
     for(int i = 0; i < 5; i++) {
         p = p.next;
     }
     Node nz = new Node(z, p.next);
     p.next = nz;
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
    Node p = head;
    Node maxNode = head;
    int maxColor = head.info.color;
    
    while(p != null) {
        if(p.info.color > maxColor) {
            maxColor = p.info.color;
            maxNode = p;
        }
        p = p.next;
    }
    
    if(maxNode != tail) {
        Cala temp = maxNode.info;
        maxNode.info = tail.info;
        tail.info = temp;
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
    Node p = head;
    while(p != null && !p.info.owner.equals("D")) {
        p = p.next;
    }
    
    if(p != null) {
        Node[] arr = new Node[6];
        Node current = p.next;
        for(int i = 0; i < 6 && current != null; i++) {
            arr[i] = current;
            current = current.next;
        }
        
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5-i; j++) {
                if(arr[j].info.color > arr[j+1].info.color) {
                    Cala temp = arr[j].info;
                    arr[j].info = arr[j+1].info;
                    arr[j+1].info = temp;
                }
            }
        }
    }
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }
