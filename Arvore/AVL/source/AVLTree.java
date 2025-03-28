package AVL.source;

import BinariaBusca.source.QueueSource.Queue;

public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;
    private boolean status;

    public boolean isEmpty() { return root == null; }

    public void insert(T node){
        if(isEmpty()){
            this.root = new AVLNode<T>(node);
        } else {
            this.root = insertNode(node, this.root);
            this.status = false;
        }
    }

    /////////////////////////////////////////////////////////
    
    private AVLNode<T> insertNode(T node, AVLNode<T> root){

        if(root == null){
            root = new AVLNode<T>(node);
            this.status = true;
        } else if(root.getInfo().compareTo(node) > 0){
            root.setLeft(insertNode(node, root));
            if(status == true){
                switch(root.getFatBal()){
                    case 1: 
                        root.setFatBal(0);
                        this.status = false;
                        break;
                    case 0:
                        root.setFatBal(-1);
                        break;
                    case -1:
                        root = rotateRight(root);
                        break;
                }
            }
        } else {
            root.setRight(insertNode(node, root));
            if(status == true){
                switch(root.getFatBal()){
                    case -1: 
                        root.setFatBal(0);
                        this.status = false;
                        break;
                    case 0:
                        root.setFatBal(1);
                        break;
                    case 1:
                        root = rotateLeft(root);
                        break;
                }
            }
        }
        return root;
    }

    private AVLNode<T> rotateRight(AVLNode<T> a){
        AVLNode<T> b;
        b = a.getLeft();
        if(b.getFatBal() == -1){
            a.setLeft(b.getRight());
            b.setRight(a);
            a.setFatBal(0);
            a = b;
        } else {
            a = rotateRightDuo(a, b);
        }
        a.setFatBal(0);
        this.status = false;
        return a;
    }

    private AVLNode<T> rotateRightDuo(AVLNode<T> a, AVLNode<T> b){
        AVLNode<T> c;
        c = b.getRight();
        b.setRight(c.getLeft());
        c.setLeft(b);
        a.setLeft(c.getRight());
        c.setRight(a);
        if(c.getFatBal() == -1){
            a.setFatBal(1);
        }
        if(c.getFatBal() == 1){
            b.setFatBal(-1);
        } 

        else {
            b.setFatBal(0);
        }

        return c;
    }

    private AVLNode<T> rotateLeft (AVLNode<T> a) {
        AVLNode<T> b;
        b = a.getRight();
        if (b.getFatBal() == 1) {
            a.setRight(b.getLeft());
            b.setLeft(a);
            a.setFatBal(0);
            a = b;
        } else {
            a = rotateLeftDuo(a, b);
            }
        a.setFatBal(0);
        this.status = false;
        return a;
        }

    private AVLNode<T> rotateLeftDuo(AVLNode<T> a, AVLNode<T> b){
        AVLNode<T> c;
        c = b.getLeft();
        b.setLeft(c.getRight()); 
        c.setRight(b);
        a.setRight(c.getLeft());
        c.setLeft(a); 
        if (c.getFatBal() == 1) {
            a.setFatBal(-1);
        } else { 
            a.setFatBal(0);
        }
        if (c.getFatBal() == -1) {
            b.setFatBal(1);
        } else {
            b.setFatBal(0);
        }
        return c;
    }

    private void passeioEmOrdem(AVLNode<T> root){
        if(root != null){
            passeioEmOrdem(root.getLeft());
            System.out.print(root.getInfo());
            passeioEmOrdem(root.getRight());
        } else {
            System.out.print("null");
        }
    }

    private void passeioEmNivel(AVLNode<T> root) {
        if (root == null) return;
        
        Queue<AVLNode<T>> fila = new Queue<>();
        fila.put(root);
        
        while (!fila.isEmpty()) {
            AVLNode<T> atual = fila.dequeue();
            System.out.println(atual.getInfo() + 
                " -> " + (atual.getLeft() != null ? atual.getLeft().getInfo() : "null") + 
                ", " + (atual.getRight() != null ? atual.getRight().getInfo() : "null"));
                
            if (atual.getLeft() != null) fila.put(atual.getLeft());
            if (atual.getRight() != null) fila.put(atual.getRight());
        }
    }
}
