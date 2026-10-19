public class ConversorMoneda {

    private ProveedorTasaCambio proveedor; // referencia a la ABSTRACCIÓN

    public ConversorMoneda(ProveedorTasaCambio proveedor) {
        this.proveedor = proveedor;
    }

    public void setProveedor(ProveedorTasaCambio proveedor) {
        this.proveedor = proveedor;
    }

    public double convertir(double monto, String monedaOrigen, String monedaDestino) {

        System.out.println("\nFuente: " + proveedor.getNombre());

        if (monto < 0) {
            System.out.println("Conversor: el monto no puede ser negativo (" + monto + ").");
            return -1;
        }

        double tasa = proveedor.obtenerTasa(monedaOrigen, monedaDestino);

        if (tasa < 0) {
            System.out.println("Conversor: no se pudo realizar la conversión.");
            return -1;
        }

        double resultado = monto * tasa;

        System.out.printf("   %.2f %s x %.4f = %.2f %s%n",
                monto, monedaOrigen.toUpperCase(), tasa, resultado, monedaDestino.toUpperCase());

        return resultado;
    }
}