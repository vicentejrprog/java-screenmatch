package br.com.ex.two;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainPessoa {
    public static void main(String[] args){
        String json = "{\n" +
                "  \"Name\": \"Vicente Jr\",\n" +
                "  \"Age\": 21,\n" +
                "  \"City\": \"Guaxupé\",\n" +
                "  \"State\": \"Minas Gerais\"\n" +
                "}";


        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setLenient().create();

        PessoaRecord pessoaRecord = gson.fromJson(json, PessoaRecord.class);

        Pessoa pessoa = new Pessoa(pessoaRecord);

        System.out.print(pessoa);


    }
}
