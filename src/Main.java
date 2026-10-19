import java.util.List;
import java.util.ArrayList;

void main() {

    List<ProveedorTasaCambio> fuentes = new ArrayList<>();
    fuentes.add(new TasaBancoCentral());
    fuentes.add(new TasaMercadoLibre());

    ConversorMoneda conversor = new ConversorMoneda(fuentes.get(0));

    System.out.println("===== 100 USD a ARS con cada fuente =====");
    for (ProveedorTasaCambio f : fuentes) {
        conversor.setProveedor(f);
        conversor.convertir(100, "USD", "ARS");
    }

    System.out.println("\n===== Pares que solo tiene una fuente =====");
    for (ProveedorTasaCambio f : fuentes) {
        conversor.setProveedor(f);
        conversor.convertir(50, "EUR", "ARS");
    }

    System.out.println("\n===== Casos inválidos =====");
    conversor.setProveedor(fuentes.get(0));
    conversor.convertir(-20, "USD", "ARS");   // monto negativo
    conversor.convertir(100, "", "ARS");      // moneda vacía
    conversor.convertir(100, "usd", "usd");   // misma moneda

}
