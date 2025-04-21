package servico;

import modelo.Produto;
import modelo.Usuario;
import pagamento.EstrategiaPagamento;
import pagamento.FabricaPagamento;
import repositorio.RepositorioProduto;
import repositorio.RepositorioUsuario;

import java.sql.Connection;
import java.util.List;

public class ServicoVenda {
    private RepositorioUsuario repositorioUsuario;
    private RepositorioProduto repositorioProduto;
    private Connection conexao;

    public ServicoVenda(Connection conexao) {
        this.conexao = conexao;
        this.repositorioUsuario = new RepositorioUsuario(conexao);
        this.repositorioProduto = new RepositorioProduto(conexao);
    }

    public void realizarVenda(String email, List<Long> idsProdutos, int formaPagamento) {
        Usuario usuario = repositorioUsuario.buscarPorEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado");
        }
        System.out.println("Usuário encontrado: " + usuario.getNome() + "\n");

        List<Produto> produtos = repositorioProduto.buscarPorIds(idsProdutos);
        if (produtos.isEmpty()) {
            throw new RuntimeException("Nenhum produto encontrado");
        }

        System.out.println("Produtos encontrados:");
        produtos.forEach(p -> System.out.println("- " + p.getNome() + " (R$ " + String.format("%.2f", p.getValor()) + ")"));
        System.out.println();

        double valorTotal = produtos.stream()
            .mapToDouble(Produto::getValor)
            .sum();

        EstrategiaPagamento pagamento = FabricaPagamento.criarPagamento(formaPagamento);
        String confirmacao = pagamento.processarPagamento(valorTotal);
        System.out.println(confirmacao + "\n");

        exibirResumoVenda(usuario, produtos, valorTotal, pagamento.getDescricao());
        System.out.println("\nVenda registrada com sucesso!");
    }

    private void exibirResumoVenda(Usuario usuario, List<Produto> produtos, 
                                 double valorTotal, String formaPagamento) {
        System.out.println("Resumo da venda:");
        System.out.println("Cliente: " + usuario.getNome());
        System.out.println("Produtos:");
        produtos.forEach(p -> System.out.println("- " + p.getNome()));
        System.out.println("Valor total: R$ " + String.format("%.2f", valorTotal));
        System.out.println("Pagamento: " + formaPagamento);
    }
}
