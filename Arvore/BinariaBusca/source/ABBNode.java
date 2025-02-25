package BinariaBusca.source;

class ABBNode <T extends Comparable <T>> { // Esse "extends Comparable <T>" é para comparar dois T's quaisquer com compareTo.
    T value;
    private ABBNode<T> left;
    private ABBNode<T> right;

    ABBNode(T value){
        this.value = value;
    }

    T getValue(){ return this.value; }
    void setValue(T value){ this.value = value; }

    ABBNode<T> getLeftNode(){ return this.left; }
    void setLeftNode(ABBNode<T> leftNode){ this.left = leftNode; }

    ABBNode<T> getRightNode(){ return this.right; }
    void setRightNode(ABBNode<T> rightNode){ this.right = rightNode;}

}
