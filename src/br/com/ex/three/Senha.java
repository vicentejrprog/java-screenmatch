package br.com.ex.three;

public class Senha {
    private String senha;

    public Senha(String senha){

        if(senha.length() < 8){
            throw  new SenhaInvalidaException("A senha possui menos de 8 caracteres!");
        }
        this.senha = senha;
    }
}
