package source;

import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        LSEAluno Turma = new LSEAluno();
        Aluno aluno;

        String matricula;
        String nome;
        double media;
        int faltas;

        int q;

        do{
            System.out.println("Escolha a opção que deseja:");
            System.out.println("[1] Inserir novo aluno no inicio");
            System.out.println("[2] Inserir novo aluno no final");
            System.out.println("[3] Exibir todos os alunos");
            System.out.println("[4] Exibir os dados de um aluno");
            System.out.println("[5] Alterar os dados de um aluno");
            System.out.println("[6] Remover o primeiro aluno");
            System.out.println("[7] Remover o ultimo aluno");
            System.out.println("[0] Sair");

            q = leitor.nextInt();
        } while(q < 0 || q > 7);

        leitor.nextLine();

        switch (q) {
            case 1:
                System.out.println("Digite a matricula do aluno: ");
                break;
        
            default:
                break;
        }


        leitor.close();

    }
}
