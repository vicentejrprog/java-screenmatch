package br.com.alura.screenmatch.principal;


import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmbd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class PrincipalComBusca {
    public static void main(String[] args) throws Exception{


        Scanner  leitura = new Scanner(System.in);
        System.out.print("Digite um filme para buscar: ");
        var busca = leitura.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=af61110c";




        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        String json = response.body();


        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

        TituloOmbd meuTituloOmbd = gson.fromJson(json, TituloOmbd.class);

        Titulo meuTitulo = new Titulo(meuTituloOmbd);

        System.out.println(meuTitulo);
















    }
}
