package Empresa.source.ABB;

import Empresa.source.Produto;
import Empresa.source.ABB.Estruturas.Stack;

import java.util.Scanner;

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

    public void alterarPrecoProduto(String produto, Scanner scan){
        if(isEmpty()) return;
        else{
            StoreABBNode<Produto> produtoAAlterar = buscar(produto);
            alterarPrecoProdutoNoABB(produtoAAlterar, scan);
        }
    }

    public void alterarQtdProduto(String produto, Scanner scan){
        if(isEmpty()) return;
        else{
            StoreABBNode<Produto> produtoAAlterar = buscar(produto);
            alterarQtdProdutoNoABB(produtoAAlterar, scan);
        }
    }

    public void exibirProdutos(){
        if(isEmpty()) return;
        else passeioEmOrdem(this.root);
    }

    public void buscarProduto(Produto produto){
        Produto resultado = buscar(produto).getProduto();
        if(resultado != null){
            System.out.print(resultado);
        } else {
            System.out.print("Produto não encontrado.");
        }
    }

    public void exibirProduto(String codigo){
        if(isEmpty()) return;
        else{
            StoreABBNode<Produto> produtoAExibir = buscar(codigo);
            
            if(produtoAExibir != null){
                System.out.println(produtoAExibir);
            }
        }
    }

    public void removerProduto(String codigo){
        if(isEmpty()) return;
        else {
            this.root = removerProdutoDoABB(this.root, codigo);
        }
    }


    ////////////////////////// Métodos PRIVADOS //////////////////////////

    private StoreABBNode<Produto> removerProdutoDoABB(StoreABBNode<Produto> root, String value) {
        if (root == null) return null; // Proteção contra NullPointerException
    
        if (value.compareTo(root.getProduto().getCodigo()) > 0) {
            root.setRightNode(removerProdutoDoABB(root.getRightNode(), value));
        } else if (value.compareTo(root.getProduto().getCodigo()) < 0) {
            root.setLeftNode(removerProdutoDoABB(root.getLeftNode(), value));
        } else {
            if (root.getLeftNode() == null && root.getRightNode() == null) { 
                return null; // Nó folha, pode ser removido diretamente
            } else if (root.getLeftNode() == null) { 
                return root.getRightNode();
            } else if (root.getRightNode() == null) { 
                return root.getLeftNode();
            } else {
                StoreABBNode<Produto> pai = root;
                StoreABBNode<Produto> filho = pai.getLeftNode(); // Buscar maior na subárvore esquerda
    
                if (filho.getRightNode() != null) {
                    while (filho.getRightNode() != null) {
                        pai = filho;
                        filho = filho.getRightNode();
                    }
                    pai.setRightNode(filho.getLeftNode());
                } else {
                    root.setLeftNode(filho.getLeftNode());
                }
                root.setProduto(filho.getProduto());
            }
        }
        return root;
    }

    private void alterarQtdProdutoNoABB(StoreABBNode<Produto> produto, Scanner scan){
        int new_quantity = scan.nextInt();
        produto.getProduto().setQtd((new_quantity >= 0) ? new_quantity : 0);
    }

    private void alterarPrecoProdutoNoABB(StoreABBNode<Produto> produto, Scanner scan){
        double new_Price = scan.nextDouble();
        produto.getProduto().setPreco((new_Price >= 0) ? new_Price : 0.0);
    }

    private void passeioEmOrdem(StoreABBNode<Produto> r){
        if(r != null){
            passeioEmOrdem(r.getLeftNode());
            System.out.println(r.getProduto());
            passeioEmOrdem(r.getRightNode());
        }
    }

    private StoreABBNode<Produto> buscar(Produto produto){
        StoreABBNode<Produto> aux = this.root;

        if(isEmpty()) return null;
        else {
            while(true){
                if(aux.getProduto().compareTo(produto) > 0){
                    if(aux.getLeftNode() == null) return null;
                    aux = aux.getLeftNode();
                } else if(aux.getProduto().compareTo(produto) < 0){
                    if(aux.getRightNode() == null) return null;
                    aux = aux.getRightNode();
                } else {
                    return aux;
                }
            }
        }
    }

    private StoreABBNode<Produto> buscar(String codigo){
        StoreABBNode<Produto> aux = this.root;

        if(isEmpty()) return null;
        else {
            while(true){
                if(aux.getProduto().getCodigo().compareTo(codigo) > 0){
                    if(aux.getLeftNode() == null) return null;
                    aux = aux.getRightNode();
                } else if(aux.getProduto().getCodigo().compareTo(codigo) < 0){
                    if(aux.getRightNode() == null) return null;
                    aux = aux.getLeftNode();
                } else {
                    return aux;
                }
            }
        }
    }
}
