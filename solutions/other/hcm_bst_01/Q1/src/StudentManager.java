class StudentBST {
    TreeNode root;
    StudentBST() {
        root = null;
    }
    boolean isEmpty() {
        return root == null;
    }
    void clear() {
        root = null;
    }
    TreeNode search(TreeNode p, String xId) {
        if (p == null) {
            return null;
        }
        if (p.info.getId().equals(xId)) {
            return p;
        }
        if (xId.compareTo(p.info.getId()) < 0) {
            return search(p.left, xId);
        } else {
            return search(p.right, xId);
        }
    }
    void insert(String id, String name, double gpa, String major, double balance) {
    }
    Student findHighestGPA() {
        return null;
    }
    int countByGPA(double threshold) {
        return 0;
    }
    int countByMajor(String major) {
        return countByMajor(root, major);
    }
    private int countByMajor(TreeNode p, String major) {
        if (p == null) return 0;
        int count = 0;
        if (p.info.getMajor().equals(major))
            count = 1;
        return count + countByMajor(p.left, major) + countByMajor(p.right, major);
    }
    boolean updateStudentBalance(String id, double amount) {
        return false;
    }
    void loadDataStudents(int k) {
        try {
            String[] ids = Lib.readLineToStrArray("data.txt", k);
            String[] names = Lib.readLineToStrArray("data.txt", k + 1);
            double[] gpas = Lib.readLineToDoubleArray("data.txt", k + 2);
            String[] majors = Lib.readLineToStrArray("data.txt", k + 3);
            double[] balances = Lib.readLineToDoubleArray("data.txt", k + 4);
            int n = Math.min(ids.length, Math.min(names.length, Math.min(gpas.length,
                    Math.min(majors.length, balances.length))));
            for (int i = 0; i < n; i++) {
                insert(ids[i], names[i], gpas[i], majors[i], balances[i]);
            }
        } catch (Exception e) {
            System.out.println("Error loading student data: " + e);
        }
    }
}
class ScholarshipList {
    ListNode head, tail;
    ScholarshipList() {
        head = tail = null;
    }
    boolean isEmpty() {
        return head == null;
    }
    void clear() {
        head = tail = null;
    }
    void addLast(String id, String name, double gpa, String major, double scholarshipAmount) {
    }
    ListNode search(String xId) {
        ListNode p = head;
        while (p != null) {
            if (p.info.getId().equals(xId)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
    ListNode removeById(String id) {
        return null;
    }
    void loadInitialScholarship(int k) {
        try {
            String[] ids = Lib.readLineToStrArray("data.txt", k + 5);
            String[] names = Lib.readLineToStrArray("data.txt", k + 6);
            double[] gpas = Lib.readLineToDoubleArray("data.txt", k + 7);
            String[] majors = Lib.readLineToStrArray("data.txt", k + 8);
            double[] amounts = Lib.readLineToDoubleArray("data.txt", k + 9);
            int n = Math.min(ids.length, Math.min(names.length,
                    Math.min(gpas.length, Math.min(majors.length, amounts.length))));
            for (int i = 0; i < n; i++) {
                addLast(ids[i], names[i], gpas[i], majors[i], amounts[i]);
            }
        } catch (Exception e) {
            System.out.println("Error loading initial scholarship data: " + e);
        }
    }
}
class StudentManager {
    StudentBST studentBST = new StudentBST();
    ScholarshipList scholarshipList = new ScholarshipList();
    StudentManager() {
    }
    void fvisit(TreeNode p, java.io.RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }
    void preOrder(TreeNode p, java.io.RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }
    void inOrder(TreeNode p, java.io.RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }
    void ftraverse(java.io.RandomAccessFile f) throws Exception {
        f.writeBytes("Student BST (Inorder Traversal):\r\n");
        inOrder(studentBST.root, f);
        f.writeBytes("\r\n");
        f.writeBytes("Scholarship List:\r\n");
        ListNode p = scholarshipList.head;
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            f.writeBytes(p.info + " ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }
    void load(int k) throws Exception {
        studentBST.loadDataStudents(k);
        scholarshipList.loadInitialScholarship(k);
    }
    void f1() throws Exception {
        load(0);
        String fname = "f1.txt";
        java.io.File g123 = new java.io.File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        java.io.RandomAccessFile f = new java.io.RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }
    void f2() throws Exception {
        load(0);
        String fname = "f2.txt";
        java.io.File g123 = new java.io.File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        java.io.RandomAccessFile f = new java.io.RandomAccessFile(fname, "rw");
        ftraverse(f);
        Student highestGPA = studentBST.findHighestGPA();
        f.writeBytes("\r\nStudent with highest GPA: " + highestGPA + "\r\n");
        f.close();
    }
    void f3() throws Exception {
        load(0);
        String fname = "f3.txt";
        java.io.File g123 = new java.io.File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        java.io.RandomAccessFile f = new java.io.RandomAccessFile(fname, "rw");
        f.close();
    }
    void f4() throws Exception {
        load(0);
        String fname = "f4.txt";
        java.io.File g123 = new java.io.File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        java.io.RandomAccessFile f = new java.io.RandomAccessFile(fname, "rw");
        ftraverse(f);
        ftraverse(f);
        f.close();
    }
}