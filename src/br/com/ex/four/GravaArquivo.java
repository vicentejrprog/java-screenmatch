package br.com.ex.four;

import javax.sound.midi.Soundbank;
import java.io.FileWriter;
import java.io.IOException;

public class GravaArquivo {
    public static void main(String[] args){
        String mensagem = "Conteúdo a ser gravado no arquivo";

        try {
            FileWriter arquivo = new FileWriter("src/br/com/ex/four/arquivo.txt");
            arquivo.write(mensagem);
            arquivo.close();
            System.out.println("Arquivo gravado com sucesso");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao gravar o arquivo:");
            e.printStackTrace(); // Como se fosse um SQLERRM mais detalhado
        }

        // alternativa usando o try-with-resources

        try (FileWriter arquivo = new FileWriter("src/br/com/ex/four/arquivo2.txt")){
            arquivo.write(mensagem);
            arquivo.close();
            System.out.println("Arquivo gravado com sucesso");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao gravar o arquivo:");
            e.printStackTrace(); // Como se fosse um SQLERRM mais detalhado
        }

    }
}
