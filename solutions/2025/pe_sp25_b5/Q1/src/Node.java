class Node {
  Box info;
  Node next;
  Node() {
   }
  Node(Box x, Node p) {
    info=x;next=p;
   }
  Node(Box x) {
    this(x,null);
   }
 }