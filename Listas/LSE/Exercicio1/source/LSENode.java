package Exercicio1.source;

public class LSENode{
    private Aluno info;
    private LDENode prox;

    LSENode(Aluno al){
        this.info = al;
    }

    public Aluno getInfo(){ return info; }
    public void setInfo(Aluno info){ this.info = info; }

    public LDENode getProx(){ return prox; }
    public void setProx(LDENode prox){ this.prox = prox; }
}