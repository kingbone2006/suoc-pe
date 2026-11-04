class Node {
  Bottle info;
  Node next;
  Node() {
   }
  Node(Bottle x, Node p) {
    info=x;next=p;
   }
  Node(Bottle x) {
    this(x,null);
   }
 }
