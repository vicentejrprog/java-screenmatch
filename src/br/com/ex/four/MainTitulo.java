package br.com.ex.four;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainTitulo {
    public static void main(String[] args){
        Titulo meuTitulo = new Titulo("Matrix", 60, 1999);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(meuTitulo);

        System.out.println(json);

    }
}
