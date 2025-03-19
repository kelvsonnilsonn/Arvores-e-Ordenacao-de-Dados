package BinariaBusca.source.QueueSource;

import BinariaBusca.source.StructNodeSource.Node;

public class Queue <T>{
    private Node <T> head, tail;
    private int qtd;

    public boolean isEmpty(){ return qtd == 0; }

    public void put(T info){
        Node <T> Node = new Node<T>(info);

        if(isEmpty()){
            this.head = Node;
        } else {
            this.tail.setNextNode(Node);
        }
        this.tail = Node;
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

    public T getHead() { return this.head.getInfo(); }
    
    public int length() { return this.qtd; }
}

