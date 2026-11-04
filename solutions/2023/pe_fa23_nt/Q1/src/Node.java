class Node {
  Lion info;
  Node next;
  Node() {
   }
  Node(Lion x, Node p) {
    info=x;next=p;
   }
  Node(Lion x) {
    this(x,null);
   }
 }