class Node{
    private Apartment info;
    Node next;
    Node () {}
    Node (Apartment x, Node p) {
        this.info = x;
        this.next = p;
    }
    Node (Apartment x) {
        this(x,null);
    }
    public Apartment getInfo() {
        return this.info;
    }
    public void setInfo(Apartment info) {
        this.info = info;
    }
 }