import db.ConexaoBanco;
import servico.ServicoVenda;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Scanner;
import db.DatabaseSetup;

public class Main {
    public static void main(String[] args) {
        DatabaseSetup.executarScript("resources/database.sql");
         try (Connection conexao = ConexaoBanco.conectar()) {
        System.out.println("Conexão bem-sucedida!");
    } catch (Exception e) {
        System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        e.printStackTrace();
    }
        try (Connection conexao = ConexaoBanco.conectar()) {
            ServicoVenda servicoVenda = new ServicoVenda(conexao);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o email do usuário: ");
            String email = scanner.nextLine();

            System.out.print("Digite os IDs dos produtos (separados por vírgula): ");
            String[] ids = scanner.nextLine().split(",");
            Long[] idsProdutos = Arrays.stream(ids).map(Long::parseLong).toArray(Long[]::new);

            System.out.println("Escolha a forma de pagamento:");
            System.out.println("1 - Cartão de Crédito");
            System.out.println("2 - Boleto");
            System.out.println("3 - PIX");
            int opcaoPagamento = scanner.nextInt();

            servicoVenda.realizarVenda(email, Arrays.asList(idsProdutos), opcaoPagamento);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}