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

        if(buscar(taf) == null){
            
            node = new LDENode(taf);



            if(inicio == null){
                this.inicio = node;
                this.fim = node;
                this.qtd++; 
            } else {
                this.fim.setProxNode(node);
                this.fim = node;
                this.fim.setProxNode(null);
            }
        }

    }


    public LDENode buscar(Tarefa taf){
        int qtdTasksFinder = 0;
        LDENode aux;
        for(aux = this.inicio; aux != null; aux = aux.getProxNode(), qtdTasksFinder++){
            if(aux.getInfo().getTaskName().equals(taf.getTaskName())){
                System.out.printf("Foi encontrado %d tasks antes da task buscada.", qtdTasksFinder);
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
            if(taf.GetTaskPriority() < aux.getInfo().GetTaskPriority()){
                return aux;
            }
        }

        return aux;
    }
}
