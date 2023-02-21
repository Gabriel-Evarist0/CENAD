package AtividadeCompensatoria;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import AtividadeCompensatoria.Entities.*;;

public class aaaaa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome;
        nome = sc.nextLine() + "\n";

    }

    public static void escreveArquivo() {
        try {
            Files.write(Paths.get("./clientes.txt"), "nome".getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
