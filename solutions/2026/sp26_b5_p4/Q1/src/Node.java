class Node {
  Drum info;
  Node next;
  Node() {
   }
  Node(Drum x, Node p) {
    info=x;next=p;
   }
  Node(Drum x) {
    this(x,null);
   }
 }