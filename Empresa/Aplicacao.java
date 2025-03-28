package Empresa;

import Empresa.source.Produto;
import Empresa.source.Cadastro;

import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Alterar preço do produto");
            System.out.println("4. Alterar quantidade do produto");
            System.out.println("5. Buscar produto");
            System.out.println("6. Listar produtos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Código: ");
                    String codigo = scan.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scan.nextLine();
                    System.out.print("Fornecedor: ");
                    String fornecedor = scan.nextLine();
                    System.out.print("Preço: ");
                    double preco = scan.nextDouble();
                    System.out.print("Quantidade: ");
                    int quantidade = scan.nextInt();
                    scan.nextLine();

                    Produto novoProduto = new Produto(codigo, descricao, fornecedor, preco, quantidade);
                    cadastro.cadastrarProduto(novoProduto);
                    break;
                case 2:
                    System.out.print("Código do produto a remover: ");
                    String codRemover = scan.nextLine();
                    cadastro.removerProduto(codRemover);
                    break;
                case 3:
                    System.out.print("Código do produto para alterar preço: ");
                    String codPreco = scan.nextLine();
                    cadastro.alterarPrecoProduto(codPreco, scan);
                    break;
                case 4:
                    System.out.print("Código do produto para alterar quantidade: ");
                    String codQtd = scan.nextLine();
                    cadastro.alterarQtdProduto(codQtd, scan);
                    break;
                case 5:
                    System.out.print("Código do produto para buscar: ");
                    String codBuscar = scan.nextLine();
                    cadastro.buscarProduto(codBuscar);
                    break;
                case 6:
                    cadastro.listarProdutos();
                    break;
                case 7:
                    System.out.println("Encerrando o programa...");
                    scan.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}