package Exercicio1.source;

 class LDENode{
    private LDENode ant;
    private Tarefa info;
    private LDENode prox;

    LDENode(Tarefa taf){ this.info = taf; }

    public Tarefa getInfo() { return this.info; }
    public void setInfo(Tarefa newTaf) { this.info = newTaf; }

    public LDENode getAntNode() { return this.ant; }
    public void setAntNode(LDENode newAnt){ this.ant = newAnt; }

    public LDENode getProxNode() { return this.prox; }
    public void setProxNode(LDENode newProx) { this.prox = newProx; }

}

