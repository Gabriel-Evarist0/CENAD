package AtividadeCompensatoria;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testes {
    public static void main(String[] args) throws IOException {
        cadastro();
        ler();
    }

    public static void cadastro() throws IOException {
        Scanner sc = new Scanner(System.in);
        FileWriter arq1 = new FileWriter("teste.txt");
        PrintWriter gravaArq = new PrintWriter(arq1);
        int n;
        System.out.println("Qnts func? ");
        n = sc.nextInt();
        String[] clientes = new String[n];
        String[] CPFs = new String[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            System.out.print("Nome: ");
            clientes[i] = sc.nextLine();
            System.out.println();
            System.out.print("CPF: ");
            CPFs[i] = sc.nextLine();
        }
        gravaArq.printf("Clientes \t CPF");
        gravaArq.printf("\n------------------------");
        // ESCREVE NO ARQUIVO.TXT
        for (int i = 0; i < n; i++) {
            gravaArq.printf("\n%s\t\t %s", clientes[i], CPFs[i]);
            gravaArq.printf("\n------------------------");
        }
        arq1.close();
    }

    // MOSTRA NO CONSOLE A LISTA DE CLIENTES
    public static void ler() throws FileNotFoundException {
        File arq = new File("teste.txt");
        Scanner scArq = new Scanner(arq);
        while (scArq.hasNextLine()) {
            String data = scArq.nextLine();
            System.out.println(data);
        }
    }
}
