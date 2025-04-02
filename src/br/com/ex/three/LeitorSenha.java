package br.com.ex.three;

import java.util.Scanner;

public class LeitorSenha {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a senha que deseja utilizar: ");
        String digitado = input.nextLine();


        try {
            Senha senha = new Senha(digitado);
            System.out.println("Senha cadastrada com sucesso!");
        } catch (SenhaInvalidaException e){
            System.out.println(e.getMessage());
        }



    }
}
