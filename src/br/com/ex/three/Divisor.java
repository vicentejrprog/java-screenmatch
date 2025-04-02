package br.com.ex.three;

import java.util.Scanner;

public class Divisor {
    public static void main(String[] args) {

        System.out.println("Vamos dividir!");
        Scanner numeros = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int numero1 = numeros.nextInt();

        System.out.print("Digite o segundo número: ");
        int numero2 = numeros.nextInt();


        try {

            int resultado = numero1 / numero2;
            System.out.println(resultado);

        } catch (ArithmeticException e){
            System.out.println("Erro: o divisor não pode ser zero!");
        }



    }
}
