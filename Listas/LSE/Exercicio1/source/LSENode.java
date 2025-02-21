package Exercicio1.source;

import Exercicio1.source.Dados.Aluno;

class LSENode{
    private Aluno info;
    private LSENode prox;

    LSENode(Aluno al){
        this.info = al;
    }

    public Aluno getInfo(){ return info; }
    public void setInfo(Aluno info){ this.info = info; }

    public LSENode getProx(){ return prox; }
    public void setProx(LSENode prox){ this.prox = prox; }
}