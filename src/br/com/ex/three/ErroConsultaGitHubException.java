package br.com.ex.three;

public class ErroConsultaGitHubException extends RuntimeException {
    String mensagem;

    public ErroConsultaGitHubException(String mensagem){
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage(){
        return this.mensagem;
    }

}
