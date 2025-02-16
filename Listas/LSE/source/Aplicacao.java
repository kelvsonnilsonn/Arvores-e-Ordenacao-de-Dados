package LSE.source;

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
                    matricula = leitor.nextLine();

                    System.out.println("Digite o nome do aluno: ");
                    nome = leitor.nextLine();

                    System.out.println("Digite a media do aluno: ");
                    media = leitor.nextDouble();

                    System.out.println("Digite as faltas do aluno: ");
                    faltas = leitor.nextInt();

                    aluno = new Aluno(matricula);
                    aluno.setNome(nome);
                    aluno.setFaltas(faltas);
                    aluno.setMedia(media);

                    Turma.inserirInicio(aluno);
                    break;
                
                case 2:
                    System.out.println("Digite a matricula do aluno: ");
                    matricula = leitor.nextLine();

                    System.out.println("Digite o nome do aluno: ");
                    nome = leitor.nextLine();

                    System.out.println("Digite a media do aluno: ");
                    media = leitor.nextDouble();

                    System.out.println("Digite as faltas do aluno: ");
                    faltas = leitor.nextInt();

                    aluno = new Aluno(matricula);
                    aluno.setNome(nome);
                    aluno.setFaltas(faltas);
                    aluno.setMedia(media);

                    Turma.inserirFinal(aluno); 
                    break;

                case 3:
                    Turma.exibirTodos();
                    break;

                case 4:
                    System.out.println("Digite a matricula do aluno: ");
                    matricula = leitor.nextLine();
                    Turma.exibir(matricula);
                    break;

                case 5:
                    System.out.println("Digite a matricula do aluno: ");
                    matricula = leitor.nextLine();
                    Turma.alterar(matricula, leitor);
                    break;

                case 6:
                    Turma.removerInicio();
                    break;

                case 7:
                    Turma.removerFinal();
                    break;
            }
        } while (q != 0);
        leitor.close();

    }
}
