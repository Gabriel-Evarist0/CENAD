package AtividadeCompensatoria;

import java.io.*;
import java.util.*;
import AtividadeCompensatoria.Entities.*;;

public class files {
    public static void main(String[] args) {
        String func;
        Scanner sc = new Scanner(System.in);

        clientes cl = new clientes();
        func = sc.nextLine();

        try {
            escreveArquivo(func);

        } catch (IOException e) {
            e.printStackTrace();
        }

        cl.lerArquivo();
        sc.close();
    }

    public static void escreveArquivo(String func) throws IOException {
        // clientes cl = new clientes();
        File arq = new File("./clientes.txt");
        FileWriter fw = new FileWriter(arq, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        try {

            lerArquivo();
            boolean statusArq = arq.createNewFile();
            System.out.print(statusArq);
            pw.println("--------------------------");
            pw.println("|NOME\t\t/CPF\t\t|");
            pw.println(func);
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void lerArquivo() {
        File arq = new File("./clientes.txt");
        try {
            FileReader fileReader = new FileReader(arq);
            BufferedReader buffReader = new BufferedReader(fileReader);
            String linha = "";
            while ((linha = buffReader.readLine()) != null) {
                System.out.println(linha);
            }

            fileReader.close();
            buffReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
