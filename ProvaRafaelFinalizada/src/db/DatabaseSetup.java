package db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {

    public static void executarScript(String caminhoArquivoSQL) {
        try (Connection conn = ConexaoBanco.conectar();
             Statement stmt = conn.createStatement();
             BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivoSQL))) {

            StringBuilder sql = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                sql.append(linha).append("\n");
                if (linha.trim().endsWith(";")) {
                    stmt.execute(sql.toString());
                    sql.setLength(0);
                }
            }

            System.out.println("Script executado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao executar o script SQL:");
            e.printStackTrace();
        }
    }
}