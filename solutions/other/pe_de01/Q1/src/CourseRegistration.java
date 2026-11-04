import java.io.*;
class SllStudent {
    SllNode head, tail;
    SllStudent() { head = tail = null; }
    boolean isEmpty() { return (head == null); }
    void clear() { head = tail = null; }
    void loadDataRegistration(int k) {
        int[] a = Lib.readLineToIntArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        boolean[] c = Lib.readLineToBooleanArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addStudent(a[i], b[i], c[i]);
        }
    }
    void addStudent(int xID, String xName, boolean xFee) {
        SllNode newNode = new SllNode(new Student(xID,xName,xFee));
    }
    void printInsertionOrder(RandomAccessFile f) throws Exception {
    }
    void display(RandomAccessFile f) throws Exception {
        SllNode p = head;
        while (p != null) {
            f.writeBytes("(" + p.info.getId() + ","
                        + p.info.getName() + "," + p.info.isFee() + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
        f.close();
    }
}
class BstStudent {
    BstNode root;
    BstStudent() { root = null; }
    boolean isEmpty() { return (root == null); }
    void clear() { root = null; }
    void fvisit(BstNode p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }
    void inOrder(BstNode p, RandomAccessFile f) throws Exception {
        if (p == null) { return; }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }
    void printPaidDesc(BstNode p, RandomAccessFile f) throws Exception {
    }
    void loadDataRegistration(int k)
    {
        int[] a = Lib.readLineToIntArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        boolean[] c = Lib.readLineToBooleanArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }
    BstNode insertStudent(BstNode root, Student std) {
        return root;
    }
    void insert(int xID, String xName, boolean xFee) {
        this.root = insertStudent(this.root, new Student(xID,xName,xFee));
    }
    int count(BstNode node) {
        return 0;
    }
    public BstNode searchById(BstNode node, int id) {
        return null;
    }
    public BstNode search(int id) {
        return null;
    }
}
public class CourseRegistration {
    SllStudent sList = new SllStudent();
    BstStudent bList = new BstStudent();
    CourseRegistration() { }
    void load(int k) throws Exception {
        sList.loadDataRegistration(k);
        bList.loadDataRegistration(k);
    }
    void f1() throws Exception {
        load(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        sList.printInsertionOrder(f);
    }
    void f2() throws Exception {
        load(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        int i = 0;
        i = bList.count(bList.root);
        String c = "" + i;
        f.writeBytes(c.trim());
        f.close();
    }
    void f3(int search_id) throws Exception {
        load(1);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        BstNode p = bList.search(search_id);
        if (p != null) {
            f.writeBytes("(" + p.info.getId() + ","
                        + p.info.getName() + "," + p.info.isFee() + ") ");
            f.writeBytes("\r\n");
            f.close();
        } else {
            f.writeBytes("Not found");
            f.writeBytes("\r\n");
            f.close();
        }
    }
    void f4() throws Exception {
        load(1);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        bList.inOrder(bList.root, f);
        f.writeBytes("\r\n");
        bList.printPaidDesc(bList.root, f);
        f.close();
    }
}