package Exercicio1.source;

import Exercicio1.source.Dados.Tarefa;

public class LDETarefa {
    private LDENode inicio;
    private LDENode fim;
    private int qtd;

    public boolean isEmpty(){
        return (this.qtd == 0);
    }

    public void inserir(Tarefa taf){
        LDENode node = new LDENode(taf);
        LDENode aux = buscarPrioridade(taf);
    
        if(isEmpty()){
            this.inicio = node;
            this.fim = node;
        } else {
            if(aux == null) {
                this.fim.setProxNode(node);
                node.setAntNode(this.fim);
                this.fim = node;
            } else {
                if (aux.getInfo().getTaskPriority() == taf.getTaskPriority()) {
                    node.setProxNode(aux.getProxNode());
                    if (aux.getProxNode() != null) {
                        aux.getProxNode().setAntNode(node);
                    }
                    aux.setProxNode(node);
                    node.setAntNode(aux);
                } else {
                    if(aux.getAntNode() == null) {
                        node.setProxNode(this.inicio);
                        this.inicio.setAntNode(node);
                        this.inicio = node;
                    } else {
                        node.setProxNode(aux);
                        node.setAntNode(aux.getAntNode());
                        aux.getAntNode().setProxNode(node);
                        aux.setAntNode(node);
                    }
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

    public void RemoveByDescription(String Description){
        if(isEmpty()){
            System.out.println("A lista está vazia.");
        } else {
            for(LDENode aux = this.inicio; aux != null; aux = aux.getProxNode()){
                if(aux.getInfo().getTaskName().equals(Description)){
                    if(this.inicio == this.fim){
                        this.inicio = null;
                        this.fim = null;
                    } else if(aux == this.inicio){
                        this.inicio = aux.getProxNode();

                        aux.getProxNode().setAntNode(null);
                        aux.setProxNode(null);

                    } else if (aux == this.fim){
                        this.fim = aux.getAntNode();

                        this.fim.setProxNode(null);
                        aux.setAntNode(null);

                    } else {
                        aux.getAntNode().setProxNode(aux.getProxNode());
                        aux.getProxNode().setAntNode(aux.getAntNode());
                    }
                    this.qtd--;
                    break;
                }
            }
        }
    }

    public void ExibirPorPrioridade(int priority){

        int tasksQtd = 0;

        for(LDENode aux = this.inicio; aux != null; aux = aux.getProxNode()){
            if(aux.getInfo().getTaskPriority() == priority+1){
                System.out.printf("Há %d tasks de iguais prioridades!", tasksQtd);
                break;
            } else {
                if(aux.getInfo().getTaskPriority()  == priority){
                    System.out.printf("Task : %s ; - ; Prioridade : %d", aux.getInfo().getTaskName(), aux.getInfo().getTaskPriority());
                    tasksQtd++;
                }
            }
        }
    }

    public void Exibir(){
        for(LDENode aux = this.inicio; aux != null; aux = aux.getProxNode()){
            System.out.printf("Task : %s ; - ; Prioridade : %d\n", aux.getInfo().getTaskName(), aux.getInfo().getTaskPriority());
        }
    }

    public LDENode buscarPrioridade(Tarefa taf){
        LDENode aux;
        for(aux = this.inicio; aux != null; aux = aux.getProxNode()){
            if(taf.getTaskPriority() <= aux.getInfo().getTaskPriority()){
                return aux;
            }
        }

        return aux;
    }

    public LDENode buscarPorDescricao(String Description){
        int qtdTasksFinder = 0;
        if(isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        } else {
            for(LDENode aux = this.inicio; aux != null; aux = aux.getProxNode(), qtdTasksFinder++){
                if(aux.getInfo().getTaskName().equals(Description)){
                    System.out.printf("Foi encontrado %d tasks na frente da task buscada.", qtdTasksFinder);
                    return aux;
                }
            }
        }
        System.out.println("Não foi encontrado a tarefa buscada.");
        return null;
    }

    public void ChangePriority(String Description, int newPriority){
        LDENode novo = buscarPorDescricao(Description);

        if(novo != null){
            RemoveByDescription(novo.getInfo().getTaskName());
            novo.getInfo().setTaskPriority(newPriority);
            Tarefa atualizado = new Tarefa(novo.getInfo().getTaskName(), novo.getInfo().getTaskPriority());
            inserir(atualizado);
        }
    }
}