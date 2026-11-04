class Node {
  Brick info;
  Node next;
  Node() {
   }
  Node(Brick x, Node p) {
    info=x;next=p;
   }
  Node(Brick x) {
    this(x,null);
   }
 }