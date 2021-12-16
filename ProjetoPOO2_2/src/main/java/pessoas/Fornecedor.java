package pessoas;

public class Fornecedor extends Pessoa {
    private float plafond;
    private float valorEmDivida;

    public Fornecedor(String nome, long contribuinte, byte idade) {
        super(nome, contribuinte, idade);
    }

    public float getPlafond() {
        return plafond;
    }

    public void setPlafond(float plafond) {
        this.plafond = plafond;
    }

    public float getValorEmDivida() {
        return valorEmDivida;
    }

    public void setValorEmDivida(float valorEmDivida) {
        this.valorEmDivida = valorEmDivida;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                + ", Contribuinte: " + getContribuinte()
                + ", Idade: " + getIdade()
                + ", plafond: " + plafond
                + ", Dívida: " + valorEmDivida
                + ", Indicativo: " + getCp().getIndicativo()
                + ", Extensão: " + getCp().getExtensao()
                + ", Zona: " + getCp().getZona();
}
}
