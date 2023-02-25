package AtividadeCompensatoria;

import java.io.*;
import java.util.*;

public class files {
    public static int numClient;
    public static String[] clientes = new String[numClient];

    public static void main(String[] args) throws IOException {
        //testDebugger();
        menu();
    }

    public static void escreveArquivo(int numClient) throws IOException {
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
            if (lerArqCliente().equals("")) {

                pw.println("|NOME\t\t\t\tCPF\t\t|");
                for (int i = 0; i < numClient; i++) {
                    System.out.println("Nome: ");
                    cl[i] = scanner.nextLine();
                    System.out.println("CPF:");
                    String cpf = scanner.nextLine();
                    pw.println(cl[i] +"-"+ "\t\t" + cpf);
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

    public static String pesquisa(String doc, String action) throws IOException {
        File arq = new File("./clientes.txt");
        File arqProd = new File("./produtos.txt");
        File arqVenda = new File ("./vendas.txt");
        String linha = "";
        char[] cha = new char[20];

        int offset = 0;
        int length = doc.length();
        if(action.equals("cliente")){
            try {
                FileReader fileReader = new FileReader(arq);
                BufferedReader buffReader = new BufferedReader(fileReader);

                while ((linha = buffReader.readLine()) != null) {
                    linha = linha + "\n";
                    if (linha.contains(doc)) {
                        //System.out.println(linha);
                        return linha;
                    }
                }
                fileReader.close();
                buffReader.close();
            } catch (IOException e) {
                System.out.println("arquivo não encontrado, sera criado no processo");
            }
        }else if(action.equals("produtos")){
            try {
                FileReader fileReader = new FileReader(arqProd);
                BufferedReader buffReader = new BufferedReader(fileReader);

                while ((linha = buffReader.readLine()) != null) {
                    linha = linha + "\n";
                    if (linha.contains(doc)) {
                        //System.out.println(linha);
                        return linha;
                    }
                }

                fileReader.close();
                buffReader.close();
            } catch (IOException e) {
                System.out.println("arquivo não encontrado, sera criado no processo");
            }
        }else if(action.equals("vendas")){
            FileReader fileReader = new FileReader(arqVenda);
            BufferedReader buffReader = new BufferedReader(fileReader);
            Scanner scanner = new Scanner(new File ("./vendas.txt"));
            scanner.useDelimiter("/");
            try{
                while ((linha = buffReader.readLine()) != null) {
                    linha = linha + "\n";
                    if (linha.contains("Cliente: " + doc)) {
                        System.out.println(linha);
                    }
                }
                fileReader.close();
                buffReader.close();
            }catch (IOException e) {
                System.out.println("arquivo não encontrado, sera criado no processo");
            }
        }
        return linha;

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
                        menu();
                        break;
                    case 2:
                        System.out.println("NUMERO PRODUTOS:");
                        int numProds = scChoose.nextInt();
                        escreveArquivoProd(numProds);
                        menu();
                        break;
                    case 3:
                        System.out.println("Cliente efetuando a compra:");
                        scChoose.nextLine();
                        String clienteCompra = scChoose.nextLine();
                        escreveArquivoVendas(1, clienteCompra);
                        menu();
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
                System.out.println("Escolha: ");
                choose2 = scChoose.nextInt();
                switch (choose2) {
                    case 1:
                        System.out.print("Doc: ");
                        scChoose.nextLine();
                        String docs = scChoose.nextLine();
                        System.out.println("\n" + pesquisa(docs, "cliente"));
                        menu();
                        break;
                    case 2:
                        System.out.print("Doc: ");
                        scChoose.nextLine();
                        docs = scChoose.nextLine();
                        System.out.println(pesquisa(docs, "produtos"));
                        menu();
                        break;
                    case 3:
                        System.out.println("PESQUISA VENDAS");
                        System.out.println("NOME DO CLIENTE: ");
                        scChoose.nextLine();
                        docs = scChoose.nextLine();
                        pesquisa(docs, "vendas");
                        menu();
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
                        lerArqProd();
                        menu();
                        break;
                    case 3:
                        lerArqVendas();
                        menu();
                        break;
                }
                break;
        }
    }



    public static void escreveArquivoProd(int numprod) throws IOException {
        // clientes cl = new clientes();
        File arq = new File("./produtos.txt");
        FileWriter fw = new FileWriter(arq, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        Scanner scanner = new Scanner(System.in);
        String[] pd = new String[numprod];

        try {
            // LOGICA PARA VERIFICAR SE O ARQUIVO ESTA VAZIO/NÃO EXISTE E ESCREVER O LAYOUT
            // PADRÃO
            boolean statusArq = arq.createNewFile();
            System.out.print(arq.exists());
            if (!arq.exists()) {
                pw.println("|NOME PRODUTO\t\t/PREÇO\t\t|");
                for (int i = 0; i < numprod; i++) {
                    System.out.println("Nome do Produto: ");
                    pd[i] = scanner.nextLine();
                    System.out.println("Preço:");
                    double preco = scanner.nextDouble();
                    pw.println(pd[i] + "\t\t" + "R$ " + Double.toString(preco));
                    pw.flush();
                }
            }
            // CASO NÃO VAI APENAS ESCREVER OS DADOS DO CLIENTE
            else {
                for (int i = 0; i < numprod; i++) {
                    System.out.println("Nome do Produto: ");
                    pd[i] = scanner.nextLine();
                    System.out.print("Preço:");
                    String preco = scanner.nextLine();
                    pw.println(pd[i] + "\t\t" + "R$" +preco);
                    pw.flush();
                }
            }
            pw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String lerArqProd() {
        File arq = new File("./produtos.txt");
        String linha = "";

        try {
            FileReader fileReader = new FileReader(arq);
            BufferedReader buffReader = new BufferedReader(fileReader);

            while ((linha = buffReader.readLine()) != null) {
                linha = linha + "\n";
                System.out.print(linha);
            }
            System.out.println("------------------------------");
            fileReader.close();
            buffReader.close();

        } catch (IOException e) {
            System.out.println("arquivo não encontrado, sera criado no processo");
        }
        return linha;
    }
    private static String lerArqVendas() {
        File arq = new File("./vendas.txt");
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
    public static void escreveArquivoVendas(int numVenda, String clienteV) throws IOException{
        File arq = new File("./vendas.txt");
        FileWriter fw = new FileWriter(arq, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        Scanner scanner = new Scanner(System.in);
        String[] pd = new String[numVenda];


        try {
            // LOGICA PARA VERIFICAR SE O ARQUIVO ESTA VAZIO/NÃO EXISTE E ESCREVER O LAYOUT
            // PADRÃO
            boolean statusArq = arq.createNewFile();

            if (!arq.exists()) {

                pw.println("|NOME PRODUTO\t\t/PREÇO\t\t|");
                for (int i = 0; i < numVenda; i++) {
                    System.out.println("Nome do Produto: ");
                    pd[i] = scanner.nextLine();
                    System.out.print("Quantidade:");
                    int qnt = scanner.nextInt();
                    String str = new String(pesquisa(pd[i],"produtos"));
                    String cl = new String(pesquisa(clienteV,"cliente"));
                    int pos = str.indexOf("$");
                    double preco = Double.parseDouble(str.substring(pos + 1));
                    double precoTotal = preco * qnt;
                    pw.printf("Cliente: %s | Produto: %s | Quantidade: %d | Preço Final: %.2f\n",cl.substring(0,cl.indexOf("-")),pd[i],qnt,precoTotal);
                    pw.println("-------------------------------------------------");
                    pw.flush();
                }
            }
            // CASO NÃO VAI APENAS ESCREVER OS DADOS DO CLIENTE
            else {
                for (int i = 0; i < numVenda; i++) {
                    System.out.println("Nome do Produto: ");
                    pd[i] = scanner.nextLine();
                    System.out.print("Quantidade:");
                    int qnt = scanner.nextInt();
                    String str = new String(pesquisa(pd[i], "produtos"));
                    String cl = new String(pesquisa(clienteV,"cliente"));
                    int pos = str.indexOf("$");
                    double preco = Double.parseDouble(str.substring(pos + 1));
                    double precoTotal = preco * qnt;
                    pw.printf("Cliente: %s | Produto: %s | Quantidade: %d | Preço Final: %.2f\n",cl.substring(0,cl.indexOf("-")),pd[i],qnt,precoTotal);
                    pw.println("---------------------------------------------------------------------------");
                    pw.flush();
                }
            }
            pw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
