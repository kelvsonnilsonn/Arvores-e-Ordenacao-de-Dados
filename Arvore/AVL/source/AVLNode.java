package AVL.source;

class AVLNode<T> {
    private AVLNode<T> left;
    private AVLNode<T> right;
    private int fatBal;
    private T info;

    AVLNode(T info){
        this.info = info;
    }

    public void setLeftAVLNode(AVLNode<T> node) { this.left = node; }
    public void setRightAVLNode(AVLNode<T> node) { this.right = node; }
    public void setNodeFatBal(int fb) { this.fatBal = fb; }
    public void setNodeInfo(T info) { this.info = info;}

    public AVLNode<T> getLeftAvlNode() { return this.left; }
    public AVLNode<T> getRightAvlNode() { return this.right; }
    public int getNodeFatBal() { return this.fatBal; }
    public T getNodeInfo() { return this.info; }

}
