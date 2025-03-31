package br.com.ex.two;

public class Editora {
    private String nome;
    private int anoDeFundacao;


    public Editora(String nome, int anoDeFundacao){
        this.nome = nome;
        this.anoDeFundacao = anoDeFundacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\n  Nome: " + nome + "\n  Fundada em: " + anoDeFundacao;
    }


}
