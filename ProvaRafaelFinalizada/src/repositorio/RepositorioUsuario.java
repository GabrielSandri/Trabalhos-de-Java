package repositorio;

import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioUsuario {
    private Connection conexao;

    public RepositorioUsuario(Connection conexao) {
        this.conexao = conexao;
    }

    public Usuario buscarPorEmail(String email) {
        try {
            PreparedStatement stmt = conexao.prepareStatement(
                "SELECT * FROM usuarios WHERE email = ?"
            );
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getString("nome"),
                    rs.getString("email")
                );
                usuario.setId(rs.getLong("id"));
                return usuario;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário por email", e);
        }
    }
}
