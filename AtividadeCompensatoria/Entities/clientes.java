package AtividadeCompensatoria.Entities;

import java.io.*;

public class clientes {
    public String nome, cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "|" + this.nome + "\t\t|" + this.cpf + " \t\t";
    }

    public void lerArquivo() {
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
