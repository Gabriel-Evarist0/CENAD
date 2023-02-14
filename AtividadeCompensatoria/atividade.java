package AtividadeCompensatoria;

import java.util.*;
import java.io.*;

public class atividade {
    public static String[][] clientes = new String[10][2];

    public static void main(String[] args) throws IOException {
        clientes[0][0] = "teste";
        // MENU
        menu();
    }

    // FUNÇÕES DE VISUAL (MENU E ESCOLHA DE OPÇÃO DO MENU)
    public static void menu() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("MENU PRINCIPAL (Digite um numero para escolher a opção)");
        System.out.println("------------------------------");
        System.out.println("1 - Cadastros");
        System.out.println("2 - Mostrar dados");
        System.out.println("3 - Busca");
        System.out.print("Choose: ");
        int choose = sc.nextInt();
        choose(choose);

    }

    public static void choose(int choose) throws IOException {
        Scanner sc1 = new Scanner(System.in);
        int choose2;
        switch (choose) {
            case 1:
                System.out.println("1 - Cadastro de Cliente");
                System.out.println("2 - Cadastro de Produto");
                System.out.println("3 - Cadastro de Venda");
                System.out.print("Choose: ");
                choose2 = sc1.nextInt();
                switch (choose2) {
                    case 1:
                        cadastraCliente();
                        menu();
                        break;
                    case 2:
                        cadastraProduto();
                        break;
                    case 3:
                        cadastraVenda();
                        break;
                    default:
                        System.out.println("Erro ao validar escolha, reiniciando....");
                        choose(1);

                }
                break;
            case 2:
                System.out.println("1 - Mostrar Clientes");
                System.out.println("2 - Mostrar Produtos");
                System.out.println("3 - Mostrar Vendas");
                System.out.print("Choose: ");
                choose2 = sc1.nextInt();
                switch (choose2) {
                    case 1:
                        showClientes();
                        break;
                    case 2:
                        showProdutos();
                        break;
                    case 3:
                        showVendas();
                        break;
                    default:
                        System.out.println("Erro ao validar escolha, reiniciando....");
                        choose(2);
                }
                break;
        }
        sc1.close();
    }

    // FUNÇÕES DE CADASTRO
    public static void cadastraCliente() throws IOException {
        FileWriter fw = new FileWriter("bancoAtividadeCompensatoria.txt", true);
        PrintWriter out = new PrintWriter(fw);
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome: ");
        String name = sc.nextLine();
        System.out.println("CLIENTE CADASTRADO");
        if (name != "" || name != null) {
            try {
                for (int i = 0; i < clientes.length; i++) {
                    for (int j = 0; j < clientes[0].length; j++) {
                        if (clientes[i][j] != null) {
                            out.print(clientes[i][j] + " ");

                        } else {
                            clientes[i][j] = name;
                            out.print(clientes[i][j]);
                        }
                    }
                }
                out.println(" ");
            } catch (NullPointerException e) {
                clientes[1][0] = name;
                out.print(clientes[1][0]);
            }
        }

        out.close();
    }

    public static void cadastraProduto() {
        System.out.println("PRODUTO CADASTRADO");
    }

    public static void cadastraVenda() {
        System.out.println("VENDA CADASTRADO");
    }

    // FUNÇÕES PARA MOSTRAR INFOS

    public static void showClientes() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("bancoAtividadeCompensatoria.txt"));
        System.out.println("CLIENTES");
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
        }

    }

    public static void showProdutos() {
        System.out.println("PRODUTOS");
    }

    public static void showVendas() {
        System.out.println("VENDAS");
    }
}