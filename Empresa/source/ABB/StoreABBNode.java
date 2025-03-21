package Empresa.source.ABB;


class StoreABBNode<T extends Comparable<T>>{
    private StoreABBNode<T> left, right;
    private T produto;

    StoreABBNode(T produto){
        this.produto = produto;
    }

    T getProduto() { return this.produto; }
    StoreABBNode<T> getLeftNode() { return this.left; }
    StoreABBNode<T> getRightNode() { return this.right; }

    void setProduto(T produto) { this.produto = produto; }
    void setLeftNode(StoreABBNode<T> left) { this.left = left; }
    void setRightNode(StoreABBNode<T> right) { this.right = right; }
}