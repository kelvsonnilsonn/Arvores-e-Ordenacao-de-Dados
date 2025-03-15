package BinariaBusca.source;

import java.util.Stack;

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

    private ABBNode<T> removeNode (ABBNode<T> root, T value){
        if(root != null){
            int result = value.compareTo(root.getValue());
            if( result == 0 ){
                if( root.getLeftNode() == null && root.getRightNode() == null) root = null;
                else if( root.getLeftNode() == null) root = root.getRightNode();
                else if ( root.getRightNode() == null) root = root.getLeftNode();
                else {
                    ABBNode<T> pai, filho;
                    pai = root;
                    filho = pai.getLeftNode();
                    if(filho.getRightNode() != null){
                        while(filho.getRightNode() != null){
                            pai = filho;
                            filho = filho.getRightNode();
                        }
                        pai.setRightNode(filho.getLeftNode());
                    }
                    else {
                        pai.setLeftNode(filho.getLeftNode());
                    }
                    root.setValue(filho.getValue());
                }
            } else if( result < 0 ){
                root.setLeftNode(removeNode(root.getLeftNode(), value));
            } else {
                root.setRightNode(removeNode(root.getRightNode(), value));
            }
        }
        return root;
    }

    public void remove(T value){
        if(isEmpty()){
            ;
        } else {
            this.root = this.removeNode(this.root, value);
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

    public void percorrerEmOrdem(ABBNode<T> root){
        if(isEmpty()){
            ;
        } else {
            Stack<ABBNode<T>> pilha = new Stack<ABBNode<T>>();
            // ... //
        }
    }

    // public void remove2(T value){
    //     if(isEmpty()){
    //         ;
    //     } else {
    //         this.root = removeNode(this.root, value);
    //     }
    // }

    // private ABBNode<T> removeNode2(ABBNode<T> r, T value){
    //     if(r != null){
    //         if(value.compareTo(r.getValue()) < 0){
    //             r.setLeftNode(removeNode(r, value));
    //         } else if(value.compareTo(r.getValue()) > 0){
    //             r.setRightNode(removeNode(r, value));
    //         } else {
    //             if(r.getLeftNode() == null && r.getRightNode() == null) r = null;
    //             else if(r.getRightNode() == null) r = r.getLeftNode();
    //             else if(r.getLeftNode() == null) r = r.getRightNode();
    //             else {
    //                 ABBNode<T> pai, filho;
    //                 pai = r;
    //                 filho = pai.getLeftNode();
    //                 if(filho.getRightNode() != null){
    //                     while(filho.getRightNode() != null){
    //                         pai = filho;
    //                         filho = filho.getRightNode();
    //                     }
    //                     pai.setRightNode(filho.getLeftNode());
    //                 } else {
    //                     pai.setLeftNode(filho.getLeftNode());
    //                 }
    //                 root.setValue(filho.getValue());
    //             }
    //         }
    //     }
    //     return r;
    // }


    // private ABBNode<T> buscarPaiFilho(T value){
    //     ABBNode<T> pai = this.root;
    //     ABBNode<T> filho = pai;

    //     while(true){
    //         if(pai.getValue().compareTo(value) > 0){
    //             filho = pai.getLeftNode();
    //             if(filho.getLeftNode() == null){
    //                 return null;
    //             } else {
    //                 pai = filho;
    //                 filho = filho.getLeftNode();
    //             }
    //         } else if(pai.getValue().compareTo(value) < 0){
    //             filho = pai.getRightNode();
    //             if(filho.getRightNode() == null){
    //                 return null;
    //             } else {
    //                 pai = filho;
    //                 filho = filho.getRightNode();
    //             }
    //         } else {
    //             return filho;
    //         }
    //     }
    // }

    // private ABBNode<T> menorValor() {
    //     ABBNode<T> menorNode = root;
    //     if(isEmpty()){
    //         ;
    //     } else {
    //         while(menorNode.getLeftNode() != null){
    //             menorNode = menorNode.getLeftNode();
    //         }
    //     }
    //     return menorNode;
    // }

    // private ABBNode<T> maiorValor(){
    //     ABBNode<T> maiorNode = root;
    //     if(isEmpty()){
    //         ;
    //     } else {
    //         while(maiorNode.getRightNode() != null){
    //             maiorNode = maiorNode.getRightNode();
    //         }
    //     }
    //     return maiorNode;
    // }

    // public void exibirMenorValor(){
    //     System.out.printf("O menor valor: %d", menorValor().getValue());
    // }

    // public void exibirMaiorValor(){
    //     System.out.printf("O maior valor: %d", maiorValor().getValue());
    // }

}
