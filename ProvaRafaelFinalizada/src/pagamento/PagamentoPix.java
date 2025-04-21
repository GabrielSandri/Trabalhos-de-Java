package pagamento;

import java.util.UUID;

public class PagamentoPix implements EstrategiaPagamento {
    private String chaveAutenticacao;

    @Override
    public String processarPagamento(double valor) {
        System.out.println("Aguarde, efetuando pagamento...");
        // Simula processamento
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        this.chaveAutenticacao = UUID.randomUUID().toString();
        return "Pagamento confirmado com sucesso via PIX. Chave de Autenticação: " + chaveAutenticacao;
    }

    @Override
    public String getDescricao() {
        return "PIX";
    }

    @Override
    public String getDetalhesConfirmacao() {
        return chaveAutenticacao;
    }
}
