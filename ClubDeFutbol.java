import ar.edu.unlu.poo.ej1.*;

import java.time.LocalDate;
import java.util.List;

/*
Ejercicio 1: Club de Futbol
Un club deportivo de la ciudad de San Carlos de Bariloche nos contrata para realizar un sistema de información para la gestión de su institución.
El sistema pretende llevar un registro de socios del club. Al momento de la inscripción, el personal a cargo solicita los datos personales y de contacto,
dirección y e-mail de cada socio; generando una credencial con la cual deberá presentarse cuando quiera ingresar a las distintas instalaciones del complejo.

A principio de mes cada socio debe abonar una cuota cuyo valor depende de la suscripción que haya elegido: básica, intermedia y destacada.
Dependiendo de la suscripción adquirida tendrá acceso a solo ciertas actividades para el caso de la suscripción básica, se añaden algunas más para la suscripción intermedia,
y en el caso de la destacada tiene libre acceso a cualquier actividad que quiera realizar.

El sistema debe facilitar los siguientes reportes:
    * Reporte mensual de nuevos socios inscriptos
    * Listado de actividades clasificadas por suscripción (actividades accesibles con la suscripción básica, actividades accesibles con la suscripción intermedia y aquellas que solo puede accederse con la suscripción destacada).
    * Listado de socios clasificados por suscripción adquirida

Objetivo:
    * Encontrar los objetos que participan del problema.
    * Definir asociaciones entre los objetos, comportamiento y estructura de cada uno.
    * Validar el modelo construido para garantizar que responde a los requisitos del problema.
*/
public class ClubDeFutbol {
    public static void main (String[] args) {

        SistemaDelClub administracion = SistemaDelClub.obtenerInstancia();

        administracion.altaDeSocio("Juan", "1234@gmail.com", "Mar de la tranquilidad, Luna", SistemaDelClub.Subscripcion.BASICA);
        administracion.altaDeSocio("Florencia", "4321@gmail.com", "Vecino de la Casa Rosada", SistemaDelClub.Subscripcion.INTERMEDIA);
        administracion.altaDeSocio("Raberto", "UsuarioDeGodot@gmail.com", "123 La Cancha Street", SistemaDelClub.Subscripcion.INTERMEDIA);
        administracion.altaDeSocio("John Futbol", "amoElFutbol@gmail.com", "La Bombonera", SistemaDelClub.Subscripcion.DESTACADA);

        administracion.altaDeActividad("Practica de Futbol 5", "Seminario especial con Bilardo", SistemaDelClub.Subscripcion.INTERMEDIA);
        administracion.altaDeActividad("Practica de Asistencia Hidrica", "Seminario con el aguatero de Bilardo", SistemaDelClub.Subscripcion.BASICA);
        administracion.altaDeActividad("Almuerzo con Messi", "Oportunidad única, 15:00 PM", SistemaDelClub.Subscripcion.DESTACADA);
        administracion.altaDeActividad("Partido Amistoso de Futbol 5", "River vs Colo Colo", SistemaDelClub.Subscripcion.DESTACADA);

        List<Socio> listaDeSubcripcionesMensual = administracion.sociosNuevosMensuales();

        System.out.println("\n> Socios nuevos del mes " + LocalDate.now().getMonth());
        for (Socio socioSubscripto : listaDeSubcripcionesMensual)
            System.out.println(socioSubscripto.credencial());

        List<Socio> listaDeSociosPorSubscripcion = administracion.sociosPorSubscripcion(SistemaDelClub.Subscripcion.INTERMEDIA);

        System.out.println("\n> Socios con subscripcion " + SistemaDelClub.Subscripcion.INTERMEDIA);
        for (Socio socioConSubscripcion : listaDeSociosPorSubscripcion)
            System.out.println(socioConSubscripcion.credencial());

        List<Actividad> listaDeActividades = administracion.actividadesPorSubscripcion(SistemaDelClub.Subscripcion.DESTACADA);

        System.out.println("\n> Actividades de categoria " + SistemaDelClub.Subscripcion.DESTACADA.toString());
        for (Actividad actividad : listaDeActividades)
            System.out.println(actividad.toString());
    }
}
