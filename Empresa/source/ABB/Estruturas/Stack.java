package Empresa.source.ABB.Estruturas;

public class Stack <T> {
    private Node<T> top;
    private int qtd;

    public boolean isEmpty() { return qtd == 0; }

    public void push(T info){
        Node<T> node = new Node<T>(info);

        node.setNextNode(top);
        this.top = node;

        this.qtd++;
    }

    public T pop(){

        if(isEmpty()) return null;

        T value = this.top.getInfo();
        this.top = this.top.getNextNode();
        
        this.qtd--;
        return value;
    }
}