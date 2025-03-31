package br.com.ex.two;

public class Pessoa {
    private String nome;
    private int idade;
    private String cidade;

    public Pessoa(PessoaRecord pessoaRecord){
        nome   = pessoaRecord.name();
        idade  = Integer.valueOf(pessoaRecord.age());
        cidade = pessoaRecord.city();
    }

    @Override
    public String toString(){
        return  "Nome: " + nome + "\nIdade: " + idade + "\nCidade: " + cidade;
    }
}
