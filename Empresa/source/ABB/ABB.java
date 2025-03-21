package Empresa.source.ABB;

import Empresa.source.Produto;
import Empresa.source.ABB.Estruturas.Stack;

public class ABB<T> {
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

    public void exibirProdutos(){
        if(isEmpty()) ; 
        else passeioEmOrdem();
    }

    public void buscarProduto(Produto produto){
        Produto resultado = buscar(produto).getProduto();
        if(resultado != null){
            System.out.print(resultado);
        } else {
            System.out.print("Produto não encontrado.");
        }
    }


    ////////////////////////// Métodos PRIVADOS //////////////////////////


    private void passeioEmOrdem(){
        Stack<StoreABBNode<Produto>> pilha = new Stack<StoreABBNode<Produto>>();
        StoreABBNode<Produto> aux = this.root;
        
        pilha.push(aux);

        while(pilha.isEmpty() != true || aux != null){
            while(aux.getLeftNode() != null){
                aux = aux.getLeftNode();
                pilha.push(aux);
            }
            aux = pilha.pop();
            System.out.println(aux.getProduto());
            aux = aux.getRightNode();
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
