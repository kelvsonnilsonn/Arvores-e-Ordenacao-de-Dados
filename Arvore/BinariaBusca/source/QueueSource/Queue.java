package BinariaBusca.source.QueueSource;

public class Queue <T> {
    private QueueNode <T> head, tail;
    private int qtd;

    public boolean isEmpty(){ return qtd == 0; }

    public void put(T info){
        QueueNode <T> QueueNode = new QueueNode<T>(info);

        if(isEmpty()){
            this.head = QueueNode;
        } else {
            this.tail.setNextNode(QueueNode);
        }
        this.tail = QueueNode;
        this.qtd++;
    }

    public T dequeue(){
        T value;
        if(isEmpty()) return null;
        
        value = this.head.getInfo();
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNextNode();
        }

        this.qtd--;
        return value;
    }
}

