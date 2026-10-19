# Sistema de Conversión de Monedas

## Descripción

Este proyecto implementa un conversor de monedas en Java que permite convertir montos utilizando diferentes proveedores de tasas de cambio. Se aplican conceptos de programación orientada a objetos para separar la lógica de conversión de las fuentes que proporcionan las cotizaciones.

## Funcionamiento

El sistema utiliza una clase abstracta llamada `ProveedorTasaCambio`, que valida las monedas ingresadas y solicita la cotización correspondiente a cada proveedor.

Se implementan dos fuentes de cotizaciones:

* **Banco Central:** ofrece cotizaciones simuladas para los pares USD/ARS, ARS/USD, EUR/ARS y ARS/EUR.
* **Mercado Libre:** ofrece cotizaciones simuladas para los pares USD/ARS, ARS/USD, USD/EUR y EUR/USD.

La clase `ConversorMoneda` recibe un proveedor de tasas y calcula el resultado multiplicando el monto por la cotización obtenida. También permite cambiar de proveedor durante la ejecución.

El programa compara la conversión de 100 USD a ARS con ambas fuentes, prueba pares de monedas disponibles únicamente en una de ellas y verifica casos inválidos, como montos negativos y monedas vacías. Si se solicita convertir una moneda a sí misma, la tasa es `1.0`.

## Clases principales

### `ProveedorTasaCambio`

Clase abstracta que define el nombre del proveedor y el método `obtenerTasa()`. Valida que los códigos de moneda no sean nulos ni estén vacíos, convierte los códigos a mayúsculas y delega la búsqueda de la cotización en el método abstracto `buscarTasa()`.

### `TasaBancoCentral`

Hereda de `ProveedorTasaCambio` e implementa las cotizaciones simuladas correspondientes al Banco Central. Devuelve `0` cuando no dispone del par solicitado.

### `TasaMercadoLibre`

Hereda de `ProveedorTasaCambio` e implementa otro conjunto de cotizaciones simuladas, con valores y pares de monedas diferentes.

### `ConversorMoneda`

Contiene una referencia a `ProveedorTasaCambio`, lo que permite cambiar la fuente de cotizaciones sin modificar la lógica de conversión. Valida que el monto no sea negativo, obtiene la tasa y calcula el resultado.

### `Main`

Crea una lista de proveedores, realiza conversiones con distintas fuentes y ejecuta pruebas para comprobar el funcionamiento de las validaciones.

## Conceptos de programación utilizados

* **Abstracción:** la clase `ProveedorTasaCambio` establece una estructura común para los proveedores.
* **Herencia:** las clases concretas heredan de la clase abstracta.
* **Polimorfismo:** una lista de tipo `ProveedorTasaCambio` permite trabajar con diferentes proveedores.
* **Sobrescritura de métodos:** cada proveedor implementa su propia versión de `buscarTasa()`.
* **Encapsulamiento:** `ConversorMoneda` mantiene el proveedor como atributo privado y permite modificarlo mediante métodos públicos.
* **Asociación:** el conversor utiliza un proveedor de tasas mediante una referencia a la abstracción.
* **Colecciones:** se utiliza `ArrayList` para almacenar los proveedores.
* **Validación de datos:** se controlan los montos negativos, las monedas vacías y las cotizaciones no disponibles.
* **Separación de responsabilidades:** cada clase se ocupa de una tarea específica.

## Tecnologías utilizadas

* Java.
* IntelliJ IDEA.
* Programación orientada a objetos (POO).
* Colecciones de Java (`ArrayList` y `List`).

## Ejecución

<img width="648" height="773" alt="image" src="https://github.com/user-attachments/assets/3085f4a8-f6bd-43f7-95f4-bc1e420de1dd" />

## Objetivo del ejercicio

Aplicar abstracción, herencia, polimorfismo y asociación para desarrollar un conversor flexible que pueda utilizar distintas fuentes de cotizaciones. También se busca practicar métodos abstractos, sobrescritura, validación de datos y separación de responsabilidades.
