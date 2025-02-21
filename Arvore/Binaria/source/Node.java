package Binaria.source;

class Node{
    private int value;
    private Node left;
    private Node right;

    public Node(int value){
        this.value = value;
    }

    int getValue(){ return this.value; }
    void setValue(int value){ this.value = value; }

    Node getLeftNode(){ return this.left; }
    void setLeftNode(Node leftNode){ this.left = leftNode; }

    Node getRightNode(){ return this.right; }
    void setRightNode(Node rightNode){ this.right = rightNode;}
}