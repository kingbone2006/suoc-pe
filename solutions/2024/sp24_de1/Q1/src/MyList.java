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
    void addLast(String xPlace, int xWeight, int xColor) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Bike info = new Bike(xPlace, xWeight, xColor);
        if (xWeight < 0) {
            return;
        }
        if (isEmpty()) {
            head = tail = new Node(info);
        } else {
            Node node = new Node(info);
            tail.next = node;
            tail = node;
        }

        //---------------------------------------------------------
    }
    //==================================================================
    //You do not need to edit this function. Your task is to complete 
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
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        delFirst();
        delFirst();
        delFirst();

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void delFirst() {
        head = head.next;
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
        moveNodeToEnd(head);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public static void moveNodeToEnd(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            System.out.println("Không đủ node để di chuyển!");
            return;
        }

        Node prev = head;
        Node current = head.next;

        for (int i = 1; i < 2; i++) {
            prev = current;
            current = current.next;
        }

        prev.next = current.next;

        Node temp = current;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = current;
        current.next = null;
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
        int num = countNodesGreaterThan(0);
        System.out.println(num);
        //------------------------------------------------------------------------------------
        f.close();
        
    }
public int countNodesGreaterThan(int value) {
    int count = 0;
    Node current = head;
    while (current != null) {
        if (current.info.color > value) {
            count++;
        }
        current = current.next;
    }
    return count;
}
//==================================================================
    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
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
        delFirst();
        sort();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
public void deleteFirstNode() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    void sort() {
        if (isEmpty()) return;
        Node pi = head, pj;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.weight < pj.info.weight) {
                    Bike temp = pi.info;
                    pi.info = pj.info;
                    pj.info= temp;
                }

                pj = pj.next;
            }

            pi = pi.next;
        }
    }
    

}