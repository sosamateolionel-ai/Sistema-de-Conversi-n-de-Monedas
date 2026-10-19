public abstract class ProveedorTasaCambio {

    protected String nombre;

    public ProveedorTasaCambio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double obtenerTasa(String monedaOrigen, String monedaDestino) {

        if (monedaOrigen == null || monedaOrigen.trim().isEmpty()
                || monedaDestino == null || monedaDestino.trim().isEmpty()) {
            System.out.println("[" + nombre + "] Error: las monedas no pueden estar vacías.");
            return -1;
        }

        monedaOrigen = monedaOrigen.toUpperCase();
        monedaDestino = monedaDestino.toUpperCase();

        if (monedaOrigen.equals(monedaDestino)) {
            return 1.0; // misma moneda: no hace falta consultar
        }

        double tasa = buscarTasa(monedaOrigen, monedaDestino);

        if (tasa <= 0) {
            System.out.println("[" + nombre + "] No hay cotización disponible para "
                    + monedaOrigen + " -> " + monedaDestino + ".");
            return -1;
        }

        return tasa;
    }

    // Cada fuente define sus cotizaciones. Devuelve 0 si no tiene el par.
    protected abstract double buscarTasa(String monedaOrigen, String monedaDestino);
}