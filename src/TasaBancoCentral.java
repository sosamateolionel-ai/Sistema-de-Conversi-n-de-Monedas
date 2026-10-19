public class TasaBancoCentral extends ProveedorTasaCambio {

    public TasaBancoCentral() {
        super("Banco Central");
    }

    @Override
    protected double buscarTasa(String monedaOrigen, String monedaDestino) {

        // Cotización oficial simulada (valores inventados)
        if (monedaOrigen.equals("USD") && monedaDestino.equals("ARS")) return 1000.0;
        if (monedaOrigen.equals("ARS") && monedaDestino.equals("USD")) return 0.001;
        if (monedaOrigen.equals("EUR") && monedaDestino.equals("ARS")) return 1080.0;
        if (monedaOrigen.equals("ARS") && monedaDestino.equals("EUR")) return 1.0 / 1080.0;

        return 0; // par no disponible
    }
}