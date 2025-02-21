package Binaria.source;

public class BinaryTree{
    private Node root;
    private Node aux;
    
    public void insert(int value){ // Sem recursividade
        if(root == null){
            root = new Node(value);
        } else {
            aux = root;
            while(true){
                if(value < aux.getValue()){
                    if(aux.getLeftNode() == null){
                        aux.setLeftNode(new Node(value));
                        break;
                    } else {
                        aux.getLeftNode();
                    }
                } else {
                    if(aux.getRightNode() == null){
                        aux.setRightNode(new Node(value));
                        break;
                    } else {
                        aux.getRightNode();
                    }
                }
            }
        }
    }
}