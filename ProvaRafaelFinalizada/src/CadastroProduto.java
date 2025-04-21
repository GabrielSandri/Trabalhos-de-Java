import db.ConexaoBanco;
import modelo.Produto;
import servico.ServicoProduto;
import java.sql.Connection;
import java.util.Scanner;

public class CadastroProduto {
    public static void main(String[] args) {
        try (Connection conexao = ConexaoBanco.conectar()) {
            ServicoProduto servicoProduto = new ServicoProduto(conexao);
            Scanner scanner = new Scanner(System.in);

            System.out.println("=== Cadastro de Produto ===");
            
            System.out.print("Digite o nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o valor do produto: ");
            double valor = scanner.nextDouble();

            var produto = servicoProduto.cadastrarProduto(nome, valor);
            System.out.println("\nProduto cadastrado com sucesso!");
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Valor: R$ " + produto.getValor());
            
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
