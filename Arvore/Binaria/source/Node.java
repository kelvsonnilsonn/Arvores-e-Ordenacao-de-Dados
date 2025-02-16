package Binaria.source;

public class Node{
    private int value;
    private Node left;
    private Node right;

    public Node(int value){
        this.value = value;
    }

    public int getValue(){ return this.value; }
    public void setValue(int value){ this.value = value; }

    public Node getLeftNode(){ return this.left; }
    public void setLeftNode(Node leftNode){ this.left = leftNode; }

    public Node getRightNode(){ return this.right; }
    public void setRightNode(Node rightNode){ this.right = rightNode;}
}