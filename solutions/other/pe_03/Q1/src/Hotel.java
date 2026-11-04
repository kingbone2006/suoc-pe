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
        if (size <= 0 || price <= 0) {
            return;
        }
        Room newRoom = new Room(code, status, size, price);
        Node newNode = new Node(newRoom);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
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
        if (size <= 0 || price <= 0) {
            return;
        }
        Room room = new Room(size, price);
        Node newNode = new Node(room);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }
    Room deQueue() {
        Room tmp = new Room();
        if (isEmpty()) {
            return null;
        }
        tmp = front.info;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return tmp;
    }
}
class Hotel {
    dataList dList = new dataList();
    requestQueue RQueue = new requestQueue();
    Hotel() {
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
        Node bestRoomNode = null;
        int bestPrice = Integer.MAX_VALUE;
        Node current = dList.head;
        while (current != null) {
            Room room = current.info;
            if (room.getStatus() == 0 && room.getSize() > t.getSize() && room.getPrice() <= t.getPrice()) {
                if (room.getPrice() < bestPrice || (room.getPrice() == bestPrice && current != null)) {
                    bestRoomNode = current;
                    bestPrice = room.getPrice();
                }
            }
            current = current.next;
        }
        if (bestRoomNode != null) {
            bestRoomNode.info.setStatus(1);
        }
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
        Room request = RQueue.deQueue();
        if (request != null) {
            rent(request);
        }
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
        Room request;
        while ((request = RQueue.deQueue()) != null) {
            rent(request);
        }
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
        int result = 0;
        Room request;
        while ((request = RQueue.deQueue()) != null) {
            rent(request);
        }
        Node current = dList.head;
        while (current != null) {
            Room room = current.info;
            if (room.getStatus() == 1) {
                result += room.getPrice();
            }
            current = current.next;
        }
        ftraverse(f);
        f.writeBytes("Total Revenue: " + result + " ");
        f.close();
    }
}