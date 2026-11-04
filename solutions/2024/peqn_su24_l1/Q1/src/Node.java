class Node {
  Bird info;
  Node next;
  Node() {
   }
  Node(Bird x, Node p) {
    info=x;next=p;
   }
  Node(Bird x) {
    this(x,null);
   }
 }
