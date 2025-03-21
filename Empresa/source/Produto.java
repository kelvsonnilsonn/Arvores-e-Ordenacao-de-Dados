package Empresa.source;

public class Produto implements Comparable<Produto>{
    private String codigo;
    private String descricao;
    private String fornecedor;
    private double preco;
    private int qtd;

    public Produto(
            String codigo, String descricao,
            String fornecedor, double preco, int qtd
            )
    {
            this.codigo = codigo;
            this.descricao = descricao;
            this.fornecedor = fornecedor;
            this.preco = preco;
            this.qtd = qtd;
    }

    public String getCodigo() { return this.codigo; }
    public String getDescricao() { return this.descricao; }
    public String getFornecedor() { return this.fornecedor; }
    public double getPreco() { return this.preco; }
    public int getQtd() { return this.qtd; }

    public void setCodigo(String novoCod){ this.codigo = novoCod; }
    public void setDescricao(String novaDesc) { this.descricao = novaDesc; }
    public void setFornecdor(String novoFornecedor) { this.fornecedor = novoFornecedor; }
    public void setPreco(double novoPreco) { this.preco = novoPreco; }
    public void setQtd(int novaQtd) { this.qtd = novaQtd; }

    @Override
    public int compareTo(Produto outro) {
        return this.codigo.compareTo(outro.codigo);
    }

    @Override
    public String toString(){
        return String.format(
                "ID: %s\nDescricao: %s\nFornecedor: %s\nPreco: %.2f\nQuantidade: %d", 
                this.codigo, this.descricao, this.fornecedor, this.preco, this.qtd);
    }
}