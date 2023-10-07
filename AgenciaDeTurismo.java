import ar.edu.unlu.poo.ej214.*;

import java.util.ArrayList;
import java.util.List;

/*
Ejercicio 2: Agencia de Turismo
La agencia SunBeach decide contratar un equipo de profesionales en sistemas para encarar una solución a sus problemas de
gestión a través del desarrollo de un software a medida. SunBeach tiene proveedores en todo el mundo (compañías aéreas,
marítimas y terrestres (medios de transporte), cadenas de hoteles, hosterías, búngalos (hospedajes), y guías de turismo
que ofrecen distintas excursiones). Continuamente se comunica con los mismos y de acuerdo a las distintas ofertas
disponibles diseña y arma paquetes de turismo.

Cada paquete de turismo está compuesto por 1 (un) destino, 1 (un) medio de transporte, 1 (un) hospedaje y varias (1 o más) excursiones.
Los clientes que se acercan a la agencia pueden elegir entre los distintos paquetes de turismo vigentes, los cuales abonan en efectivo.

El sistema debe permitir llevar un registro de los distintos proveedores y su clasificación (medios de transporte, hospedajes o excursiones),
los paquetes de turismo y cómo están compuestos, los clientes de la agencia y las compras que realiza cada cliente.

A fin de mes el administrador de SunBeach necesita un informe que contenga un listado de todas las ventas realizadas, organizadas por destino.
También quiere conocer cuál es el destino favorito por sus clientes.

Objetivo:
    * Encontrar los objetos que participan del problema.
    * Definir asociaciones entre los objetos, comportamiento y estructura de cada uno.
    * Validar el modelo construido para garantizar que responde a los requisitos del problema.

Ejercicio 14
La agencia de turismo SunBeach decide contratar un equipo de profesionales en sistemas para encarar una solución a sus
problemas de gestión a través del desarrollo de un software a medida.

SunBeach tiene 3 tipos de proveedores: de transporte, guías turísticos y hospedaje. Continuamente se comunica con los
mismos y de acuerdo a las distintas ofertas disponibles diseña y arma paquetes de turismo.

Cada paquete de turismo requiere de 3 proveedores de los cuales solo resulta interesante obtener el dinero a pagarles
por el paquete, ya que ese dato es necesario para calcular el precio final por persona (no es necesario saber de qué tipo
son los proveedores), además el paquete debe contener un destino.

Cada proveedor cobra un importe base por sus servicios. Además, según el tipo de proveedor se le agrega un importe extra
al valor total que cobra el proveedor por sus servicios según la cantidad de clientes máxima que tenga el paquete, entonces:

    1 - El proveedor de hospedaje calcula el valor extra de la siguiente manera:

        * Si la cantidad de clientes máxima del paquete supera la cantidad mínima de clientes que acepta el proveedor
          (MaxPaq > MinProv), este último hace una rebaja del 0.5% del valor total del servicio base por cada cliente que
          supere la cantidad mínima de clientes que acepte el proveedor.
        * Si la cantidad máxima del paquete es igual a la mínima del proveedor (MaxPaq = MinProv), el valor extra es $0.
        * Si la cantidad máxima del paquete es menor (MaxPaq < MinProv) a la mínima del proveedor, el valor extra es $0.

    2 - El de transporte lo calcula así: Por cada cliente, se agrega un precio extra de 0.3% del precio base por los
          servicios de catering durante el viaje.

    2 - El guía turístico nunca agrega valor extra, salvo que la cantidad de clientes sea mayor a 200, en ese caso solo
        aumenta $90 el servicio.

Los clientes que se acercan a la agencia pueden elegir entre los distintos paquetes de turismo vigentes, los cuales abonan en efectivo.

El sistema debe permitir llevar un registro de los distintos proveedores y su clasificación (medios de transporte,
hospedajes o guías turísticos), los paquetes de turismo y cómo están compuestos, los clientes de la agencia y las compras
que realiza cada cliente.

A fin de mes el administrador de SunBeach necesita un informe que contenga un listado de todas las ventas realizadas,
organizadas por destino.

También quiere conocer cuál es el destino favorito por sus clientes. SunBeach también requiere de un informe que contenga
los datos de todos los proveedores para poder ubicarlos al momento de realizar los paquetes.

Nota: SunBeach siempre espera a completar con la cantidad de clientes máxima el paquete turístico.

Actividades
    1 - Dada la especificación funcional anterior, construir un diagrama de clases donde quede claro que clases componen
        el sistema, asociaciones, herencia, atributos y métodos que hagan posible cumplir con los requisitos del sistema.
    2 - Una vez armado el diagrama de clases, implemente su solución y genere código para probar que se cumplen las reglas
        de la especificación funcional.
*/
public class AgenciaDeTurismo {
    public static void main (String[] args) {

        GuiaTuristico excursion = new GuiaTuristico("Summer","1234", "123 Santa Street");
        Transporte transporte = new Transporte("Metrobus", "32145", "San Justo y Belgrano", 4);
        Hospedaje hospedaje = new Hospedaje("Los Telmos", "456456", "123 Corrientes", 4);

        Paquete paquete1 = new Paquete("Paquete1", "Pehuajo", transporte, hospedaje, excursion, 10000.0, 4);
        Paquete paquete2 = new Paquete("Paquete2", "Montevideo", transporte, hospedaje, excursion, 15000.0, 4);
        Paquete paquete3 = new Paquete("Paquete3", "Montevideo", transporte, hospedaje, excursion, 12000.0, 4);
        Paquete paquete4 = new Paquete("Paquete4", "Cordoba", transporte, hospedaje, excursion, 20000.0, 4);
        Paquete paquete5 = new Paquete("Paquete5", "Bariloche", transporte, hospedaje, excursion, 10000.0, 4);

        List<Paquete> paquetesDelCliente = new ArrayList<>();

        paquetesDelCliente.add(paquete1);
        paquetesDelCliente.add(paquete2);
        paquetesDelCliente.add(paquete3);
        paquetesDelCliente.add(paquete4);
        paquetesDelCliente.add(paquete5);

        Cliente cliente = new Cliente("654231", "Valentin", paquetesDelCliente);

        SistemaDeAgencia sistema = SistemaDeAgencia.obtenerInstancia();

        sistema.altaDeVenta(new Venta(cliente, paquete1));
        sistema.altaDeVenta(new Venta(cliente, paquete2));
        sistema.altaDeVenta(new Venta(cliente, paquete3));
        sistema.altaDeVenta(new Venta(cliente, paquete4));
        sistema.altaDeVenta(new Venta(cliente, paquete5));

        List<Venta> ventasDelMes = sistema.ventasDelMes();

        System.out.println("\n> Las ventas del mes: ");
        for (Venta venta : ventasDelMes)
            System.out.println(venta.toString() + " - Destino: " + venta.getPaquete().getDestino());

        System.out.println("\n> El destino mas popular: " + sistema.destinoPopular());

        sistema.altaDeProveedor(excursion);
        sistema.altaDeProveedor(transporte);
        sistema.altaDeProveedor(hospedaje);

        System.out.println(sistema.resumenDeProveedores());
    }
}
