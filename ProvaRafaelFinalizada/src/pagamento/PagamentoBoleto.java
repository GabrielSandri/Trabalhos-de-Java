package pagamento;

import java.util.Random;

public class PagamentoBoleto implements EstrategiaPagamento {
    private String numeroBoleto;

    @Override
    public String processarPagamento(double valor) {
        System.out.println("Aguarde, gerando boleto...");
        // Simula processamento
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        this.numeroBoleto = gerarNumeroBoleto();
        return "Boleto gerado com sucesso. Número: " + numeroBoleto;
    }

    @Override
    public String getDescricao() {
        return "Boleto";
    }

    @Override
    public String getDetalhesConfirmacao() {
        return numeroBoleto;
    }

    private String gerarNumeroBoleto() {
        Random random = new Random();
        return String.format("%011d", Math.abs(random.nextLong() % 100000000000L));
    }
}
