class Node {
  Cape info;
  Node next;
  Node() {
   }
  Node(Cape x, Node p) {
    info=x;next=p;
   }
  Node(Cape x) {
    this(x,null);
   }
 }