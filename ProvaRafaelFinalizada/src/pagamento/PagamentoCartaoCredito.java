package pagamento;

public class PagamentoCartaoCredito implements EstrategiaPagamento {
    private String codigoAutorizacao;

    @Override
    public String processarPagamento(double valor) {
        System.out.println("Aguarde, processando pagamento no cartão...");
        // Simula processamento
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        this.codigoAutorizacao = gerarCodigoAutorizacao();
        return "Pagamento no cartão aprovado. Código de Autorização: " + codigoAutorizacao;
    }

    @Override
    public String getDescricao() {
        return "Cartão de Crédito";
    }

    @Override
    public String getDetalhesConfirmacao() {
        return codigoAutorizacao;
    }

    private String gerarCodigoAutorizacao() {
        return String.format("%06d", (int)(Math.random() * 1000000));
    }
}
