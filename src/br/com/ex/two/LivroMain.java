package br.com.ex.two;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LivroMain {
    public static void main(String[] args){
        String json = "{\n" +
                "  \"Title\": \"The Richest Man in Babylon\",\n" +
                "  \"Author\": \"George Samuel Clason\",\n" +
                "  \"Publisher\": {\n" +
                "    \"Name\": \"Harpercollins Brasil\",\n" +
                "    \"Foundation\": 1998\n" +
                "  }\n" +
                "}";

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

        LivroRecord livroRecord = gson.fromJson(json, LivroRecord.class);

        Livro livro = new Livro(livroRecord);

        System.out.print(livro);

    }
}
