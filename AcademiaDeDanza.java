
/*
Ejercicio 3: Academia de Danzas
Una famosa academia de Capital Federal decide contratar a una consultora informática para desarrollar
un sistema de información que le permita llevar un control de su gestión administrativa.

La academia dicta distintas disciplinas, de las cuales pueden existir una o más diagramaciones o comisiones.
Por ejemplo, para la disciplina "Tango" existe una diagramación que se dicta los días lunes y viernes, siendo
de un nivel inicial o para principiantes. A su vez, existe otra diagramación para la disciplina "Tango" que se
dicta los martes y sábados, y el nivel es intermedio. Por tanto, una diagramación deberá contar con los
siguientes datos: día y horario, nivel (inicial, intermedio o avanzado), disciplina (ej. Tango, Salsa, Bachata,
Clásico, Stretching, Contemporáneo, Árabe, etc.) y un profesor encargado de dictar la clase.

Las clases o diagramaciones tienen lugar en alguno de los distintos salones que tiene la academia.

La academia cuenta con más de 500 alumnos, los cuales se inscriben a distintas clases o diagramaciones.

Cuando una persona se presenta por primera vez la secretaria toma sus datos personales y de contacto y
lo inscribe a una determina diagramación y le entrega una credencial personal que deberá traer al momento de asistir a clases.

En cada clase, los alumnos deben presentar su credencial en la secretaría, donde la secretaria procede registrar su asistencia.

Mes a mes la academia debe entregar a los profesores un listado de todos los alumnos que asistieron a sus
clases a fin de calcular el importe que se le pagará al profesor (cada profesor cobra $10 por cada día que
un alumno asiste a su clase).

La academia necesita contar con un reporte que indique cuál es la disciplina que le reditúa mayor ingreso a fin
de planificar más diagramaciones de dicha disciplina.

Objetivo:
    * Encontrar los objetos que participan del problema.
    * Definir asociaciones entre los objetos, comportamiento y estructura de cada uno.
    * Validar el modelo construido para garantizar que responde a los requisitos del problema.
*/

import ar.edu.unlu.poo.ej3.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AcademiaDeDanza {
    public static void main (String[] args) {

        Alumno alumno1 = new Alumno("123456", "Juan", "01112 1234 4321", "123@gmail.com");
        Alumno alumno2 = new Alumno("654321", "Nauj", "02323 1590 9510", "465@gmail.com");
        Alumno alumno3 = new Alumno("", "Juan", "01112 1234 4321", "123@gmail.com");

        Profesor profesor = new Profesor("Alberto Empanada", "Tango");
        Profesor profesor1 = new Profesor("Reina Kissinger", "Ballet");

        LocalDateTime horario = LocalDateTime.now();

        Clase clase0 = Clase.crearClase("Tango", horario, profesor, Clase.Nivel.INICIAL);
        Clase clase1 = Clase.crearClase("Ballet", horario, profesor1,Clase.Nivel.AVANZADO);

        List<Asistencia> asistencias = new ArrayList<>();

        asistencias.add(new Asistencia(alumno1, clase0));
        asistencias.add(new Asistencia(alumno2, clase0));
        asistencias.add(new Asistencia(alumno2, clase1));
        asistencias.add(new Asistencia(alumno2, clase0));
        asistencias.add(new Asistencia(alumno3, clase1));

        SistemaDeLaAcademia sistema = SistemaDeLaAcademia.obtenerInstancia(asistencias);

        List<Asistencia> listaDeAsistencia = sistema.listaDeAsistenciasMensual(profesor);

        System.out.println("\n> Listado de asistencias del profesor " + profesor.getNombre());
        for (Asistencia auxiliar : listaDeAsistencia)
            System.out.println(auxiliar.toString());

        System.out.println("\n> Sueldo del profesor " + profesor.getNombre() + ": " + sistema.calcularSueldo(profesor).toString() + " pesos");

        System.out.println("\n> La disciplina mas popular es " + sistema.disciplinaMasPopular());
    }
}
