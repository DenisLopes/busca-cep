import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String cep= "";
        List<Endereco> enderecos = new ArrayList<>();

        ConsultaCep consultaCep = new ConsultaCep();
        GeradorDeArquivo gerador = new GeradorDeArquivo();

        while (!cep.equalsIgnoreCase("sair")) {

            System.out.println("Digite um número de CEP para consulta:");
            cep = leitura.nextLine();

            if (cep.equalsIgnoreCase("sair")){
                break;
            }

            try {
                Endereco novoEndereco = consultaCep.buscaEndereco(cep);
                System.out.println(novoEndereco);
                enderecos.add(novoEndereco);
                gerador.salvaJson(novoEndereco);
            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
            }
        }


        if (cep.equalsIgnoreCase("sair")){
            System.out.println("Finalizando a aplicação");
        }
    }
}
