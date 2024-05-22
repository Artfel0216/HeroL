package entidades;

public class Acao {
    private String nome;
    private double precoFechamento;

    public Acao(String nome, double precoFechamento) {
        this.nome = nome;
        this.precoFechamento = precoFechamento;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoFechamento() {
        return precoFechamento;
    }
}
