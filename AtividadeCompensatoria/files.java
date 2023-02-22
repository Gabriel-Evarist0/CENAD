package AtividadeCompensatoria;

import java.io.*;
import java.util.*;
import AtividadeCompensatoria.Entities.*;;

public class files {
    public static int numClient;
    public static String[] clientes = new String[numClient];

    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void escreveArquivo(int numClient) throws IOException {
        // clientes cl = new clientes();
        File arq = new File("./clientes.txt");
        FileWriter fw = new FileWriter(arq, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        Scanner scanner = new Scanner(System.in);
        String[] cl = new String[numClient];

        try {
            // LOGICA PARA VERIFICAR SE O ARQUIVO ESTA VAZIO/NÃO EXISTE E ESCREVER O LAYOUT
            // PADRÃO
            boolean statusArq = arq.createNewFile();
            // System.out.print(statusArq);
            if (lerArqCliente() == "") {

                pw.println("|NOME\t\t/CPF\t\t|");
                for (int i = 0; i < numClient; i++) {
                    System.out.println("Nome: ");
                    cl[i] = scanner.nextLine();
                    System.out.print("CPF:");
                    String cpf = scanner.nextLine();
                    pw.println("|" + cl[i] + "\t\t" + cpf + "|");
                    pw.flush();
                }
            }
            // CASO NÃO VAI APENAS ESCREVER OS DADOS DO CLIENTE
            else {
                for (int i = 0; i < numClient; i++) {
                    System.out.println("Nome: ");
                    cl[i] = scanner.nextLine();
                    System.out.print("CPF:");
                    String cpf = scanner.nextLine();
                    pw.println(cl[i] + "\t\t" + cpf);
                    pw.flush();
                }
            }
            pw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String lerArqCliente() {
        File arq = new File("./clientes.txt");
        String linha = "";

        try {
            FileReader fileReader = new FileReader(arq);
            BufferedReader buffReader = new BufferedReader(fileReader);

            while ((linha = buffReader.readLine()) != null) {
                linha = linha + "\n";
                System.out.print(linha);

            }

            fileReader.close();
            buffReader.close();
        } catch (IOException e) {
            System.out.println("arquivo não encontrado, sera criado no processo");
        }
        return linha;
    }

    public static void pesquisa(String doc) throws IOException {
        File arq = new File("./clientes.txt");
        String linha = "";
        char[] cha = new char[20];

        int offset = 0;
        int length = doc.length();

        try {
            FileReader fileReader = new FileReader(arq);
            BufferedReader buffReader = new BufferedReader(fileReader);

            while ((linha = buffReader.readLine()) != null) {
                linha = linha + "\n";
                if (linha.contains(doc)) {
                    System.out.println(linha);
                }
            }

            fileReader.close();
            buffReader.close();
        } catch (IOException e) {
            System.out.println("arquivo não encontrado, sera criado no processo");
        }

    }

    //////// CASO DE ERRO APAGAR A PARTIR DAQUI
    public static void menu() throws IOException {
        Scanner scChoose = new Scanner(System.in);
        System.out.println("MENU DE ACESSO DA LOJA");
        System.out.println("------------------------");
        System.out.println("1 - CADASTRO");
        System.out.println("2 - PESQUISA");
        System.out.println("3 - MOSTRAR TODOS");
        System.out.println("------------------------");
        System.out.print("Escolha: ");
        int choose = scChoose.nextInt();
        // CADASTRO DE DADOS
        switch (choose) {
            case 1:
                System.out.println("MENU DE ACESSO DA LOJA");
                System.out.println("------------------------");
                System.out.println("1 - CADASTRO DE CLIENTES");
                System.out.println("2 - CADASTRO DE PRODUTOS");
                System.out.println("3 - CADASTRO DE VENDAS");
                System.out.println("------------------------");
                System.out.print("Escolha: ");
                int choose2 = scChoose.nextInt();
                switch (choose2) {
                    case 1:
                        System.out.println("------------------------");
                        System.out.print("Número de clientes: ");
                        int numClientes = scChoose.nextInt();
                        escreveArquivo(numClientes);
                        System.out.println("PRES");
                        menu();
                        break;
                    case 2:
                        System.out.println("TESTE PRODUTO");
                        break;
                    case 3:
                        System.out.println("TESTE VENDAS");
                        break;
                }
                break;
            // PESQUISA DE DADOS
            case 2:
                System.out.println("MENU DE ACESSO DA LOJA");
                System.out.println("------------------------");
                System.out.println("1 - PESQUISA DE CLIENTES");
                System.out.println("2 - PESQUISA DE PRODUTOS");
                System.out.println("3 - PESQUISA DE VENDAS");
                System.out.println("------------------------");
                choose2 = scChoose.nextInt();
                switch (choose2) {
                    case 1:
                        System.out.println("Doc: ");
                        scChoose.nextLine();
                        String docs = scChoose.nextLine();
                        pesquisa(docs);
                        menu();
                        break;
                    case 2:
                        System.out.println("PESQUISA PRODUTO");
                        break;
                    case 3:
                        System.out.println("PESQUISA VENDAS");
                        break;
                }
                break;
            case 3:
                System.out.println();
                System.out.println("MENU DE ACESSO DA LOJA");
                System.out.println("------------------------");
                System.out.println("1 - MOSTRAR TODOS OS CLIENTES");
                System.out.println("2 - MOSTRAR TODOS OS PRODUTOS");
                System.out.println("3 - MOSTRAR TODAS AS VENDAS");
                System.out.println("------------------------");
                choose2 = scChoose.nextInt();
                switch (choose2) {
                    case 1:
                        lerArqCliente();
                        menu();
                        break;
                    case 2:
                        System.out.println("PESQUISA PRODUTO");
                        break;
                    case 3:
                        System.out.println("PESQUISA VENDAS");
                        break;
                }
                break;
        }
    }
}
