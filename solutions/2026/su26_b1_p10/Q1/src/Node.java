class Node {
  Carp info;
  Node next;
  Node() {
   }
  Node(Carp x, Node p) {
    info=x;next=p;
   }
  Node(Carp x) {
    this(x,null);
   }
 }