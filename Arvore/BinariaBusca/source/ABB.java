package BinariaBusca.source;

import BinariaBusca.source.StackSource.Stack;

public class ABB <T extends Comparable<T>>{// o <T> transforma em algo genérico - pode receber qualquer coisa.
    private ABBNode<T> root;
    private ABBNode<T> point;

    public boolean isEmpty(){ return (root == null); }

    public void inserir(T value){
        if(isEmpty()){
            root = new ABBNode<T>(value);
        } else {
            point = this.root;
            while(true){
                if(point.getValue().compareTo(value) > 0){
                    if(point.getLeftNode() == null){
                        point.setLeftNode(new ABBNode<T>(value));
                        break;
                    } else{
                        point = point.getLeftNode();
                        }
                } else if(point.getValue().compareTo(value) == 0){
                    break;
                } else {
                    if(point.getRightNode() == null){
                        point.setRightNode(new ABBNode<T>(value));
                        break;
                    } else {
                        point = point.getRightNode();
                    }
                }
            }
        }
    }

    public void remove(T value){
        if(isEmpty()){
            ;
        } else {
            this.root = this.removeNode(this.root, value);
        }
    }

    public void verEmOrdem(){
        if(isEmpty()) ;
        else percorrerEmOrdemNaoRecursiva(root);
    }
    
    /////////////////////////// PRIVATE METHODS ///////////////////////////
    
    /////////////////////////// PRIVATE METHODS ///////////////////////////
    

    private void percorrerEmOrdemNaoRecursiva(ABBNode<T> root){
        Stack<T> pilha = new Stack<T>();

        ABBNode<T> pai = root, filho = pai.getRightNode();
        while(filho.getRightNode() != null){
            
        }

        
    }
    
    
    private ABBNode<T> buscar(T value){
        point = this.root;

        if(isEmpty()){
            return null;
        } else {
            while(true){
                if(point.getValue().compareTo(value) > 0){
                    if(point.getLeftNode() == null){
                        return null;
                    } else {
                        point = point.getLeftNode();
                    }
                } else if (point.getValue().compareTo(value) < 0){
                    if(point.getRightNode() == null){
                        return null;
                    } else {
                        point = point.getRightNode();
                    }
                } else {
                    return point;
                }
            }
        }
    }
    
    private ABBNode<T> removeNode(ABBNode<T> root, T value){
        if(value.compareTo(root.getValue()) > 0) { root.setRightNode(removeNode(root, value)); }
        else if(value.compareTo(root.getValue()) < 0) { root.setLeftNode(removeNode(root, value)); }
        else {
            if(root.getLeftNode() == null & root.getRightNode() == null) { root = null; }
            else if(root.getLeftNode() == null) { root = root.getRightNode(); }
            else if(root.getRightNode() == null) { root = root.getLeftNode(); }
            else {
                ABBNode<T> pai = root;
                ABBNode<T> filho = pai.getLeftNode(); // Sempre começamos a buscar o maior na esquerda!
    
                if(filho.getRightNode() != null){
                    while(filho.getRightNode() != null){
                        pai = filho;
                        filho = filho.getRightNode();
                    }
                    pai.setRightNode(filho.getLeftNode());
                } else {
                    pai.setLeftNode(filho.getLeftNode());
                }
                root.setValue(filho.getValue());
            }
        }
        return root;
    }
}
