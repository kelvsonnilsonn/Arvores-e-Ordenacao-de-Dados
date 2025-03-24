package Empresa.source;

import Empresa.source.ABB.ABB;
import java.util.Scanner;

public class Cadastro {
    private ABB<Produto> produtos;

    public Cadastro() {
        this.produtos = new ABB<>();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.inserir(produto);
    }

    public void removerProduto(String codigo) {
        produtos.removerProduto(codigo);
    }

    public void alterarPrecoProduto(String codigo, Scanner scan) {
        produtos.alterarPrecoProduto(codigo, scan);
    }

    public void alterarQtdProduto(String codigo, Scanner scan) {
        produtos.alterarQtdProduto(codigo, scan);
    }

    public void buscarProduto(String codigo) {
        produtos.exibirProduto(codigo);
    }

    public void listarProdutos() {
        produtos.exibirProdutos();
    }
}