package pessoas;

public class Empregado extends Pessoa {
    private int numeroSeccao;
    private float salarioBase;
    private float iRS;

    public Empregado(String nome, long contribuinte, byte idade) {
        super(nome, contribuinte, idade);
    }

    public float getiRS() {
        return iRS;
    }

    public void setiRS(float iRS) {
        this.iRS = iRS;
    }

    public int getNumeroSeccao() {
        return numeroSeccao;
    }

    public void setNumeroSeccao(int numeroSeccao) {
        this.numeroSeccao = numeroSeccao;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float calcularSalario() {
        return salarioBase + salarioBase * iRS / 100;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                + ", Contribuinte: " + getContribuinte()
                + ", Idade: " + getIdade()
                + ", Numero de seção: " + numeroSeccao
                + ", Salario base: " + salarioBase
                + ", Taxa iRS: " + iRS
                + ", Salario líquido: " + calcularSalario()
                + ", Indicativo: " + getCp().getIndicativo()
                + ", Extensão: " + getCp().getExtensao()
                + ", Zona: " + getCp().getZona();
    }
}
