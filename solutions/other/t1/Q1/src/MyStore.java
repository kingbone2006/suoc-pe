import java.util.*;
import java.io.*;
class dataList {
    Node head, tail;
    dataList() {
        head = tail = null;
    }
    boolean isEmpty() {
        return (head == null);
    }
    void clear() {
        head = tail = null;
    }
    void loadDataRoom(int k)
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int[] d = Lib.readLineToIntArray("data.txt", k + 3);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i], d[i]);
        }
    }
    void addLast(String code, int status, int size, int price) {
    }
}
class requestQueue {
    Node front, rear;
    requestQueue() {
        front = rear = null;
    }
    boolean isEmpty() {
        return (front == null);
    }
    void clear() {
        front = rear = null;
    }
    void loadDataRequest(int k)
    {
        int[] a = Lib.readLineToIntArray("data.txt", k + 4);
        int[] b = Lib.readLineToIntArray("data.txt", k + 5);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            enQueue(a[i], b[i]);
        }
    }
    void enQueue(int size, int price) {
    }
    Room deQueue() {
        Room tmp = new Room();
        return tmp;
    }
}
class MyStore {
    dataList dList = new dataList();
    requestQueue RQueue = new requestQueue();
    MyStore() {
    }
    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }
    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = dList.head;
        f.writeBytes("Data List: ");
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            fvisit(p, f);
            p = p.next;
        }
        f.writeBytes("\r\n");
        f.writeBytes("Request  : ");
        p = RQueue.front;
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            f.writeBytes("(" + p.info.getSize() + "," + p.info.getPrice() + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }
    void load(int k) throws Exception
    {
        dList.loadDataRoom(k);
        RQueue.loadDataRequest(k);
    }
    void f1() throws Exception {
        load(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }
    void rent(Room t) throws Exception {
    }
    void f2() throws Exception {
        load(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        ftraverse(f);
        f.close();
    }
    void f3() throws Exception {
        load(1);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        ftraverse(f);
        f.close();
    }
    void f4() throws Exception {
        load(1);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        int count =0;
        ftraverse(f);
        f.writeBytes("Available Room(s): " + count + " ");
        f.close();
    }
}