package empresa;

public class Produto {
    private long idProduto;
    private String designacao;
    private double precoVendaPublico;
    private int stock;

    public Produto(long idProduto, String designacao, double precoVendaPublico, int stock) {
        this.idProduto = idProduto;
        this.designacao = designacao;
        this.precoVendaPublico = precoVendaPublico;
        this.stock = stock;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public double getPrecoVendaPublico() {
        return precoVendaPublico;
    }

    public void setPrecoVendaPublico(double precoVendaPublico) {
        this.precoVendaPublico = precoVendaPublico;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return  "Id: " +
                idProduto +
                ", Designação: "
                + designacao +
                ", Preço de venda: "
                + precoVendaPublico +
                ", Estoque: " + stock +
                ".";
    }
}
