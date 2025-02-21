package BinariaBusca.source;

public class ABB <T extends Comparable<T>>{// o <T> transforma em algo genérico - pode receber qualquer coisa.
    private ABBNode<T> root;

    public boolean isEmpty(){ return (root == null); }
}
