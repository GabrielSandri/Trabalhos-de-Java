package repositorio;

import modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioProduto {
    private Connection conexao;

    public RepositorioProduto(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Produto> buscarPorIds(List<Long> ids) {
        List<Produto> produtos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM produtos WHERE id IN (" + 
                String.join(",", Collections.nCopies(ids.size(), "?")) + ")";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            for (int i = 0; i < ids.size(); i++) {
                stmt.setLong(i + 1, ids.get(i));
            }
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getString("nome"),
                    rs.getDouble("valor")
                );
                produto.setId(rs.getLong("id"));
                produtos.add(produto);
            }
            return produtos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produtos", e);
        }
    }

    public Produto cadastrarProduto(String nome, double valor) {
        try {
            String sql = "INSERT INTO produtos (nome, valor) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nome);
            stmt.setDouble(2, valor);
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                Produto produto = new Produto(nome, valor);
                produto.setId(rs.getLong(1));
                return produto;
            }
            
            throw new RuntimeException("Erro ao obter ID do produto cadastrado");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar produto", e);
        }
    }
}
