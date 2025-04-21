package pagamento;

public interface EstrategiaPagamento {
    String processarPagamento(double valor);
    String getDescricao();
    String getDetalhesConfirmacao();
}
