package BinariaBusca.source;

import BinariaBusca.source.StackSource.Stack;
import BinariaBusca.source.QueueSource.Queue;

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

    public void verEmNivel(){
        if(isEmpty()) ;
        else percorrerEmNivel(this.root);
    }

    public void menorValor(){
        System.out.println(menorValorDaArvore(this.root));
    }

    public void maiorValor(){
        System.out.println(maiorValorDaArvore(this.root));
    }

    public void contarNos(){
        System.out.println(contadorRecursivoDeNos(this.root));
    }

    public void contarNosNaoRecursivo(){
        System.out.println(contadorDeNosSemRecursividade(this.root));
    }

    public void contarFolhas(){
        System.out.println(contadorRecursivoDeFolhas(this.root));
    }
    /////////////////////////// PRIVATE METHODS ///////////////////////////
    
    /////////////////////////// PRIVATE METHODS ///////////////////////////
    
    private void percorrerEmNivel(ABBNode<T> r){
        if(isEmpty()) ;
        else {
            Queue<ABBNode<T>> fila = new Queue<ABBNode<T>>();
            ABBNode<T> aux;
            fila.put(r);

            while(isEmpty() != true){   // se refere ao root ou à fila?
                aux = fila.dequeue();
                if(aux.getLeftNode() != null){
                    fila.put(aux.getLeftNode());
                }
                if(aux.getRightNode() != null){
                    fila.put(aux.getRightNode());
                }
                System.out.println(aux.getValue());
            }
        }
    }

    private T menorValorDaArvore(ABBNode<T> r){
        
        T min = r.getValue();
        for(; r != null; r = r.getLeftNode()){
            min = r.getValue();
        }

        return min;
    }

    private T maiorValorDaArvore(ABBNode<T> r){
        
        T max = r.getValue();
        for(; r != null; r = r.getRightNode()){
            max = r.getValue();
        }

        return max;
    }


    private void percorrerEmOrdemNaoRecursiva(ABBNode<T> root){ // esquerda; adiciona; direita
        Stack<ABBNode<T>> pilha = new Stack<ABBNode<T>>();

        ABBNode<T> aux = root;

        pilha.push(aux);

        for(; pilha.isEmpty() != true || aux != null; aux = aux.getRightNode()){
            for(; aux.getLeftNode() != null; aux = aux.getLeftNode()){
                pilha.push(aux);
            }
            aux = pilha.pop();
            System.out.println(aux.getValue());
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

    private int contadorRecursivoDeNos(ABBNode<T> root){
        if(root != null) return 1 + contadorRecursivoDeNos(root.getLeftNode()) +
                                    contadorRecursivoDeNos(root.getRightNode());
        return 0;
    }

    private int contadorDeNosSemRecursividade(ABBNode<T> root){
        int count = 0;
        Queue<ABBNode<T>> fila = new Queue<ABBNode<T>>();

        ABBNode<T> aux;

        fila.put(root);
        count++;
        while(fila.isEmpty() != true){
            aux = fila.dequeue();
            if(aux.getLeftNode() != null){
                count++;
                fila.put(aux.getLeftNode());
            }
            if(aux.getRightNode() != null){
                count++;
                fila.put(aux.getRightNode());
            }
        }
        return count;
    }

    private int contadorRecursivoDeFolhas(ABBNode<T> r){
        int count = 0;
        if(r != null){
            if(r.getLeftNode() == null && r.getRightNode() == null){
                count++;
            } else {
                count += contadorRecursivoDeFolhas(r.getLeftNode()) + contadorRecursivoDeFolhas(r.getRightNode());
            }
        }
        return count;
    }

    private int contadorDeFolhasNaoRecursiva(ABBNode<T> r){
        int count = 0;
        Queue<ABBNode<T>> fila = new Queue<ABBNode<T>>();
        ABBNode<T> aux;

        fila.put(r);
        while(fila.isEmpty() != true){
            aux = fila.dequeue();
            if(aux.getLeftNode() == null && aux.getRightNode() == null){
                count++;
            }

            if(aux.getLeftNode() != null){
                fila.put(aux.getLeftNode());
            }
            if(aux.getRightNode() != null){
                fila.put(aux.getRightNode());
            }
        }

        return count;
    }

    private int contadorDeNosNaoTerminaisRecursivo(ABBNode<T> r){
        int count = 0;
        if(r != null){
            if(r.getLeftNode() != null || r.getRightNode() != null){
                count += 1;
            }

            count += contadorDeNosNaoTerminaisRecursivo(r.getLeftNode()) + contadorDeNosNaoTerminaisRecursivo(r.getRightNode());
        }
        return count;
    }
}