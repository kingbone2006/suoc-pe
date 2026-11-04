class Node{
    private Bird info;
    Node left,right;
    Node () {}
    Node (Bird x, Node leftChild, Node rightChild) {
        this.info = x;
        this.left = leftChild;
        this.right = rightChild;
    }
    Node (Bird x) {
        this(x,null, null);
    }
    public Bird getInfo() {
        return this.info;
    }
    public void setInfo(Bird inBird) {
        this.info = inBird;
    }
}