class Node {
  Pen info;
  Node next;
  Node() {
   }
  Node(Pen x, Node p) {
    info=x;next=p;
   }
  Node(Pen x) {
    this(x,null);
   }
 }