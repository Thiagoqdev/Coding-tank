package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Insira o valor de cinco salarios");

        double [] salarios = new double [5];

        for (int i = 0; i < salarios.length; i++) {
            System.out.println("o valor do salario " + (i+1) + " é:");
            salarios[i] = input.nextDouble();
        }

        for (int i = 0; i < salarios.length; i++) {
            double salariobruto = salarios[i];
            double descontoInss = CalcularDescontoInss(salariobruto);
            double descontoIr = CalcularDescontoIr(salariobruto);
            double salarioLiquido = salariobruto - descontoIr - descontoInss;

            System.out.println("\nsalario " + (i + 1));
            System.out.println("o Salario bruto " + (i+1) + " é R$" + String.format("%.2f", salariobruto));
            System.out.println("o Desconto de INSS do salario " + (i+1) + " é R$" + String.format("%.2f", descontoInss));
            System.out.println("o Desconto do imposto de renda é R$" + String.format("%.2f", descontoIr));
            System.out.println("o Salario Liquido " + (i+1) + " é de R$" + String.format("%.2f", salarioLiquido));
        }

    }

    public static double CalcularDescontoInss(double salario){
        double descontoInss =0;
        if (salario <= 1212 ){
            descontoInss = salario * 0.075;
        }else if (salario >= 1212.01 && salario <= 2427.34 ) {
            descontoInss = salario * 0.09;
        }else if ( salario >= 2427.36 && salario <= 3641.03 ) {
            descontoInss = salario * 0.12;
        } else if ( salario >= 3641.04) {
            descontoInss = salario * 0.14;
        }
        return descontoInss;
    }

    public static double CalcularDescontoIr(double salario){
        double descontoIr =0;
        if (salario <= 1903.98 ){
            descontoIr = salario * 0;
        }else if (salario >= 1903.99 && salario <= 2826.65 ) {
            descontoIr = salario * 0.075;
        }else if ( salario >= 2826.66 && salario <= 3751.05 ) {
            descontoIr = salario * 0.15;
        } else if ( salario >= 3751.06 && salario <= 4664.68) {
            descontoIr = salario * 0.225;
        } else if (salario > 4664.68) {
            descontoIr = salario * 0.275;
        }
        return descontoIr;
    }

}