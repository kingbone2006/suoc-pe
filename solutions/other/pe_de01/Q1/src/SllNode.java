public class SllNode {
    Student info;
    SllNode next;
    SllNode(Student x, SllNode p) {info = x; next = p;}
    SllNode(Student x) {this(x, null);}
}