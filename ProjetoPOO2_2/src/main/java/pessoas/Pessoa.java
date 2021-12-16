package pessoas;

public class Pessoa {

    private String nome;
    private long contribuinte;
    private byte idade;
    private CodigoPostal cp = new CodigoPostal();


    public Pessoa(String nome, long contribuinte, byte idade) {
        this.nome = nome;
        this.contribuinte = contribuinte;
        this.idade = idade;
    }

    public long getContribuinte() {
        return contribuinte;
    }

    public void setContribuinte(long contribuinte) {
        this.contribuinte = contribuinte;
    }

    public byte getIdade() {
        return idade;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCp(CodigoPostal cp) {
        this.cp = cp;
    }
    public CodigoPostal getCp() {
        return this.cp;
    }
}
