package BinariaBusca.source;

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
}
