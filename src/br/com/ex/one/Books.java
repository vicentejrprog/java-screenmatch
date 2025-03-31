package br.com.ex;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Books {
    public static void main(String[] args) throws Exception{
        Scanner leitura = new Scanner(System.in);
        System.out.print("Digite o livro para buscar: ");
        var nomeLivro = leitura.nextLine();

        String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + nomeLivro + "&key=AIzaSyBuZKMFluQHimXHHqghk0iMf6RsTnrZ5Hc";




        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());



    }
}
