class Node {
  Bike info;
  Node next;
  Node() {
   }
  Node(Bike x, Node p) {
    info=x;next=p;
   }
  Node(Bike x) {
    this(x,null);
   }
 }
