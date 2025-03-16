package BinariaBusca.source.StructNodeSource;

public class Node <T>{
    private T info;
    private Node<T> next;

    public Node(T info){
        this.info = info;
        this.next = null;
    }

    public T getInfo() { return this.info; }
    public void setInfo(T info) { this.info = info; }

    public Node<T> getNextNode() { return this.next; }
    public void setNextNode(Node<T> next) {this.next = next; }
}