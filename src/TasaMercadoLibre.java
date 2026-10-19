public class TasaMercadoLibre extends ProveedorTasaCambio {

    public TasaMercadoLibre() {
        super("Mercado libre");
    }

    @Override
    protected double buscarTasa(String monedaOrigen, String monedaDestino) {

        // Cotización de mercado simulada (valores inventados, distintos a los oficiales)
        if (monedaOrigen.equals("USD") && monedaDestino.equals("ARS")) return 1250.0;
        if (monedaOrigen.equals("ARS") && monedaDestino.equals("USD")) return 1.0 / 1250.0;
        if (monedaOrigen.equals("USD") && monedaDestino.equals("EUR")) return 0.92;
        if (monedaOrigen.equals("EUR") && monedaDestino.equals("USD")) return 1.0 / 0.92;

        return 0; // par no disponible
    }
}