package AtividadeCompensatoria;

import java.io.*;
import java.util.Scanner;

public class testes {
    public static String teste[][] = new String[5][2];

    public static void main(String[] args) throws IOException {
        String teste[][] = new String[5][2];
        FileWriter fw = new FileWriter("teste.txt", true);
        PrintWriter out = new PrintWriter(fw);
        Scanner sc = new Scanner(System.in);

        System.out.println(teste[4][0] == null);
        System.out.println(teste.length);
        System.out.println(teste[0].length);
        menu();

        /*
         * for (int l = 0; l < teste.length; l++) {
         * for (int c = 0; c < teste[0].length; c++) {
         * System.out.print(teste[l][c] + " "); // imprime caracter a caracter
         * }
         * System.out.println(" "); // muda de linha;
         * /*
         * for (int l = 0; l < teste.length; l++) {
         * for (int c = 0; c < teste[0].length; c++) {
         * System.out.print(teste[l][c] + " "); // imprime caracter a caracter
         * out.print(teste[l][c] + " ");
         * }
         * System.out.println(" "); // muda de linha
         * out.print(" ");
         * }
         */
    }

    public static void teste(String nome) {
        if (nome != "" || nome != null) {
            for (int l = 0; l < teste.length - 1; l++) {
                for (int c = 0; c < teste[0].length; c++) {
                    if (teste[l][c] != null) {
                        System.out.print(teste[l][c] + " ");
                    } else {
                        teste[l][c] = nome;
                        menu();

                    }
                }
                System.out.println(" ");
            }
        }
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome: ");
        String name = sc.nextLine();
        teste(name);
        sc.close();
    }

}
