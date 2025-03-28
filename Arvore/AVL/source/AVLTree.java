package AVL.source;

public class AVLTree<T> {
    private AVLNode<T> root;
    private boolean status;

    public boolean isEmpty() { return root == null; }

    public void insert(T node){
        if(isEmpty()){
            this.root = new AVLNode<T>(node);
        }
    }
}
