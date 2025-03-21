package Empresa.source.ABB;

import Empresa.source.Produto;

public class ABB {
    private StoreABBNode<Produto> root;

    public boolean isEmpty() { return root == null; }
    
    public void inserir(Produto node){
        if(isEmpty()) {
            root = new StoreABBNode<Produto>(node);
        } else {
            if(buscar(node) != null) return ;
            else {
                StoreABBNode<Produto> aux = root;

                while (true) {
                    if(aux.getProduto().compareTo(node) > 0){
                        if(aux.getLeftNode() == null) {
                            aux.setLeftNode(new StoreABBNode<Produto>(node));
                            break;
                        } else aux = aux.getLeftNode();
                    } else {
                        if(aux.getRightNode() == null){
                            aux.setRightNode(new StoreABBNode<Produto>(node));
                            break;
                        } else aux = aux.getRightNode();
                    }
                }
            }
        }
    }

    private StoreABBNode<Produto> buscar(Produto produto){
        StoreABBNode<Produto> aux = this.root;

        if(isEmpty()) ;
        else {
            while(true){
                if(aux.getProduto().compareTo(produto) > 0){
                    if(aux.getLeftNode() == null) return null;
                    aux = aux.getRightNode();
                } else if(aux.getProduto().compareTo(produto) < 0){
                    if(aux.getRightNode() == null) return null;
                    aux = aux.getLeftNode();
                } else {
                    return aux;
                }
            }
        }
        return null;
    }
}
