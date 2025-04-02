package br.com.ex.three;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class BuscaGit {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome do usuário do github que deseja visualizar: ");
        String usuario = input.nextLine();

        String endereco = "https://api.github.com/users/" + usuario;

        // Consumindo API rest

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404) {
                throw new ErroConsultaGitHubException("Usuário não encontrado no GitHub.");

            }
            // Tratando json

            String json = response.body();

            Gson gson = new GsonBuilder().create();

            RecordUsuario recordUsuario = gson.fromJson(json, RecordUsuario.class);

            Usuario usuario1 = new Usuario(recordUsuario);

            System.out.println(usuario1);


        } catch (ErroConsultaGitHubException e){
            System.out.println(e.getMessage());
        }








    }
}
