package pagamento;

public class FabricaPagamento {
    public static EstrategiaPagamento criarPagamento(int opcao) {
        switch (opcao) {
            case 1:
                return new PagamentoCartaoCredito();
            case 2:
                return new PagamentoBoleto();
            case 3:
                return new PagamentoPix();
            default:
                throw new IllegalArgumentException("Forma de pagamento inválida");
        }
    }
}
