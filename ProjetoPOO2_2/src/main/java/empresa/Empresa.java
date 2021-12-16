package empresa;

import pessoas.CodigoPostal;
import pessoas.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private int dataFundacao;
    private CodigoPostal cp = new CodigoPostal();
    private List<Produto> produtos;
    private List<Pessoa> pessoas;

    public Empresa() {
        this.produtos = new ArrayList<>();
        this.pessoas = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public CodigoPostal getCp() {
        return cp;
    }

    public void setCp(CodigoPostal cp) {
        this.cp = cp;
    }

    public int getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(int dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }


    public void mostraProdutos() {
        System.out.println("Lista de Produtos: ");
        for (Produto p01 : getProdutos()) {
            System.out.println(p01.toString());
        }
    }

    public Produto obterProduto(long produtoId) {
        return produtos.stream().filter(e -> e.getIdProduto() == produtoId).findFirst().orElse(null);
    }

    public void atualizarProduto(Produto novoProduto){
        Produto produto = obterProduto(novoProduto.getIdProduto());
        produto.setDesignacao(novoProduto.getDesignacao());
        produto.setStock(novoProduto.getStock());
        produto.setPrecoVendaPublico(novoProduto.getPrecoVendaPublico());
    }

    public void removerProdutos(int idProduto){
        produtos.removeIf(e -> e.getIdProduto() == idProduto);
    }

    public void mostraPessoas() {
        for (Pessoa pessoa : getPessoas()) {
            System.out.println(pessoa.toString());
        }
    }

    public boolean isProdutoCadastrado(long id) {
        return produtos.stream().anyMatch(e -> e.getIdProduto() == id);
    }

    @Override
    public String toString() {
        return  "Nome: " + getNome() +
                ", Data de fundação: " + getDataFundacao() +
                '.';
    }
}

