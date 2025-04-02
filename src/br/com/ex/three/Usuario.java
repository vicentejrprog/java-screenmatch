package br.com.ex.three;

public class Usuario {
    private String nome;
    private String usuario;
    private int repositorios;

    public Usuario(RecordUsuario usuario){
        this.nome = usuario.name();
        this.usuario = usuario.login();
        this.repositorios = Integer.valueOf(usuario.public_repos());

    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "\nusuario: " + this.usuario + "\nrepositórios: " + this.repositorios;
    }


}
