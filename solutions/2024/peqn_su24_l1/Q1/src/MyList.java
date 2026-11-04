/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xType, int xRate, int xWing) {
        //You should write here appropriate statements to complete this function.
        if (xType.charAt(0) == 'B') {
            return;
        }
        Bird bird = new Bird(xType, xRate, xWing);
        Node addBird = new Node(bird, null);
        if (head == null) {
            head = tail = addBird;
        }
        tail.next = addBird;
        tail = addBird;

    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Bird x, y;
        x = new Bird("X", 1, 2);
        y = new Bird("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node insertX = new Node(x, null);
        Node insertY = new Node(y, null);
        insertPosition(4, insertX);
        insertPosition(6, insertY);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void insertPosition(int k, Node insert) {
        Node curr = head;
        int count = 1;
        Node pre = null;
        while (curr != null && count != k) {
            count++;
            pre = curr;
            curr = curr.next;
        }
        insert.next = pre.next;
        pre.next = insert;
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        findSecondNode();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
void findSecondNode(){
    Node second = null;
    int count = 0;
    Node p = head;
    while (p!=null) {        
        if(p.info.rate<6){
            count++;
            if(count ==2){
                p.info.wing = 99;
            }
        }
        p=p.next;
    }
    
}
//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
sort();

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public void sort() {
        Node pi, pj;
        Bird x;
        pi = head;
        Node max = findNodemax();
        while (pi != null && pi.next!= max) {
            pj = pi.next;
            while (pj != null&& pj!= max) {
                if (pj.info.rate < pi.info.rate) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    Node findNodemax() {
        
        Node p = head;
        Node max = head;
        while (p != null) {
            if (p.info.rate > max.info.rate) {
                max = p;
            }
            p = p.next;
        }
        Node p1 = head;
        while (p1 != null) {
            if (p1.info.rate == max.info.rate) {
                max = p1;
                break;
            }
            p1 = p1.next;
        }
        return max;
    }

}