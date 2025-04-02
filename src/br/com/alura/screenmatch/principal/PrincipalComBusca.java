package br.com.alura.screenmatch.principal;


import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmbd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PrincipalComBusca {
    public static void main(String[] args) throws Exception{
        Scanner  leitura = new Scanner(System.in);

        String busca =  "";

        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();


        while(!busca.equalsIgnoreCase("sair")) {
            System.out.print("Digite um filme para buscar: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }


            try {


                String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=af61110c";



                // Implementando o consumo de api
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();


                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Implementando json
                String json = response.body();




                TituloOmbd meuTituloOmbd = gson.fromJson(json, TituloOmbd.class);

                Titulo meuTitulo = new Titulo(meuTituloOmbd);
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);


            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro:");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
                System.out.println("O programa finalizou corretamente!");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }

        FileWriter escrita = new FileWriter("Filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("Programa finalizado com sucesso.");

    }
}
