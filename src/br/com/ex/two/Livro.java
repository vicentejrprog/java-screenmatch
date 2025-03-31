package br.com.ex.two;

public class Livro {
    private String titulo;
    private String autor;
    private Editora editora;

    public Livro(LivroRecord livroRecord) {
        titulo = livroRecord.title();
        autor = livroRecord.author();
        EditoraRecord er = livroRecord.publisher();
        editora = new Editora(er.Name(), er.Foundation());
    }


    @Override
    public String toString() {
        return "br.com.ex.two.Livro:\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "br.com.ex.two.Editora: " + editora;
    }



}
