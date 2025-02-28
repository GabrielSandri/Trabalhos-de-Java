package veiculos;

public class Caminhao extends Veiculo {
    private double capacidadeCarga;

    public Caminhao(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, double capacidadeCarga) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public double calcularAutonomia() {
        double consumo = 6; // 6 km/L
        double reducao = Math.min(capacidadeCarga * 0.01, 0.25);
        return 300 * (consumo * (1 - reducao));
    }
}