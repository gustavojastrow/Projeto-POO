package pessoas;

public class Cliente extends Pessoa {
    private float plafond;
    private float valorEmDivida;

    public Cliente(String nome, long contribuinte, byte idade) {
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

    public float obterSaldo() {
        return plafond - valorEmDivida;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                + ", Contribuinte: " + getContribuinte()
                + ", Idade: " + getIdade()
                + ", Plafond: " + plafond
                + ", Valor em dívida: " + valorEmDivida
                + ", Saldo: " + obterSaldo()
                + ", Indicativo: " + getCp().getIndicativo()
                + ", Extensão: " + getCp().getExtensao()
                + ", Zona: " + getCp().getZona();
    }
}


