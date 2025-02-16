package LSE.source;

import java.util.Scanner;

public class LSEAluno{
    private LSENode inicio;
    private LSENode fim;
    private int qtd;

    public boolean isEmpty(){
        return (this.qtd == 0);
    }

    private LSENode buscar(Aluno al) {
        for (LSENode aux = this.inicio; aux != null; aux = aux.getProx()) {
            if (al.compareTo(aux.getInfo()) == 0) {
                return aux;
            }
        }
        return null;
    }

    public void alterar(String matr, Scanner scan){
        Aluno procurar = new Aluno(matr);
        LSENode resultado = this.buscar(procurar);
        
        int escolha;
        double media;
        int faltas;


        if(resultado != null){
            do{
                System.out.println("Aluno encontrado. O que deseja alterar? [1] Media - [2] Falta - [3] Media e Falta");
                escolha = scan.nextInt();
            } while(escolha < 1 || escolha > 3);

            switch (escolha) {
                case 1:
                    System.out.println("Digite agora a media: ");
                    media = scan.nextDouble();
                    resultado.getInfo().setMedia(media);
                    break;
            
                case 2:
                    System.out.println("Digite agora as faltas: ");
                    faltas = scan.nextInt();
                    resultado.getInfo().setFaltas(faltas);
                    break;

                case 3:
                    System.out.println("Digite agora a media: ");
                    media = scan.nextDouble();
                    System.out.println("Digite agora as faltas: ");
                    faltas = scan.nextInt();
                    resultado.getInfo().setMedia(media);
                    resultado.getInfo().setFaltas(faltas);
                    break;
            }
            System.out.println("Dados atualizados.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }















    public void inserirInicio(Aluno al){
        LSENode retorno = this.buscar(al);
        LSENode novo;
        if (retorno == null){
            novo = new LSENode(al);

            if(this.isEmpty()){
                this.fim = novo;
            } else {
                novo.setProx(this.inicio);
            }
            
            this.inicio = novo;
            this.qtd++;

            System.out.println("Aluno inserido");

        } else {
            System.out.println("Aluno já existe.");
        }
    }

    public void inserirFinal(Aluno al){
        LSENode novo;
        LSENode resultado = this.buscar(al);

        if(resultado == null){
            novo = new LSENode(al);

            if(this.isEmpty()){
                this.inicio = novo;
                this.fim = novo;
                this.qtd++;
            } else {
                this.fim.setProx(novo);
                this.fim = novo;
                this.qtd++;
            }
        }
    }












    public void exibirTodos(){
        LSENode aux;
        
        if(this.isEmpty()){
            System.out.println("A lista está vazia.");
        } else {
            aux = this.inicio;
            System.out.println("Será listado todos os alunos:\n");
            while(aux != null){
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    public void exibir (String matricula){
        Aluno procurar = new Aluno(matricula);
        LSENode retorno = this.buscar(procurar);

        if(retorno == null){
            System.out.println("Aluno não encontrado.");
        } else {
            System.out.println("Dados do aluno:");
            System.out.println(retorno.getInfo());
        }
    }










    public void removerInicio(){
        if(this.isEmpty()){
            System.out.println("A lista está vazia.");
        } else{
            if(this.inicio == this.fim){
                this.inicio = null;
                this.fim = null;
            } else {
                this.inicio = this.inicio.getProx();
            }
            this.qtd--;
            System.out.println("Aluno removido do início da lista.");
        }
    }

    public void removerFinal(){

        LSENode aux;

        if(this.isEmpty()){
            System.out.println("A lista está vazia.");
        } else{
            if(this.inicio == this.fim){
                this.inicio = null;
                this.fim = null;
            } else {
                aux = this.inicio;
                while(aux.getProx().getProx() != null){
                    aux = aux.getProx();
                }

                this.fim = aux;
                aux.setProx(null);
            }
            this.qtd--;
        }
    }
}