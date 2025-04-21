package servico;

import modelo.Produto;
import repositorio.RepositorioProduto;
import java.sql.Connection;

public class ServicoProduto {
    private RepositorioProduto repositorioProduto;

    public ServicoProduto(Connection conexao) {
        this.repositorioProduto = new RepositorioProduto(conexao);
    }

    public Produto cadastrarProduto(String nome, double valor) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode estar vazio");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do produto deve ser maior que zero");
        }
        return repositorioProduto.cadastrarProduto(nome, valor);
    }
}
