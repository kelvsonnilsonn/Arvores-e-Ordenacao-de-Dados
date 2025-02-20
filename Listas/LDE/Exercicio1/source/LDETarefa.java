package Exercicio1.source;

public class LDETarefa {
    private LDENode inicio;
    private LDENode fim;
    private int qtd;

    LDETarefa(){
        this.inicio = null;
        this.fim = null;
        this.qtd = 0;
    }

    public boolean isEmpty(){
        return (this.qtd == 0);
    }

    public void inserir(Tarefa taf){
        LDENode node;
        LDENode aux;

        node = new LDENode(taf);
        
        if(isEmpty()){

            this.inicio = node;
            this.fim = node;

        } else {

            aux = buscarPrioridade(taf);

            if(aux == null){
                this.fim.setProxNode(node);
                this.fim = node;
                this.fim.setProxNode(null);
            } else {
                if (aux.getInfo().GetTaskPriority() == taf.GetTaskPriority()){
                    aux.setProxNode(node);
                } else {
                    node.setProxNode(aux);
                    aux.setAntNode(node);
                }
            }
        }
        this.qtd++;

    }

    public void execute(){
        if(isEmpty()){
            System.out.println("A lista está vazia.");
        } else {
            if (this.inicio == this.fim){
                this.inicio = null;
                this.fim = null;
            } else {
                this.inicio = this.inicio.getProxNode();
                this.inicio.setAntNode(null);
            }
        }
        this.qtd--;
    }


    public LDENode buscar(Tarefa taf){
        int qtdTasksFinder = 0;
        LDENode aux;
        for(aux = this.inicio; aux != null; aux = aux.getProxNode(), qtdTasksFinder++){
            if(aux.getInfo().getTaskName().equals(taf.getTaskName())){
                System.out.printf("Foi encontrado %d tasks na frente da task buscada.", qtdTasksFinder);
                return aux;
            }
        }
        
        if(aux == null){
            System.out.println("Não foi encontrado a tarefa buscada.");
        }
        
        return aux;
    }

    public LDENode buscarPrioridade(Tarefa taf){
        LDENode aux;
        for(aux = this.inicio; aux != null; aux = aux.getProxNode()){
            if(taf.GetTaskPriority() <= aux.getInfo().GetTaskPriority()){
                return aux;
            }
        }

        return aux;
    }
}
