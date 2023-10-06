import ar.edu.unlu.poo.ej4512.*;

import java.time.LocalDate;

/*
Ejercicio 4
Se requiere implementar un sistema que administre cuentas de billeteras virtuales. Cada cliente tiene una cuenta normal y puede tener una cuenta crédito.
Las cuentas normales tienen un límite de giro en descubierto. Con este tipo de cuentas se puede invertir parte del dinero del saldo que
pasado N días nos dará un interés del 40%. Solo se puede realizar una inversión a la vez. El monto total que puede gastar un usuario
es la suma del saldo disponible y el límite de giro en descubierto. Los giros en descubierto se cubren a medida que el usuario va agregando saldo a la cuenta.

Las cuentas de tipo crédito funcionan de la siguiente manera:
    1 - Las compras no se dividen en cuotas, solo tienen un recargo fijo del 5% sobre el monto total de la compra. El valor final a pagar de una
        compra es el monto + el 5%. El usuario paga a medida que puede el monto que quiere.
    2 - Existe un límite de gasto que se irá decrementando según la cantidad de compras realizadas. El valor que se decrementa es el monto de la compra.
    4 - Cada vez que se realiza el pago se aumenta el límite de compra disponible. El pago de intereses no debería aumentar el límite de compra.

El sistema debe poder mostrarle al usuario:
    1 * Saldo de la cuenta, límite de giro en descubierto, monto invertido (si existe inversión), monto disponible para compras a
        crédito y saldo deudor teniendo en cuenta todas las compras a crédito realizadas.
    2 * Debe poder avisarle al usuario cuando un gasto que intenta realizar lo va a hacer girar en descubierto.

Objetivo:
    * Evaluar calidad de la solución planteada según los 3 conceptos: cohesión, encapsulamiento/contrato y ocultamiento de la información.
      Determinar si se cumplen o no. En la solución se provee el código documentado (sin implementar) y un diagrama de clases.
    * Si creen que no se cumple, pensar un nuevo diseño que respete los 3 conceptos antes de avanzar. En cualquier caso, justificar la respuesta.
    * Implementar la solución.

Ejercicio 5
Ahora queremos agregar una nueva feature a las cuentas. La inversión realizada se puede cancelar en cualquier momento,
pero el interés devuelto no va a ser del 40%, sino solo del 5% si al menos pasaron 30 días. Además, se puede activar la
opción de precancelar automáticamente: cuando un usuario realiza un gasto mayor a su saldo, la inversión se precancela para que
no gire en descubierto (o para que lo haga pero por un monto mucho menor).

Objetivos:
    * Evaluar si el diseño actual me permite de manera sencilla introducir este cambio,
      ¿Se podría mejorar el diseño en términos de encapsulamiento/contrato? ¿Qué pasa con la cohesión y el acoplamiento?
    * Diseñar e implementar, si lo creen necesario, modificaciones que mejoren la cohesión, encapsulamiento/contrato, etc.
    * Implementar los nuevos requisitos pedidos para el sistema.

Ejercicio 12
Refactorizar el Ejercicio 5 de la Parte 1 de esta guía para modelar las cuentas en base un tipo base llamado “Cuenta”.
Decida responsabilidades de las nuevas tres clases. Además, incorpore el concepto de Caja de Ahorro. Una caja de ahorro
funciona de manera similar a una CuentaNormal, pero no permite giro en descubierto.

Se solicita:
    * Modificar el diagrama de clases UML del ejercicio 10 de la guía anterior, para reflejar el nuevo diseño.
    * Modificar el código para implementar los nuevos requisitos.
    * Consulte la bibliografía sobre Clases Abstractas y Métodos Abstractos. Piense qué clases del diseño actual pueden corresponder a esta descripción e implementelo.
    * Evalue otras abstracciones que admitan herencia y clases abstractas. Modelar el diagrama de clases y evaluar ventajas e inconvenientes.
*/
public class BilleterasVirtuales {
    public static  void main (String[] args) {
        Usuario persona = new Usuario("Valentín", "123456", "123@gmail", "987654321");
        CuentaCorriente cuentaCorriente = new CuentaCorriente(-10000.0);
        Billetera nuevaBilletera = new Billetera(persona, cuentaCorriente, null, null);

        System.out.println("\n" + nuevaBilletera.toString());

        Compra compra1 = new Compra("Termotanque", 500.0);
        Compra compra2 = new Compra("Parrilla", 3000.0);

        nuevaBilletera.pagarConCuentaCorriente(compra1, 500.0);
        nuevaBilletera.pagarConCuentaCorriente(compra2, 500.0);

        System.out.println("\n" + nuevaBilletera.toString());

        Transferencia transferencia = new Transferencia(10000.0);
        System.out.println("\n" + transferencia.toString());

        System.out.println(" > Invirtiendo 2000 pesos . . .");
        nuevaBilletera.ingresarACuentaCorriente(transferencia);
        nuevaBilletera.invertir(LocalDate.now().plusDays(5), 2000.0);

        System.out.println("\n" + nuevaBilletera.toString());
    }
}
