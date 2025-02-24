package Exercicio1;

import Exercicio1.source.*;
import Exercicio1.source.Dados.Tarefa;

import java.util.Scanner;

public class App {
    public static void main (String[] args){
        int op;

        LDETarefa turma = new LDETarefa();
        Scanner leitor = new Scanner(System.in);

        while(true){
            do{
                System.out.println("Digite [1] para inserir.");
                System.out.println("Digite [2] para procurar por descricao.");
                System.out.println("Digite [3] para executar.");
                System.out.println("Digite [4] para remover tarefa por descricao.");
                System.out.println("Digite [5] para exibir por descricao.");
                System.out.println("Digite [6] para exibir todas.");
                System.out.println("Digite [7] para alterar.");
                System.out.println("Digite [0] para sair.");

                
                while (!leitor.hasNextInt()) {
                    System.out.println("Entrada inválida. Por favor, insira um número válido.");
                    leitor.next();
                }
                op = leitor.nextInt();
            } while(op < 0 || op > 7);
            
            if(op == 0){ break; }

            switch (op) {
                case 1:
                    leitor.nextLine();
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = leitor.nextLine();
                    
                    int prioridade;
                    while (true) {
                        System.out.print("Digite a prioridade da tarefa (1 a 10): ");
                        while (!leitor.hasNextInt()) {
                            System.out.println("Entrada inválida. Por favor, insira um número válido para a prioridade.");
                            leitor.next();
                        }
                        prioridade = leitor.nextInt();
                        if (prioridade >= 1 && prioridade <= 10) {
                            break;
                        } else {
                            System.out.println("Prioridade inválida. A prioridade deve estar entre 1 e 10.");
                        }
                    }

                    Tarefa tarefa = new Tarefa(descricao, prioridade);
                    turma.inserir(tarefa);
                    break;
            
                case 2:
                    leitor.nextLine();  
                    System.out.print("Digite a descrição da tarefa para procurar: ");
                    String procurar = leitor.nextLine();  
                    turma.buscarPorDescricao(procurar);
                    break;
                
                case 3:
                    turma.execute();
                    break;

                case 4:
                    leitor.nextLine(); 
                    System.out.print("Digite a descrição da tarefa para remover: ");
                    String procurarParaRemover = leitor.nextLine(); 
                    turma.RemoveByDescription(procurarParaRemover);
                    break;
                    
                case 5:
                    System.out.print("Digite a prioridade para exibir as tarefas: ");
                    
                    while (!leitor.hasNextInt()) {
                        System.out.println("Entrada inválida. Por favor, insira uma prioridade válida.");
                        leitor.next(); 
                    }
                    int procurarPrioridade = leitor.nextInt();  
                    turma.ExibirPorPrioridade(procurarPrioridade);
                    break;
                
                case 6:
                    turma.Exibir();
                    break;
                
                case 7:
                    leitor.nextLine(); 
                    System.out.print("Digite a descrição da tarefa para alterar: ");
                    String procurarDesc = leitor.nextLine();  
                    
                    
                    int novaprioridade;
                    while (true) {
                        System.out.print("Digite a nova prioridade da tarefa (1 a 10): ");
                        while (!leitor.hasNextInt()) {
                            System.out.println("Entrada inválida. Por favor, insira um número válido para a prioridade.");
                            leitor.next(); 
                        }
                        novaprioridade = leitor.nextInt();
                        if (novaprioridade >= 1 && novaprioridade <= 10) {
                            break; 
                        } else {
                            System.out.println("Prioridade inválida. A prioridade deve estar entre 1 e 10.");
                        }
                    }
                    turma.ChangePriority(procurarDesc, novaprioridade);
                    break;

                default:
                    break;
            }
        }
    }
}
