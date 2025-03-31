package br.com.ex;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Receitas {
    public static void main(String[] args) throws Exception{
        Scanner leitura = new Scanner(System.in);
        System.out.print("Digite a receita para buscar: ");
        var nomeReceita = leitura.nextLine();

        String endereco = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + nomeReceita;




        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

    }
}
