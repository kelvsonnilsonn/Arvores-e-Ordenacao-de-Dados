package BinariaBusca.source.QueueSource;

public class QueueNode <T>{
    private T info;
    private QueueNode<T> next;

    public QueueNode(T info){
        this.info = info;
        this.next = null;
    }

    public T getInfo() { return this.info; }
    public void setInfo(T info) { this.info = info; }

    public QueueNode<T> getNextNode() { return this.next; }
    public void setNextNode(QueueNode<T> next) {this.next = next; }
}